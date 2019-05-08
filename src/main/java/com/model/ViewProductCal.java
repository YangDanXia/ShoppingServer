package com.model;

import java.io.Serializable;

public class ViewProductCal implements Serializable {
    private String pId;

    private String pName;

    private String pType;

    private String pBrand;

    private String pSupplier;

    private String pYear;

    private String unit_priceCode;

    private Integer actual_price;

    private Integer profit_price;

    private Integer sale_totalQty;

    private Integer rest_qty;

    private static final long serialVersionUID = 1L;

    public ViewProductCal(String pId, String pName, String pType, String pBrand, String pSupplier, String pYear, String unit_priceCode, Integer actual_price, Integer profit_price, Integer sale_totalQty, Integer rest_qty) {
        this.pId = pId;
        this.pName = pName;
        this.pType = pType;
        this.pBrand = pBrand;
        this.pSupplier = pSupplier;
        this.pYear = pYear;
        this.unit_priceCode = unit_priceCode;
        this.actual_price = actual_price;
        this.profit_price = profit_price;
        this.sale_totalQty = sale_totalQty;
        this.rest_qty = rest_qty;
    }

    public ViewProductCal() {
        super();
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

    public Integer getProfit_price() {
        return profit_price;
    }

    public void setProfit_price(Integer profit_price) {
        this.profit_price = profit_price;
    }

    public Integer getSale_totalQty() {
        return sale_totalQty;
    }

    public void setSale_totalQty(Integer sale_totalQty) {
        this.sale_totalQty = sale_totalQty;
    }

    public Integer getRest_qty() {
        return rest_qty;
    }

    public void setRest_qty(Integer rest_qty) {
        this.rest_qty = rest_qty;
    }
}