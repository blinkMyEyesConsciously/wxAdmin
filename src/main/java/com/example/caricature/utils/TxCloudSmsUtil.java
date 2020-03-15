package com.example.caricature.utils;

import com.alibaba.fastjson.JSONException;
import com.example.caricature.entity.SmsParams;
import com.github.qcloudsms.*;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class TxCloudSmsUtil {

    // 短信应用 SDK AppID
    @Value("${tx.sms.appId}")
    int appId; // 1400开头

    // 短信应用SDK AppKey
    @Value("${tx.sms.appKey}")
    String appKey;

    // 短信模板ID，需要在短信应用中申请
    @Value("${tx.sms.templateId}")
    int templateId ; // NOTE: 真实的模板ID需要在短信控制台中申请
    //我这里 templateId 对应的内容是"您的验证码是: {1}"
    // 签名


    /**
     * 指定模板 ID 单发短信
     * @param smsParams
     */
    public String sendSms(SmsParams smsParams) {
        String rep = "error";
        try {
            String verifyCode = smsParams.getVerifyCode();
            // 数组具体的元素个数和模板中变量个数必须一致，例如示例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            String[] params = {verifyCode};
            SmsSingleSender smsSingleSender = new SmsSingleSender(appId, appKey);
            // 签名参数未提供或者为空时，会使用默认签名发送短信
            SmsSingleSenderResult smsSingleSenderResult = smsSingleSender.sendWithParam("86", smsParams.getPhone(),
                    templateId, params, null, "", "");
            System.out.println(smsSingleSenderResult);
            // 如果返回码不是0，说明配置有错，返回错误信息
            if (smsSingleSenderResult.result == 0) {
                rep = "success";
            } else {
                rep = smsSingleSenderResult.errMsg;
            }
        } catch (HTTPException e) {
            System.out.println(e);
            System.out.println("'http'");
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println(e);
            System.out.println("'json'");
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("'网络IO错误'");
            // 网络IO错误
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("'网络IO错误'");
            // 网络IO错误
            e.printStackTrace();
        }
        return rep;
    }

}
