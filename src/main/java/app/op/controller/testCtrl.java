package app.op.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import app.op.model.OpTkt4;
import app.op.model.Opt;
import app.op.services.optService;
import app.op.services.tkt4Service;
public class testCtrl {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		tkt4Service tkt=(tkt4Service)context.getBean("tkt4ServiceImpl");
		List<OpTkt4> opList = new ArrayList<OpTkt4>();
		
		//存储数组
		List<Opt> optList = new ArrayList<Opt>();
		List<Opt> list = new ArrayList<Opt>();
		Double fh = 300.00;
		Double fh1;
		for(;fh<605.00;fh=fh+5.00){
			fh1 = fh+5.00;
			opList=tkt.getDataByFh(fh,fh1);
			
			optList = tkt.custer(opList,fh,fh1);
			while((optList.get(0).getCount()+optList.get(1).getCount()+optList.get(2).getCount())<=110){
				fh1 = fh1+5.00;
				opList=tkt.getDataByFh(fh,fh1);
				optList = tkt.custer(opList,fh,fh1);
			}
			fh = fh1;
			//遍历添加
			for(Opt t:optList){
				t.setTeam("ABC");
				list.add(t);
			}
			for(int i=1;i<list.size()+1;i++){
				System.out.print(list.get(i-1).getCount()+",");
				if(i%3==0){
					System.out.println("---");
				}
			}
		}
		
		optService opts=(optService)context.getBean("optServiceImpl");
		opts.addBacth(list);
	}

}
