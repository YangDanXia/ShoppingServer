package com.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ViewSale implements Serializable {
    private String kindName;

    private Long productQty;

    private BigDecimal profit;

    private BigDecimal saleQty;

    private static final long serialVersionUID = 1L;

    public ViewSale(String kindName, Long productQty, BigDecimal profit, BigDecimal saleQty) {
        this.kindName = kindName;
        this.productQty = productQty;
        this.profit = profit;
        this.saleQty = saleQty;
    }

    public ViewSale() {
        super();
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Long getProductQty() {
        return productQty;
    }

    public void setProductQty(Long productQty) {
        this.productQty = productQty;
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
}