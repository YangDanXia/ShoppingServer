package com.model;

import java.io.Serializable;

public class ProductStorage implements Serializable {
    private String pId;

    private Integer sale_totalQty;

    private Integer rest_qty;

    private static final long serialVersionUID = 1L;

    public ProductStorage(String pId, Integer sale_totalQty, Integer rest_qty) {
        this.pId = pId;
        this.sale_totalQty = sale_totalQty;
        this.rest_qty = rest_qty;
    }

    public ProductStorage() {
        super();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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