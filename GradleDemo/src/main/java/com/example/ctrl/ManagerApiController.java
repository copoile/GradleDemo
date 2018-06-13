package com.example.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.bean.DataGrid;
import com.example.ctrl.model.WInfo;
import com.example.ctrl.model.WResponse;
import com.example.mapper.dao.CustomerDo;
import com.example.mapper.dao.ManufacturerDo;
import com.example.mapper.dao.ProOutDo;
import com.example.mapper.dao.ProinDo;
import com.example.service.CustomerService;
import com.example.service.InventoryService;
import com.example.service.ManufacturerService;
import com.example.service.ProOutService;
import com.example.service.ProinService;

@RestController
@RequestMapping(value = "api/info")
public class ManagerApiController extends BaseController{
	
	@Autowired
	private ProinService proinService;
	
	@Autowired
	private ProOutService proOutService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	private static final Logger log = LoggerFactory.getLogger(ManagerApiController.class);
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public WResponse<?> input(HttpServletRequest request,ProinDo proinDo) {
		log.info("--药品入库--");
		proinService.save(proinDo);
		return getResponse();

	}
	
	@RequestMapping(value = "/out", method = RequestMethod.POST)
	public WResponse<?> out(HttpServletRequest request,@RequestBody ProOutDo proOutDo) {
		log.info("--药品出库--");
		proOutService.saveOutput(proOutDo);
		return getResponse();

	}
	
	@RequestMapping(value = "/input/query", method = RequestMethod.GET)
	public @ResponseBody WResponse<DataGrid<WInfo>> inputInfoQuery(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "medicineId", required = false) Integer medicineId,
			@RequestParam(value = "medicineName", required = false) String medicineName,
			@RequestParam(value = "inputtime", required = false) String inputtime) {
		log.info("--分页查询入库信息--");
		DataGrid<WInfo> dataGrid = proinService.inputInfoQuery(medicineId, medicineName, inputtime,pageSize, currentPage);
		return getResponse(dataGrid);
	}
	
	@RequestMapping(value = "/out/query", method = RequestMethod.GET)
	public @ResponseBody WResponse<DataGrid<WInfo>> outInfoQuery(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "medicineId", required = false) Integer medicineId,
			@RequestParam(value = "medicineName", required = false) String medicineName,
			@RequestParam(value = "outputTime", required = false) String outputTime) {
		log.info("--分页查询出库信息--");
		DataGrid<WInfo> dataGrid = proOutService.outInfoQuery(medicineId, medicineName, outputTime,pageSize, currentPage);
		return getResponse(dataGrid);
	}
	
	@RequestMapping(value = "/inventory/query", method = RequestMethod.GET)
	public @ResponseBody WResponse<DataGrid<WInfo>> inventoryInfoQuery(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "medicineId", required = false) Integer medicineId,
			@RequestParam(value = "medicineName", required = false) String medicineName,
			@RequestParam(value = "inputTime", required = false) String inputTime) {
		log.info("--分页查询库存信息--");
		DataGrid<WInfo> dataGrid = inventoryService.inventoryInfoQuery(medicineId, medicineName, inputTime,pageSize, currentPage);
		return getResponse(dataGrid);
	}
	
	@RequestMapping(value = "/customer/query", method = RequestMethod.GET)
	public @ResponseBody WResponse<DataGrid<CustomerDo>> customerInfoQuery(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "customerName", required = false) String customerName
			) {
		log.info("--分页查询客户信息--");
		DataGrid<CustomerDo> dataGrid = customerService.customerInfoQuery(customerName,pageSize, currentPage);
		return getResponse(dataGrid);
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public @ResponseBody WResponse<?> customerAdd(HttpServletRequest request, HttpServletResponse response,CustomerDo customerDo
			) {
		log.info("--新增客户--");
		customerService.savecustomer(customerDo);
		return getResponse();
	}
	
	@RequestMapping(value = "/manufacturer/query", method = RequestMethod.GET)
	public @ResponseBody WResponse<DataGrid<ManufacturerDo>> manufacturerInfoQuery(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "manufacturerName", required = false) String manufacturerName
			) {
		log.info("--分页查询客户信息--");
		DataGrid<ManufacturerDo> dataGrid = manufacturerService.manufacturerInfoQuery(manufacturerName,pageSize, currentPage);
		return getResponse(dataGrid);
	}
	
	@RequestMapping(value = "/manufacturer/add", method = RequestMethod.POST)
	public @ResponseBody WResponse<?> manufacturerAdd(HttpServletRequest request, HttpServletResponse response, ManufacturerDo manufacturerDo
			) {
		log.info("--新增厂商--");
		manufacturerService.savemanufacture(manufacturerDo);
		return getResponse();
	}
	
	@RequestMapping(value = "/profit/query", method = RequestMethod.GET)
	public @ResponseBody WResponse<DataGrid<WInfo>> profitInfoQuery(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "medicineId", required = false) Integer medicineId,
			@RequestParam(value = "medicineName", required = false) String medicineName
			) {
		log.info("--分页查询客户信息--");
		DataGrid<WInfo> dataGrid = proOutService.profitInfoQuery(medicineId, medicineName,pageSize, currentPage);
		return getResponse(dataGrid);
	}
}
