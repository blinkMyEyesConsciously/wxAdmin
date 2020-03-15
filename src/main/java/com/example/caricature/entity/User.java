package com.example.caricature.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    /**
     * password
     */
    private String password;

    /**
     * createTime
     */
    private Date addTime;

    /**
     * upTime
     */
    private Date updateTime;

    private String phone;

    private BigDecimal money;

    /**
     * 2是被删除
     */
    private String isDel;

    /**
     * 最大登录人数   -1 为无限
     */
    private Integer maxOnline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public Integer getMaxOnline() {
        return maxOnline;
    }

    public void setMaxOnline(Integer maxOnline) {
        this.maxOnline = maxOnline;
    }
}