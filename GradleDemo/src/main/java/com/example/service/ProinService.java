package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.bean.DataGrid;
import com.example.ctrl.model.WInfo;
import com.example.mapper.InventoryDoMapper;
import com.example.mapper.ProinDoMapper;
import com.example.mapper.dao.InventoryDo;
import com.example.mapper.dao.ManufacturerDo;
import com.example.mapper.dao.ProinDo;

/**
 * 入库
 * @author Administrator
 *
 */
@Service
@Transactional
public class ProinService {
	
	@Autowired
	private ProinDoMapper proinDoMapper;
	
	@Autowired
	private InventoryDoMapper inventoryDoMapper;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	/**
	 * 入库
	 * @param proinDo
	 */
	public void save(ProinDo proinDo){
		proinDo.setRetailPrice(proinDo.getUnitPrice()*proinDo.getNumber());
		//入库记录
		proinDoMapper.insertSelective(proinDo);
		//库存
		InventoryDo inventoryDo = new InventoryDo();
		BeanUtils.copyProperties(proinDo, inventoryDo);
		inventoryDoMapper.insert(inventoryDo);
	}
	
	/**
	 * 主键查询入库药品信息
	 * @param medicineId
	 * @return
	 */
	public ProinDo findByPrimaryKey(Long medicineId){
		return proinDoMapper.selectByPrimaryKey(medicineId);
	}

	/**
	 * 入库信息分页查询
	 * @param medicineId
	 * @param medicineName
	 * @param inputtime
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public DataGrid<WInfo> inputInfoQuery(Integer medicineId, String medicineName, String inputtime, Integer pageSize,
			Integer currentPage) {
		
		int count = proinDoMapper.inputInfoQueryCount(medicineId, medicineName, inputtime);
		if(count==0){
			return new DataGrid<>(pageSize, currentPage, count, new ArrayList<WInfo>());
		}
		
		List<ProinDo> proinDos = proinDoMapper.inputInfoQuery(medicineId, medicineName, inputtime, pageSize,  pageSize * (currentPage - 1));
		List<WInfo> wInfos = new ArrayList<>();
		for(ProinDo proinDo:proinDos){
			WInfo wInfo = new WInfo();
				ManufacturerDo manufacturerDo = manufacturerService.findByPrimaryKey(proinDo.getManufacturerId());
				if(manufacturerDo!=null){
					BeanUtils.copyProperties(manufacturerDo, wInfo);
				}
				BeanUtils.copyProperties(proinDo, wInfo);
				wInfos.add(wInfo);
			}
		return  new DataGrid<>(pageSize, currentPage, count,wInfos);
	}


}
