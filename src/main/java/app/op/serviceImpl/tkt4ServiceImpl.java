package app.op.serviceImpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.op.dao.OpTkt4Mapper;
import app.op.dao.Tkt4Custom;
import app.op.dto.tktValue;
import app.op.model.OpTkt4;
import app.op.model.OpTkt4Example;
import app.op.model.Opt;
import app.op.services.tkt4Service;

@Service("tkt4ServiceImpl")
public class tkt4ServiceImpl implements tkt4Service{

	@Autowired
	public Tkt4Custom tkt;
	
	@Autowired
	private OpTkt4Mapper tktMapper;
	
	
	@Override
	public int addDataBatch(List<OpTkt4> list){
		return tkt.addDataBatch(list);
	}
	
	@Override
	public int insert(OpTkt4 opTkt4){
		return tkt.insert(opTkt4);
	}
	
	@Override
	public List<Integer> selectCount(){
		return null;
	}
	
	//聚类算法实现
	@Override
	public List<Opt> custer(List<OpTkt4> opList,Double a,Double b){
		//查询阶段数据
		DecimalFormat df = new DecimalFormat("#.00");
		Double temp = 5.00;
		List<OpTkt4> list = new ArrayList<OpTkt4>();
		List<OpTkt4> opList2 = new ArrayList<OpTkt4>();
		List<tktValue> aveList = new ArrayList<tktValue>();
		OpTkt4Example optkt = new OpTkt4Example();
		OpTkt4Example.Criteria criteria = optkt.createCriteria();
		criteria.andCe1GreaterThan(temp);
		criteria.andCe2GreaterThan(temp);
		criteria.andCe3GreaterThan(temp);
		criteria.andCe4LessThan(temp);
		criteria.andFhGreaterThan(a);
		criteria.andFhLessThan(b);
		list = tktMapper.selectByExample(optkt);
		//循环基准值求方差
		aveList = toAve(list,opList);
		opList2 = toAveList(aveList);
		//基准值判断大小
		List<Double> dd = new ArrayList<Double>();
		for(int i=0;i<opList2.size();i++){
			dd.add(getAveOpList(opList.get(i), opList2.get(i)));
		}
		//循环
		int ccc = 0;
		while(dd.get(0)>0.01 || dd.get(1)>0.01 || dd.get(2)>0.01){
			opList = opList2;
			aveList = toAve(list,opList2);
			opList2 = toAveList(aveList);
			dd = new ArrayList<Double>();
			for(int i=0;i<opList2.size();i++){
				dd.add(getAveOpList(opList.get(i), opList2.get(i)));
			}
			ccc++;
		}
		int c[] = getCount(aveList);
		//转换optList
		List<Opt> optList = new ArrayList<Opt>();
		int i=0;
		for(OpTkt4 t:opList2){
			
			Opt opt = new Opt();
			opt.setFh(Double.parseDouble(df.format(t.getFh())));
			opt.setYql(Double.parseDouble(df.format(t.getYql())));
			opt.setShs(Double.parseDouble(df.format(t.getShs())));
			opt.setPh(Double.parseDouble(df.format(t.getPh())));
			opt.setInso2(Double.parseDouble(df.format(t.getInso2())));
			opt.setOutso2(Double.parseDouble(df.format(t.getOutso2())));
			opt.setXl(Double.parseDouble(df.format((t.getInso2()-t.getOutso2())/t.getInso2()*100)));
			opt.setXll(Double.parseDouble(df.format((t.getInso2()-30.00)/t.getInso2()*100)));
			opt.setCount(c[i]);
			opt.setCe1(Double.parseDouble(df.format(t.getCe1())));
			opt.setCe2(Double.parseDouble(df.format(t.getCe2())));
			opt.setCe3(Double.parseDouble(df.format(t.getCe3())));
			opt.setCe4(Double.parseDouble(df.format(t.getCe4())));
			optList.add(opt);
			i++;
		}
//		System.out.println(c[0]+","+c[1]+","+c[2]);
//		System.out.println(ccc);
		return optList;
	}
	//循环求多条基准值
	public List<tktValue> toAve(List<OpTkt4> list,List<OpTkt4> opList){
		double d;
		List<tktValue> finalList = new ArrayList<tktValue>();
		Map<Double,Integer> aveMap = new HashMap<Double,Integer>();
		for(int i=0;i<list.size();i++){
			//每次循环分别与三个基准值计算
			for(int j=0;j<opList.size();j++){
				//方差参数添加进map,再找出最小数
				d = variance(list.get(i),opList.get(j));
				aveMap.put(d,j);
			}
			//加入最终数组
			finalList.add(modelToDto(list.get(i),queryMin(aveMap)));
			aveMap = new HashMap<Double,Integer>();//清空
		}
		for(int i=0;i<opList.size();i++){
			finalList.add(modelToDto(opList.get(i),i));
		}
		return finalList;
	}
	
	//求方差
	public double variance(OpTkt4 t1,OpTkt4 t2){
		//要加归一化处理
		DecimalFormat df = new DecimalFormat("#.00");  
		double d = Double.parseDouble(df.format(Math.pow((t1.getFh()-t2.getFh())/320.00,2) + 
					Math.pow((t1.getYql()-t2.getYql())/2000.00, 2) + 
					Math.pow((t1.getShs()-t2.getShs())/220.00, 2) +
					Math.pow((t1.getInso2()-t2.getInso2())/4500.00, 2) +
					Math.pow((t1.getOutso2()-t2.getOutso2())/300.00, 2) +
					Math.pow((t1.getPh()-t2.getPh())/11.00, 2)/6));
		return d;
	}
	//比较大小,升序获取最小值的Map
	public Integer queryMin(Map<Double,Integer> aveMap){
		List<Double> list = new ArrayList<Double>();
		Map<Double,Integer> map = new HashMap<Double,Integer>();
		Double temp;
		for(Double key : aveMap.keySet()){ 
            list.add(key);
        }
		for(int i=list.size();i>0;i--){
			for(int j=0;j<list.size()-1;j++){
				if(list.get(j)>list.get(j+1)){
					temp = list.get(j).doubleValue();
					list.set(j,list.get(j+1).doubleValue());
					list.set(j+1, temp);
				}
			}
		}
		Integer value = aveMap.get(list.get(0));
		return value;
	}
	//model转换dto
	public tktValue modelToDto(OpTkt4 v1,Integer groupId){
		tktValue v2 = new tktValue();
		v2.setId(v1.getId());
		v2.setFh(v1.getFh());
		v2.setInso2(v1.getInso2());
		v2.setOutso2(v1.getOutso2());
		v2.setShs(v1.getShs());
		v2.setPh(v1.getPh());
		v2.setYql(v1.getYql());
		v2.setGroupId(groupId);
		v2.setCe1(v1.getCe1());
		v2.setCe2(v1.getCe2());
		v2.setCe3(v1.getCe3());
		v2.setCe4(v1.getCe4());
		return v2;
	}
	//dto转换model
	public OpTkt4 dtoToModel(tktValue v1){
		OpTkt4 v2 = new OpTkt4();
		v2.setId(v1.getId());
		v2.setFh(v1.getFh());
		v2.setInso2(v1.getInso2());
		v2.setOutso2(v1.getOutso2());
		v2.setShs(v1.getShs());
		v2.setPh(v1.getPh());
		v2.setYql(v1.getYql());
		return v2;
	}
	/* 求平均值  */
	public List<OpTkt4> toAveList(List<tktValue> list){
		int[] c = new int[]{0,0,0};
		Double[] fh = new Double[]{0.00,0.00,0.00};
		Double[] in = new Double[]{0.00,0.00,0.00};
		Double[] out = new Double[]{0.00,0.00,0.00};
		Double[] shs = new Double[]{0.00,0.00,0.00};
		Double[] yql = new Double[]{0.00,0.00,0.00};
		Double[] ph = new Double[]{0.00,0.00,0.00};
		Double[] ce1 = new Double[]{0.00,0.00,0.00};
		Double[] ce2 = new Double[]{0.00,0.00,0.00};
		Double[] ce3 = new Double[]{0.00,0.00,0.00};
		Double[] ce4 = new Double[]{0.00,0.00,0.00};
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getGroupId()==0){
				fh[0] += list.get(i).getFh();
				in[0] += list.get(i).getInso2();
				out[0] += list.get(i).getOutso2();
				shs[0] += list.get(i).getShs();
				yql[0] += list.get(i).getYql();
				ph[0] += list.get(i).getPh();
				ce1[0] += list.get(i).getCe1();
				ce2[0] += list.get(i).getCe2();
				ce3[0] += list.get(i).getCe3();
				ce4[0] += list.get(i).getCe4();
				c[0]+= 1;
			}else if(list.get(i).getGroupId()==1){
				fh[1] += list.get(i).getFh();
				in[1] += list.get(i).getInso2();
				out[1] += list.get(i).getOutso2();
				shs[1] += list.get(i).getShs();
				yql[1] += list.get(i).getYql();
				ph[1] += list.get(i).getPh();
				ce1[1] += list.get(i).getCe1();
				ce2[1] += list.get(i).getCe2();
				ce3[1] += list.get(i).getCe3();
				ce4[1] += list.get(i).getCe4();
				c[1]+= 1;
			}else if(list.get(i).getGroupId()==2){
				fh[2] += list.get(i).getFh();
				in[2] += list.get(i).getInso2();
				out[2] += list.get(i).getOutso2();
				shs[2] += list.get(i).getShs();
				yql[2] += list.get(i).getYql();
				ph[2] += list.get(i).getPh();
				ce1[2] += list.get(i).getCe1();
				ce2[2] += list.get(i).getCe2();
				ce3[2] += list.get(i).getCe3();
				ce4[2] += list.get(i).getCe4();
				c[2]+= 1;
			}
		}
		List<OpTkt4> opList = new ArrayList<OpTkt4>();
		for(int i=0;i<3;i++){
			OpTkt4 op = new OpTkt4();
			op.setFh(fh[i]/c[i]);
			op.setInso2(in[i]/c[i]);
			op.setOutso2(out[i]/c[i]);
			op.setShs(shs[i]/c[i]);
			op.setYql(yql[i]/c[i]);
			op.setPh(ph[i]/c[i]);
			op.setCe1(ce1[i]/c[i]);
			op.setCe2(ce2[i]/c[i]);
			op.setCe3(ce3[i]/c[i]);
			op.setCe4(ce4[i]/c[i]);
			opList.add(op);
		}
		return opList;
	}
	
	//判断两个基准值
	public Double getAveOpList(OpTkt4 t1,OpTkt4 t2){
		Double d = (Math.abs(t1.getFh()-t2.getFh())/t1.getFh()+
				Math.abs(t1.getInso2()-t2.getInso2())/t1.getInso2()+
				Math.abs(t1.getOutso2()-t2.getOutso2())/t1.getOutso2()+
				Math.abs(t1.getShs()-t2.getShs())/t1.getShs()+
				Math.abs(t1.getYql()-t2.getYql())/t1.getYql()+
				Math.abs(t1.getPh()-t2.getPh())/t1.getPh())/6;
		return d;
	}
	//所属条数
	public int[] getCount(List<tktValue> list){
		int c[] = new int[]{0,0,0};
		for(tktValue t:list){
			if(t.getGroupId()==0){
				c[0]+=1;
			}else if(t.getGroupId()==1){
				c[1]+=1;
			}else if(t.getGroupId()==2){
				c[2]+=1;
			}
		}
		return c;
	}
	
	@Override
	public OpTkt4 setModel(Double fh,Double yql,Double inso2,Double outso2,Double shs,Double ph){
		OpTkt4 op = new OpTkt4();
		op.setFh(fh);
		op.setYql(yql);
		op.setInso2(inso2);
		op.setOutso2(outso2);
		op.setShs(shs);
		op.setPh(ph);
		return op;
	}
	
	@Override
	public List<OpTkt4> getDataByFh(Double fh1,Double fh2){
		Double temp = 5.00;
		List<OpTkt4> list = new ArrayList<OpTkt4>();
		List<OpTkt4> list1 = new ArrayList<OpTkt4>();
		
		OpTkt4Example optkt = new OpTkt4Example();
		OpTkt4Example.Criteria criteria = optkt.createCriteria();
		criteria.andCe1GreaterThan(temp);
		criteria.andCe2GreaterThan(temp);
		criteria.andCe3GreaterThan(temp);
		criteria.andCe4LessThan(temp);
		criteria.andFhGreaterThan(fh1);
		criteria.andFhLessThan(fh2);
		list = tktMapper.selectByExample(optkt);
		
		if(list.size()>=3){
			for(int i=0;i<3;i++){
				list1.add(list.get(i));
			}
		}else{
			System.out.println("不合格"+fh1);
		}
		System.out.println(list.get(0).getFh()+","+list1.get(1).getFh()+","+list1.get(2).getFh());
		return list1;
		
	}
}
