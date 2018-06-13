package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.bean.DataGrid;
import com.example.common.excption.MyRunTimeExcption;
import com.example.mapper.CustomerDoMapper;
import com.example.mapper.dao.CustomerDo;
import com.example.mapper.dao.CustomerDoExample;
import com.example.mapper.dao.CustomerDoExample.Criteria;

/**
 * 客户
 * @author Administrator
 *
 */
@Service
public class CustomerService {
	@Autowired
	private CustomerDoMapper customerDoMapper;
	/**
	 * 保存客户
	 */
	public void savecustomer(CustomerDo customerDo){
		customerDoMapper.insert(customerDo);
	}
	/**
	 * 通过客户名称查找客户信息
	 */
	public List<CustomerDo> findCustomer(String customerName){
		CustomerDoExample example=new CustomerDoExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustomerNameLike(customerName);
		List<CustomerDo> customerDo = customerDoMapper.selectByExample(example);
		if (customerDo.isEmpty() || customerDo.get(0) == null) {
			throw new MyRunTimeExcption("没有查找到客户信息");
		}
		return customerDo;
	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public List<CustomerDo> findAll(){
		return customerDoMapper.selectByExample( new CustomerDoExample());
		
	}
	
	/**
	 * 主键查询客户
	 * @param customerId
	 * @return
	 */
	public CustomerDo findByPrimaryKey(Long customerId){
		return customerDoMapper.selectByPrimaryKey(customerId);
		
	}
	/**
	 * 分页查出客户
	 * @param customerName
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public DataGrid<CustomerDo> customerInfoQuery(String customerName, Integer pageSize, Integer currentPage) {
		int count = customerDoMapper.customerInfoQueryCount(customerName);
		if(count==0){
			return new DataGrid<>(pageSize, currentPage, count, new ArrayList<CustomerDo>());
		}
		
		List<CustomerDo> customerDos = customerDoMapper.customerInfoQuery(customerName, pageSize,  pageSize * (currentPage - 1));
		return  new DataGrid<>(pageSize, currentPage, count,customerDos);
	}
}
