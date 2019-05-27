package com.model;

import java.io.Serializable;
import java.util.Date;

public class BillSum implements Serializable {
    private String bId;

    private Integer product_qty;

    private Integer bill_price;

    private Integer bill_profit;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public BillSum(String bId, Integer product_qty, Integer bill_price, Integer bill_profit, Date create_time) {
        this.bId = bId;
        this.product_qty = product_qty;
        this.bill_price = bill_price;
        this.bill_profit = bill_profit;
        this.create_time = create_time;
    }

    public BillSum() {
        super();
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public Integer getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(Integer product_qty) {
        this.product_qty = product_qty;
    }

    public Integer getBill_price() {
        return bill_price;
    }

    public void setBill_price(Integer bill_price) {
        this.bill_price = bill_price;
    }

    public Integer getBill_profit() {
        return bill_profit;
    }

    public void setBill_profit(Integer bill_profit) {
        this.bill_profit = bill_profit;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}