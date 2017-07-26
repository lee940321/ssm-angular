package app.op.dao;

import app.op.model.OpTkt4;
import app.op.model.OpTkt4Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpTkt4Mapper {
    int countByExample(OpTkt4Example example);

    int deleteByExample(OpTkt4Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpTkt4 record);

    int insertSelective(OpTkt4 record);

    List<OpTkt4> selectByExample(OpTkt4Example example);

    OpTkt4 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpTkt4 record, @Param("example") OpTkt4Example example);

    int updateByExample(@Param("record") OpTkt4 record, @Param("example") OpTkt4Example example);

    int updateByPrimaryKeySelective(OpTkt4 record);

    int updateByPrimaryKey(OpTkt4 record);
}