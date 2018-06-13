package com.example.ctrl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class WInfo {

	private Long id;

	private Long medicineId;

	private String medicineName;

	private String limited;

	private String producedDate;

	private String type;

	private String batchNumber;

	private Double unitPrice;

	private String unit;

	private String remark;

	private String inputtime;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date outTime;

	private double out_unitPrice;

	private Integer out_number;

	private Integer inventory_number;

	private String customerName;

	private Long manufacturerId;

	private Integer number;

	private String manufacturerName;

	private Double unitProfit;

	private Double totalProfit;

	public Double getUnitProfit() {
		return unitProfit;
	}

	public void setUnitProfit(Double unitProfit) {
		this.unitProfit = unitProfit;
	}

	public Double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public Integer getInventory_number() {
		return inventory_number;
	}

	public void setInventory_number(Integer inventory_number) {
		this.inventory_number = inventory_number;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public double getOut_unitPrice() {
		return out_unitPrice;
	}

	public void setOut_unitPrice(double out_unitPrice) {
		this.out_unitPrice = out_unitPrice;
	}

	public Integer getOut_number() {
		return out_number;
	}

	public void setOut_number(Integer out_number) {
		this.out_number = out_number;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getLimited() {
		return limited;
	}

	public void setLimited(String limited) {
		this.limited = limited;
	}

	public String getProducedDate() {
		return producedDate;
	}

	public void setProducedDate(String producedDate) {
		this.producedDate = producedDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInputtime() {
		return inputtime;
	}

	public void setInputtime(String inputtime) {
		this.inputtime = inputtime;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

}
