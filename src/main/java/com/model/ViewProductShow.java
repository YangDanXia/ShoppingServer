package com.model;

import java.io.Serializable;
import java.util.Date;

public class ViewProductShow implements Serializable {
    private String pId;

    private String pName;

    private String pType;

    private String pBrand;

    private String pImage;

    private Integer recommend_price;

    private Integer rest_qty;

    private Integer isSelling;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public ViewProductShow(String pId, String pName, String pType, String pBrand, String pImage, Integer recommend_price, Integer rest_qty, Integer isSelling, Date create_time) {
        this.pId = pId;
        this.pName = pName;
        this.pType = pType;
        this.pBrand = pBrand;
        this.pImage = pImage;
        this.recommend_price = recommend_price;
        this.rest_qty = rest_qty;
        this.isSelling = isSelling;
        this.create_time = create_time;
    }

    public ViewProductShow() {
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

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public Integer getRecommend_price() {
        return recommend_price;
    }

    public void setRecommend_price(Integer recommend_price) {
        this.recommend_price = recommend_price;
    }

    public Integer getRest_qty() {
        return rest_qty;
    }

    public void setRest_qty(Integer rest_qty) {
        this.rest_qty = rest_qty;
    }

    public Integer getIsSelling() {
        return isSelling;
    }

    public void setIsSelling(Integer isSelling) {
        this.isSelling = isSelling;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}