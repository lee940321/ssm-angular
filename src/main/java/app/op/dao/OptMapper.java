package app.op.dao;

import app.op.model.Opt;
import app.op.model.OptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptMapper {
    int countByExample(OptExample example);

    int deleteByExample(OptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Opt record);

    int insertSelective(Opt record);

    List<Opt> selectByExample(OptExample example);

    Opt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Opt record, @Param("example") OptExample example);

    int updateByExample(@Param("record") Opt record, @Param("example") OptExample example);

    int updateByPrimaryKeySelective(Opt record);

    int updateByPrimaryKey(Opt record);
    
    //batch
    int addBatch(List<Opt> list);
}