package com.model;

import java.io.Serializable;
import java.util.Date;

public class BillSum implements Serializable {
    private String bId;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public BillSum(String bId, Date create_time) {
        this.bId = bId;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}