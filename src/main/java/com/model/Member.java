package com.model;

import java.io.Serializable;

public class Member implements Serializable {

    private String mTel;

    private String mPasswd;

    private String mName;

    private Integer privilege;

    private static final long serialVersionUID = 1L;

    public Member(String mTel, String mPasswd, String mName, Integer privilege) {
        this.mTel = mTel;
        this.mPasswd = mPasswd;
        this.mName = mName;
        this.privilege = privilege;
    }

    public Member() {
        super();
    }

    public String getmTel() {
        return mTel;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public String getmPasswd() {
        return mPasswd;
    }

    public void setmPasswd(String mPasswd) {
        this.mPasswd = mPasswd;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

}