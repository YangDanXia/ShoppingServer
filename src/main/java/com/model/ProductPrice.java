package com.model;

import java.io.Serializable;

public class ProductPrice implements Serializable {
    private String pId;

    private Integer unit_price;

    private Integer actual_price;

    private Integer profit_price;

    private static final long serialVersionUID = 1L;

    public ProductPrice(String pId, Integer unit_price,Integer actual_price, Integer profit_price) {
        this.pId = pId;
        this.unit_price = unit_price;
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
}