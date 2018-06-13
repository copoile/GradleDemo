package com.example.mapper.dao;

public class ProinDo {
    private Long medicineId;

    private String medicineName;

    private String specification;

    private String limited;

    private String producedDate;

    private String packaging;

    private String type;

    private String batchNumber;

    private Double unitPrice;

    private Double retailPrice;

    private String unit;

    private String remark;

    private String inputtime;

    private Long manufacturerId;

    private Integer number;

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
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getLimited() {
        return limited;
    }

    public void setLimited(String limited) {
        this.limited = limited == null ? null : limited.trim();
    }

    public String getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(String producedDate) {
        this.producedDate = producedDate == null ? null : producedDate.trim();
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getInputtime() {
        return inputtime;
    }

    public void setInputtime(String inputtime) {
        this.inputtime = inputtime == null ? null : inputtime.trim();
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
}