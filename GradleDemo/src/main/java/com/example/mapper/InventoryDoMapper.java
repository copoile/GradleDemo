package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mapper.dao.InventoryDo;
import com.example.mapper.dao.InventoryDoExample;

public interface InventoryDoMapper {
    int countByExample(InventoryDoExample example);

    int deleteByExample(InventoryDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InventoryDo record);

    int insertSelective(InventoryDo record);

    List<InventoryDo> selectByExample(InventoryDoExample example);

    InventoryDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InventoryDo record, @Param("example") InventoryDoExample example);

    int updateByExample(@Param("record") InventoryDo record, @Param("example") InventoryDoExample example);

    int updateByPrimaryKeySelective(InventoryDo record);

    int updateByPrimaryKey(InventoryDo record);

	int inventoryInfoQueryCount(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName, @Param(value="inputTime")String inputTime);

	List<InventoryDo> inventoryInfoQuery(@Param(value="medicineId")Integer medicineId, @Param(value="medicineName")String medicineName, @Param(value="inputTime")String inputTime,
					@Param(value = "limit") Integer limit,@Param(value = "offset") Integer offset);
}