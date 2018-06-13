package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.bean.DataGrid;
import com.example.common.excption.MyRunTimeExcption;
import com.example.ctrl.model.WInfo;
import com.example.mapper.ProOutDoMapper;
import com.example.mapper.ProinDoMapper;
import com.example.mapper.dao.CustomerDo;
import com.example.mapper.dao.InventoryDo;
import com.example.mapper.dao.ProOutDo;
import com.example.mapper.dao.ProinDo;

/**
 * 出库
 * @author Administrator
 *
 */
@Service
@Transactional
public class ProOutService {
	@Autowired
	private ProOutDoMapper proOutDoMapper;
	
	@Autowired
	private ProinDoMapper proinDoMapper;

	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private CustomerService customerService;

	/**
	 * 保存出库信息&更新库存
	 */
	public void saveOutput(ProOutDo proOutDo) {
		InventoryDo inventoryDo = inventoryService.selectByMedicineId(proOutDo.getMedicineId());
		Integer outnumber = proOutDo.getNumber();
		Integer savenumber = inventoryDo.getNumber();
		if (outnumber > savenumber) {
			throw new MyRunTimeExcption("当前药品库存数量仅剩" + savenumber);
		}
		proOutDo.setMedicineName(inventoryDo.getMedicineName());
		proOutDoMapper.insertSelective(proOutDo);
		inventoryDo.setNumber(savenumber - outnumber);
		inventoryService.updateByByPrimaryKey(inventoryDo);

	}

	/**
	 * 分页出库信息
	 * @param medicineId
	 * @param medicineName
	 * @param outputTime
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public DataGrid<WInfo> outInfoQuery(Integer medicineId, String medicineName, String outputTime, Integer pageSize,
			Integer currentPage) {
		int count = proOutDoMapper.outInfoQueryCount(medicineId, medicineName, outputTime);
		if(count==0){
			return new DataGrid<>(pageSize, currentPage, count, new ArrayList<WInfo>());
		}
		
		List<ProOutDo> proOutDos = proOutDoMapper.outInfoQuery(medicineId, medicineName, outputTime, pageSize,  pageSize * (currentPage - 1));
		List<WInfo> wInfos = new ArrayList<>();
		for(ProOutDo proOutDo:proOutDos){
			WInfo wInfo = new WInfo();
			wInfo.setMedicineId(proOutDo.getMedicineId());
			wInfo.setMedicineName(proOutDo.getMedicineName());
			wInfo.setId(proOutDo.getId());
			wInfo.setOut_number(proOutDo.getNumber());
			wInfo.setOutTime(proOutDo.getOutTime());
			wInfo.setOut_unitPrice(proOutDo.getUnitPrice());
				ProinDo proinDo = proinDoMapper.selectByPrimaryKey(proOutDo.getMedicineId());
				wInfo.setType(proinDo.getType());
				CustomerDo customerDo = customerService.findByPrimaryKey(Long.parseLong(proOutDo.getCustomerId()));
				wInfo.setCustomerName(customerDo.getCustomerName());
				wInfos.add(wInfo);
			}
		return  new DataGrid<>(pageSize, currentPage, count,wInfos);
	}

	/**
	 * 盈利分页
	 * @param medicineId
	 * @param medicineName
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public DataGrid<WInfo> profitInfoQuery(Integer medicineId, String medicineName, Integer pageSize,
			Integer currentPage) {
		int count = proOutDoMapper.outInfoQueryCount2(medicineId, medicineName);
		if(count==0){
			return new DataGrid<>(pageSize, currentPage, count, new ArrayList<WInfo>());
		}
		
		List<ProOutDo> proOutDos = proOutDoMapper.outInfoQuery2(medicineId, medicineName, pageSize,  pageSize * (currentPage - 1));
		List<WInfo> wInfos = new ArrayList<>();
		for(ProOutDo proOutDo:proOutDos){
			WInfo wInfo = new WInfo();
			wInfo.setMedicineId(proOutDo.getMedicineId());
			wInfo.setMedicineName(proOutDo.getMedicineName());
			wInfo.setOut_number(proOutDo.getNumber());
			wInfo.setOut_unitPrice(proOutDo.getUnitPrice());
			ProinDo proinDo = proinDoMapper.selectByPrimaryKey(proOutDo.getMedicineId());
			wInfo.setUnitPrice(proinDo.getUnitPrice());
			wInfo.setUnitProfit(proOutDo.getUnitPrice()-proinDo.getUnitPrice());
			wInfo.setTotalProfit((proOutDo.getUnitPrice()-proinDo.getUnitPrice())*proOutDo.getNumber());
			wInfos.add(wInfo);
			}
		return new DataGrid<>(pageSize, currentPage, count, wInfos);
	}
	
	

}
