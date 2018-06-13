package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.bean.DataGrid;
import com.example.common.excption.MyRunTimeExcption;
import com.example.mapper.ManufacturerDoMapper;
import com.example.mapper.dao.ManufacturerDo;
import com.example.mapper.dao.ManufacturerDoExample;
import com.example.mapper.dao.ManufacturerDoExample.Criteria;
/**
 * 厂商
 * @author Administrator
 *
 */
@Service
public class ManufacturerService {
	@Autowired
	private ManufacturerDoMapper manufacturerDoMapper;
	/**
	 * 保存厂商
	 */
	public void savemanufacture(ManufacturerDo manufacturerDo){
		manufacturerDoMapper.insert(manufacturerDo);
	}
	/**
	 * 通过厂商名称查找厂商信息
	 */
	public ManufacturerDo findManufacture(String manufacturerName){
		ManufacturerDoExample example=new ManufacturerDoExample();
		Criteria criteria = example.createCriteria();
		criteria.andManufacturerNameLike(manufacturerName);
		List<ManufacturerDo> manufacturerDo = manufacturerDoMapper.selectByExample(example);
		if (manufacturerDo.isEmpty() || manufacturerDo.get(0) == null) {
			throw new MyRunTimeExcption("没有查找到药品");
		}
		return manufacturerDo.get(0);
	}
	
	/**
	 * 主键查询厂商
	 * @param manufacturerId
	 * @return
	 */
	public ManufacturerDo findByPrimaryKey(Long manufacturerId){
		 return manufacturerDoMapper.selectByPrimaryKey(manufacturerId);
	}
	
	
	/**
	 * 查找所有厂商
	 * @return
	 */
	public List<ManufacturerDo> findAll(){
		return manufacturerDoMapper.selectByExample(new ManufacturerDoExample());
	}
	/**
	 * 分页厂商查询
	 * @param manufacturerName
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public DataGrid<ManufacturerDo> manufacturerInfoQuery(String manufacturerName, Integer pageSize,
			Integer currentPage) {
		int count = manufacturerDoMapper.manufacturerInfoQueryCount(manufacturerName);
		if(count==0){
			return new DataGrid<>(pageSize, currentPage, count, new ArrayList<ManufacturerDo>());
		}
		
		List<ManufacturerDo> customerDos = manufacturerDoMapper.manufacturerInfoQuery(manufacturerName, pageSize,  pageSize * (currentPage - 1));
		return  new DataGrid<>(pageSize, currentPage, count,customerDos);
	}
}
