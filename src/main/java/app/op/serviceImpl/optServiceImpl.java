package app.op.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.op.dao.OptMapper;
import app.op.model.Opt;
import app.op.services.optService;

@Service("optServiceImpl")
public class optServiceImpl implements optService {

	@Autowired
	private OptMapper optMapper;
	
	@Override
	public int addBacth(List<Opt> list){
		return optMapper.addBatch(list);
	}
	

}
