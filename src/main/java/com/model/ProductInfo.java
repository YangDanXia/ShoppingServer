package com.model;

import java.io.Serializable;

public class ProductInfo implements Serializable {
    private String pId;

    private String pName;

    private String pType;

    private String pBrand;

    private String pSupplier;

    private String pYear;

    private String pImage;

    private Integer pFrom;

    private String pFromName;

    private static final long serialVersionUID = 1L;

    public ProductInfo(String pId, String pName, String pType, String pBrand, String pSupplier, String pYear, String pImage, Integer pFrom, String pFromName) {
        this.pId = pId;
        this.pName = pName;
        this.pType = pType;
        this.pBrand = pBrand;
        this.pSupplier = pSupplier;
        this.pYear = pYear;
        this.pImage = pImage;
        this.pFrom = pFrom;
        this.pFromName = pFromName;
    }

    public ProductInfo() {
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

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public Integer getpFrom() {
        return pFrom;
    }

    public void setpFrom(Integer pFrom) {
        this.pFrom = pFrom;
    }

    public String getpFromName() {
        return pFromName;
    }

    public void setpFromName(String pFromName) {
        this.pFromName = pFromName;
    }


//    商品价格表

    private Integer unit_price;

    private Integer actual_price;

    private Integer profit_price;

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
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


//    商品库存表
    private Integer sale_totalQty;

    private Integer rest_qty;

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