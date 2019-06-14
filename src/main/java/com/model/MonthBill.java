package com.model;

import java.io.Serializable;

public class MonthBill implements Serializable {
    private Integer yearNum;

    private Integer monthNum;

    private Integer totalProfit;

    private static final long serialVersionUID = 1L;

    public MonthBill(Integer yearNum, Integer monthNum,Integer totalProfit) {
        this.yearNum = yearNum;
        this.monthNum = monthNum;
        this.totalProfit = totalProfit;
    }

    public MonthBill() {
        super();
    }

    public Integer getYearNum() {
        return yearNum;
    }

    public void setYearNum(Integer yearNum) {
        this.yearNum = yearNum;
    }

    public Integer getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(){
        this.monthNum = monthNum;
    }

    public Integer getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Integer totalProfit) {
        this.totalProfit = totalProfit;
    }
}