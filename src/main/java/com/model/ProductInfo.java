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

    private Boolean pFrom;

    private String pFromName;

    private static final long serialVersionUID = 1L;

    public ProductInfo(String pId, String pName, String pType, String pBrand, String pSupplier, String pYear, String pImage, Boolean pFrom, String pFromName) {
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

    public Boolean getpFrom() {
        return pFrom;
    }

    public void setpFrom(Boolean pFrom) {
        this.pFrom = pFrom;
    }

    public String getpFromName() {
        return pFromName;
    }

    public void setpFromName(String pFromName) {
        this.pFromName = pFromName;
    }
}