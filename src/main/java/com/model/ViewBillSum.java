package com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ViewBillSum implements Serializable {
    private String bId;

    private BigDecimal price;

    private BigDecimal profit;

    private BigDecimal saleQty;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public ViewBillSum(String bId, BigDecimal price, BigDecimal profit, BigDecimal saleQty, Date create_time) {
        this.bId = bId;
        this.price = price;
        this.profit = profit;
        this.saleQty = saleQty;
        this.create_time = create_time;
    }

    public ViewBillSum() {
        super();
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getSaleQty() {
        return saleQty;
    }

    public void setSaleQty(BigDecimal saleQty) {
        this.saleQty = saleQty;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}