package com.example.mapper;

import com.example.mapper.dao.CustomerDo;
import com.example.mapper.dao.CustomerDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerDoMapper {
    int countByExample(CustomerDoExample example);

    int deleteByExample(CustomerDoExample example);

    int deleteByPrimaryKey(Long customerId);

    int insert(CustomerDo record);

    int insertSelective(CustomerDo record);

    List<CustomerDo> selectByExample(CustomerDoExample example);

    CustomerDo selectByPrimaryKey(Long customerId);

    int updateByExampleSelective(@Param("record") CustomerDo record, @Param("example") CustomerDoExample example);

    int updateByExample(@Param("record") CustomerDo record, @Param("example") CustomerDoExample example);

    int updateByPrimaryKeySelective(CustomerDo record);

    int updateByPrimaryKey(CustomerDo record);

	int customerInfoQueryCount(@Param("customerName")String customerName);

	List<CustomerDo> customerInfoQuery(@Param("customerName")String customerName, @Param(value = "limit")Integer limit, @Param(value = "offset") Integer offset);
}