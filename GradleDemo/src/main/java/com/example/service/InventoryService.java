package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.bean.DataGrid;
import com.example.ctrl.model.WInfo;
import com.example.mapper.InventoryDoMapper;
import com.example.mapper.ProinDoMapper;
import com.example.mapper.dao.InventoryDo;
import com.example.mapper.dao.InventoryDoExample;
import com.example.mapper.dao.ManufacturerDo;
import com.example.mapper.dao.ProinDo;

/**
 * 库存
 * @author Administrator
 *
 */
@Service
public class InventoryService {
	
	@Autowired
	private ProinDoMapper proinDoMapper;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private InventoryDoMapper inventoryDoMapper;
	/**
	 * 保存库存信息
	 */
	public void saveInventory(InventoryDo inventoryDo){
		inventoryDoMapper.insertSelective(inventoryDo);
	}
	/**
	 * 查找库存信息
	 */
	public List<InventoryDo> findAll(){
		return inventoryDoMapper.selectByExample(new InventoryDoExample());
	}
	/**
	 * 药品编号查询库存
	 */
	public InventoryDo selectByMedicineId(Long medicineId){
		InventoryDoExample example = new InventoryDoExample();
		example.createCriteria().andMedicineIdEqualTo(medicineId);
		 List<InventoryDo> list = inventoryDoMapper.selectByExample(example);
		 if(!list.isEmpty()){
			 return list.get(0);
		 }
		return null;
	}
	
	/**
	 * 更新库存信息
	 */
	public void updateByByPrimaryKey(InventoryDo inventoryDo){
		inventoryDoMapper.updateByPrimaryKey(inventoryDo);
	}
	
	/**
	 * 删除库存 
	 */
	public void deleteByByPrimaryKey(InventoryDo inventoryDo){
		inventoryDoMapper.updateByPrimaryKey(inventoryDo);
	}
	
	
	/**
	 * 分页查询库存信息
	 * @param medicineId
	 * @param medicineName
	 * @param inputTime
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public DataGrid<WInfo> inventoryInfoQuery(Integer medicineId, String medicineName, String inputTime,
			Integer pageSize, Integer currentPage) {
		int count = inventoryDoMapper.inventoryInfoQueryCount(medicineId, medicineName, inputTime);
		if(count==0){
			return new DataGrid<>(pageSize, currentPage, count, new ArrayList<WInfo>());
		}
		
		List<InventoryDo> inventoryDos = inventoryDoMapper.inventoryInfoQuery(medicineId, medicineName, inputTime, pageSize,  pageSize * (currentPage - 1));
		List<WInfo> wInfos = new ArrayList<>();
		for(InventoryDo inventoryDo:inventoryDos){
			WInfo wInfo = new WInfo();
			wInfo.setMedicineId(inventoryDo.getMedicineId());
			wInfo.setMedicineName(inventoryDo.getMedicineName());
			wInfo.setLimited(inventoryDo.getLimited());
			wInfo.setBatchNumber(inventoryDo.getBatchNumber());
			wInfo.setInventory_number(inventoryDo.getNumber());
			ProinDo proinDo = proinDoMapper.selectByPrimaryKey(inventoryDo.getMedicineId());
			wInfo.setInputtime(proinDo.getInputtime());
			ManufacturerDo manufacturerDo = manufacturerService.findByPrimaryKey(inventoryDo.getManufacturerId());
			wInfo.setManufacturerName(manufacturerDo.getManufacturerName());
			wInfos.add(wInfo);
			}
		return  new DataGrid<>(pageSize, currentPage, count,wInfos);
	}
}
