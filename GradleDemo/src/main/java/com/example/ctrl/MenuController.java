package com.example.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mapper.dao.CustomerDo;
import com.example.mapper.dao.InventoryDo;
import com.example.mapper.dao.ManufacturerDo;
import com.example.service.CustomerService;
import com.example.service.InventoryService;
import com.example.service.ManufacturerService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private InventoryService inventoryService;

	private static final Logger log = LoggerFactory.getLogger(MenuController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝初始化主页面＝＝＝");
		return "index";
	}
	
	@RequestMapping(value = "/manager-info", method = RequestMethod.GET)
	public String userView(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝查看个人信息页面＝＝＝");
		return "info/manager-info";
	}
	
	@RequestMapping(value = "/manager-info-modify", method = RequestMethod.GET)
	public String userViewModify(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝修改个人信息页面＝＝＝");
		return "info/manager-info-modify";
	}
	
	@RequestMapping(value = "/customer-info", method = RequestMethod.GET)
	public String customerInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝查看客户信息页面＝＝＝");
		return "info/customer-info";
	}
	@RequestMapping(value = "/manufacturer-info", method = RequestMethod.GET)
	public String manufacturerInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝查看厂商信息页面＝＝＝");
		return "info/manufacturer-info";
	}
	@RequestMapping(value = "/medicine-info", method = RequestMethod.GET)
	public String medicineInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝查看药品信息页面＝＝＝");
		return "info/medicine-info";
	}
	@RequestMapping(value = "/input-medicine", method = RequestMethod.GET)
	public String inputMedicine(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝采购药品页面＝＝＝");
		List<ManufacturerDo> list = manufacturerService.findAll();
		model.addAttribute("list", list);
		return "record/input-medicine";
	}
	@RequestMapping(value = "/output-medicine", method = RequestMethod.GET)
	public String outputMedicine(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝药品出库页面＝＝＝");
		List<InventoryDo> inventorylist = inventoryService.findAll();
		model.addAttribute("inventorylist", inventorylist);
		List<CustomerDo> customerlist = customerService.findAll();
		model.addAttribute("customerlist", customerlist);
		return "record/output-medicine";
	}
	@RequestMapping(value = "/input-info", method = RequestMethod.GET)
	public String enterMedicineInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝入库信息页面＝＝＝");
		
		return "search/input-info";
	}
	@RequestMapping(value = "/output-info", method = RequestMethod.GET)
	public String outputMedicineInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		log.info("＝＝＝出库信息页面＝＝＝");
		return "search/output-info";
	}
	@RequestMapping(value = "/inventory-info", method = RequestMethod.GET)
	public String invertoryInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝库存信息页面＝＝＝");
		return "search/inventory-info";
	}
	@RequestMapping(value = "/profit-info", method = RequestMethod.GET)
	public String profitInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝盈利情况页面＝＝＝");
		return "search/profit-info";
	}
	@RequestMapping(value = "/search-manufacturer", method = RequestMethod.GET)
	public String searchManufacturerInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝厂商查询页面＝＝＝");
		return "search/search-manufacturer--info";
	}
	
	@RequestMapping(value = "/search-customer", method = RequestMethod.GET)
	public String searchCustomerInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("＝＝＝客户查询页面＝＝＝");
		return "search/search-customer--info";
	}
}
