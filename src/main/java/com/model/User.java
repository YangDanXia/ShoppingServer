package com.model;

import java.io.Serializable;

public class User implements Serializable {

    private String uTel;

    private String uPasswd;

    private String uName;

    private Integer credit;

    private static final long serialVersionUID = 1L;

    public User(String uTel, String uPasswd, String uName, Integer credit) {
        this.uTel = uTel;
        this.uPasswd = uPasswd;
        this.uName = uName;
        this.credit = credit;
    }

    public User() {
        super();
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuPasswd() {
        return uPasswd;
    }

    public void setuPasswd(String uPasswd) {
        this.uPasswd = uPasswd;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}