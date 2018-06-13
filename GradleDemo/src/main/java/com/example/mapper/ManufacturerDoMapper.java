package com.example.mapper;

import com.example.mapper.dao.ManufacturerDo;
import com.example.mapper.dao.ManufacturerDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturerDoMapper {
    int countByExample(ManufacturerDoExample example);

    int deleteByExample(ManufacturerDoExample example);

    int deleteByPrimaryKey(Long manufacturerId);

    int insert(ManufacturerDo record);

    int insertSelective(ManufacturerDo record);

    List<ManufacturerDo> selectByExample(ManufacturerDoExample example);

    ManufacturerDo selectByPrimaryKey(Long manufacturerId);

    int updateByExampleSelective(@Param("record") ManufacturerDo record, @Param("example") ManufacturerDoExample example);

    int updateByExample(@Param("record") ManufacturerDo record, @Param("example") ManufacturerDoExample example);

    int updateByPrimaryKeySelective(ManufacturerDo record);

    int updateByPrimaryKey(ManufacturerDo record);

	int manufacturerInfoQueryCount(@Param("manufacturerName")String manufacturerName);

	List<ManufacturerDo> manufacturerInfoQuery(@Param("manufacturerName")String manufacturerName, @Param(value = "limit")Integer limit, @Param(value = "offset") Integer offset);
}