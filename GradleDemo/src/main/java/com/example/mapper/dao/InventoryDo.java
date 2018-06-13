package com.example.mapper.dao;

public class InventoryDo {
    private Long id;

    private Long medicineId;

    private String medicineName;

    private Integer number;

    private String limited;

    private String batchNumber;

    private Long manufacturerId;

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
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLimited() {
        return limited;
    }

    public void setLimited(String limited) {
        this.limited = limited == null ? null : limited.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}