package com.example.caricature.entity;

import java.util.Date;

public class UserRole {
    private String id;

    private String userId;

    private String roleId;

    /**
     * 失效时间
     */
    private Date disabilityTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getDisabilityTime() {
        return disabilityTime;
    }

    public void setDisabilityTime(Date disabilityTime) {
        this.disabilityTime = disabilityTime;
    }
}