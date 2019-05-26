package com.model;

import java.io.Serializable;

public class BillInfo implements Serializable {
    private String bId;

    private String pId;

    private Integer sale_qty;

    private Integer total_price;

    private Integer total_profit;

    private static final long serialVersionUID = 1L;

    public BillInfo(String bId, String pId, Integer sale_qty, Integer total_price, Integer total_profit) {
        this.bId = bId;
        this.pId = pId;
        this.sale_qty = sale_qty;
        this.total_price = total_price;
        this.total_profit = total_profit;
    }

    public BillInfo() {
        super();
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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


    private Integer sale_totalQty;

    private Integer rest_qty;

    private Integer isSelling;

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

    public Integer getIsSelling() {return isSelling;}

    public void setIsSelling(Integer isSelling) {this.isSelling = isSelling;}
}