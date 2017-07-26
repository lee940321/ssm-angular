package app.op.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import app.op.model.OpTkt4;
import app.op.services.tkt4Service;
import magustek.net.OPConnect;
import magustek.net.OPHisData;
import magustek.net.OPNetConst;
import magustek.net.exception.io.UsersException;

@Controller("tkt4Controller")
public class tkt4Controller {
	
	
	public static void main(String[] args) throws ParseException, IOException, UsersException{
		OPConnect conn=new OPConnect("192.168.5.162",8200,6000,"sis","openplant");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#.00");  
		List<OpTkt4> list = new ArrayList<OpTkt4>();
		List<Double> dataList = new ArrayList<Double>();
		OpTkt4 model = new OpTkt4();
		String []pointNames = {"W3.FGD34.N40GROSSMW","W3.FGD34.N4CHUKOULIULIANG","W3.FGD34.N40BBA29CE001",
				"W3.FGD34.N40BBA31AI2","W3.FGD34.N40BBA30CE001","W3.FGD34.N40BBB28CE001","W3.FGD34.N4HTA10CQ001",
				"W3.FGD34.N4HTA10CQ005","W3.FGD34.N4HTJ10CF001","W3.FGD34.N4HTL10CQ001"};
		
		Date from=DateFormat.getDateTimeInstance().parse("2016-6-1 0:0:0");
		Date to=DateFormat.getDateTimeInstance().parse("2016-12-1 0:0:0");
		
		Map<String, OPHisData[]> map=conn.getPointHistorys(pointNames, from, to, OPNetConst.HISTORY_DATA_SPAN,300);
		//纵向存储数据
		for (int i = 0; i < pointNames.length; i++) {
			OPHisData[] ophs = map.get(pointNames[i]);
			for (int j = 0; j < ophs.length; j++) {
				dataList.add(ophs[j].getAV());
			}
		}
		
		//转储list
		OPHisData[] test = map.get(pointNames[0]);
		int count = test.length;
		System.out.println(count);
		
		for(int i=0;i<count;i++){
			model = new OpTkt4();
			model.setDate(sdf.format(new Date(test[i].getTime())));
			model.setFh(Double.parseDouble(df.format(dataList.get(i))));
			model.setYql(Double.parseDouble(df.format(dataList.get(i+count))));
			model.setCe1(Double.parseDouble(df.format(dataList.get(i+2*count))));
			model.setCe2(Double.parseDouble(df.format(dataList.get(i+3*count))));
			model.setCe3(Double.parseDouble(df.format(dataList.get(i+4*count))));
			model.setCe4(Double.parseDouble(df.format(dataList.get(i+5*count))));
			model.setInso2(Double.parseDouble(df.format(dataList.get(i+6*count))));
			model.setOutso2(Double.parseDouble(df.format(dataList.get(i+7*count))));
			model.setShs(Double.parseDouble(df.format(dataList.get(i+8*count))));
			model.setPh(Double.parseDouble(df.format(dataList.get(i+9*count))));
			
			list.add(model);
		}
		System.out.println(list.size());
		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getDate()+","+list.get(i).getFh()+","+list.get(i).getYql()+
//					","+list.get(i).getCe1()+","+list.get(i).getCe2()+","+list.get(i).getCe3()+
//					","+list.get(i).getCe4()+","+list.get(i).getInso2()+","+list.get(i).getOutso2()+
//					","+list.get(i).getShs()+","+list.get(i).getPh());
//		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		tkt4Service tkt=(tkt4Service)context.getBean("tkt4ServiceImpl");
		tkt.addDataBatch(list);
		System.out.println("operate success!");
		conn.close();
	}
}
