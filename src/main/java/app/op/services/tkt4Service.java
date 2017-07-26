package app.op.services;

import java.util.List;

import app.op.model.OpTkt4;
import app.op.model.Opt;

public interface tkt4Service {

	public int addDataBatch(List<OpTkt4> list);
	
	public int insert(OpTkt4 opTkt4); 
	
	public List<Integer> selectCount();
	
	List<Opt> custer(List<OpTkt4> opList,Double a,Double b);
	
	OpTkt4 setModel(Double fh,Double yql,Double inso2,Double outso2,Double shs,Double ph);
	
	List<OpTkt4> getDataByFh(Double fh1,Double fh2);
}
