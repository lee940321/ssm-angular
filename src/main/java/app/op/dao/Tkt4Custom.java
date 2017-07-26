package app.op.dao;

import java.util.List;

import app.op.model.OpTkt4;

public interface Tkt4Custom {

	//批量插入
	int addDataBatch(List<OpTkt4> list);
	
	
	int insert(OpTkt4 tkt); 
	
}
