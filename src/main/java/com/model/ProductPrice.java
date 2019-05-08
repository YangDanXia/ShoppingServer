package com.model;

import java.io.Serializable;

public class ProductPrice implements Serializable {
    private String pId;

    private String unit_priceCode;

    private Integer unit_price;

    private Integer recommend_prcie;

    private Integer discout;

    private Integer actual_price;

    private Integer profit_price;

    private static final long serialVersionUID = 1L;

    public ProductPrice(String pId, String unit_priceCode, Integer unit_price, Integer recommend_prcie, Integer discout, Integer actual_price, Integer profit_price) {
        this.pId = pId;
        this.unit_priceCode = unit_priceCode;
        this.unit_price = unit_price;
        this.recommend_prcie = recommend_prcie;
        this.discout = discout;
        this.actual_price = actual_price;
        this.profit_price = profit_price;
    }

    public ProductPrice() {
        super();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUnit_priceCode() {
        return unit_priceCode;
    }

    public void setUnit_priceCode(String unit_priceCode) {
        this.unit_priceCode = unit_priceCode;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getRecommend_prcie() {
        return recommend_prcie;
    }

    public void setRecommend_prcie(Integer recommend_prcie) {
        this.recommend_prcie = recommend_prcie;
    }

    public Integer getDiscout() {
        return discout;
    }

    public void setDiscout(Integer discout) {
        this.discout = discout;
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