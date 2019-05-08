package com.model;

import java.io.Serializable;

public class ViewBillDay implements Serializable {
    private String bId;

    private Integer sale_qty;

    private Integer total_price;

    private Integer total_profit;

    private String pId;

    private String pName;

    private String pType;

    private String pBrand;

    private String pSupplier;

    private String pYear;

    private String pFromName;

    private String unit_priceCode;

    private Integer actual_price;

    private static final long serialVersionUID = 1L;

    public ViewBillDay(String bId, Integer sale_qty, Integer total_price, Integer total_profit, String pId, String pName, String pType, String pBrand, String pSupplier, String pYear, String pFromName, String unit_priceCode, Integer actual_price) {
        this.bId = bId;
        this.sale_qty = sale_qty;
        this.total_price = total_price;
        this.total_profit = total_profit;
        this.pId = pId;
        this.pName = pName;
        this.pType = pType;
        this.pBrand = pBrand;
        this.pSupplier = pSupplier;
        this.pYear = pYear;
        this.pFromName = pFromName;
        this.unit_priceCode = unit_priceCode;
        this.actual_price = actual_price;
    }

    public ViewBillDay() {
        super();
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public Integer getSale_qty() {
        return sale_qty;
    }

    public void setSale_qty(Integer sale_qty) {
        this.sale_qty = sale_qty;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Integer getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(Integer total_profit) {
        this.total_profit = total_profit;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpSupplier() {
        return pSupplier;
    }

    public void setpSupplier(String pSupplier) {
        this.pSupplier = pSupplier;
    }

    public String getpYear() {
        return pYear;
    }

    public void setpYear(String pYear) {
        this.pYear = pYear;
    }

    public String getpFromName() {
        return pFromName;
    }

    public void setpFromName(String pFromName) {
        this.pFromName = pFromName;
    }

    public String getUnit_priceCode() {
        return unit_priceCode;
    }

    public void setUnit_priceCode(String unit_priceCode) {
        this.unit_priceCode = unit_priceCode;
    }

    public Integer getActual_price() {
        return actual_price;
    }

    public void setActual_price(Integer actual_price) {
        this.actual_price = actual_price;
    }
}