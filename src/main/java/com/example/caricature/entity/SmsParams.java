package com.example.caricature.entity;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 验证码实体类
 */
@Data
@Accessors(chain = true)
public class SmsParams {

    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 手机号码
     */
    private String phone;


    public SmsParams(String phone, String verifyCode) {
        this.phone = phone;
        this.verifyCode = verifyCode;
    }
}
