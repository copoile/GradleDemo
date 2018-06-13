package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mapper.dao.ProOutDo;
import com.example.mapper.dao.ProOutDoExample;

public interface ProOutDoMapper {
    int countByExample(ProOutDoExample example);

    int deleteByExample(ProOutDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProOutDo record);

    int insertSelective(ProOutDo record);

    List<ProOutDo> selectByExample(ProOutDoExample example);

    ProOutDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProOutDo record, @Param("example") ProOutDoExample example);

    int updateByExample(@Param("record") ProOutDo record, @Param("example") ProOutDoExample example);

    int updateByPrimaryKeySelective(ProOutDo record);

    int updateByPrimaryKey(ProOutDo record);
    
    
    int outInfoQueryCount(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName, @Param(value="outputTime")String outputTime);

	List<ProOutDo> outInfoQuery(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName, @Param(value="outputTime")String outputTime,
				@Param(value = "limit") Integer limit,@Param(value = "offset") Integer offset);
	
	 int outInfoQueryCount2(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName);

		List<ProOutDo> outInfoQuery2(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName,
					@Param(value = "limit") Integer limit,@Param(value = "offset") Integer offset);
}