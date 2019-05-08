package com.model;

import java.io.Serializable;

public class ViewProductCal implements Serializable {
    private String pId;

    private String pName;

    private String pType;

    private String pBrand;

    private String pSupplier;

    private String pYear;

    private Integer actual_price;

    private Integer profit_price;

    private static final long serialVersionUID = 1L;

    public ViewProductCal(String pId, String pName, String pType, String pBrand, String pSupplier, String pYear, Integer actual_price, Integer profit_price) {
        this.pId = pId;
        this.pName = pName;
        this.pType = pType;
        this.pBrand = pBrand;
        this.pSupplier = pSupplier;
        this.pYear = pYear;
        this.actual_price = actual_price;
        this.profit_price = profit_price;
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
}