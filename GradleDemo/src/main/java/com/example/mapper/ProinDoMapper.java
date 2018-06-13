package com.example.mapper;

import com.example.mapper.dao.ProinDo;
import com.example.mapper.dao.ProinDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProinDoMapper {
    int countByExample(ProinDoExample example);

    int deleteByExample(ProinDoExample example);

    int deleteByPrimaryKey(Long medicineId);

    int insert(ProinDo record);

    int insertSelective(ProinDo record);

    List<ProinDo> selectByExample(ProinDoExample example);

    ProinDo selectByPrimaryKey(Long medicineId);

    int updateByExampleSelective(@Param("record") ProinDo record, @Param("example") ProinDoExample example);

    int updateByExample(@Param("record") ProinDo record, @Param("example") ProinDoExample example);

    int updateByPrimaryKeySelective(ProinDo record);

    int updateByPrimaryKey(ProinDo record);

	int inputInfoQueryCount(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName, @Param(value="inputtime")String inputtime);

	List<ProinDo> inputInfoQuery(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName, @Param(value="inputtime")String inputtime,
				@Param(value = "limit") Integer limit,@Param(value = "offset") Integer offset);
}