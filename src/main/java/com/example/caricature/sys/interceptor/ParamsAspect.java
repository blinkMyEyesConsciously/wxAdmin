package com.example.caricature.sys.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.caricature.sys.vo.Check;
import com.example.caricature.sys.vo.ParamException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.aspectj.lang.reflect.MethodSignature;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ParamsAspect {
    private static final Logger logger = LoggerFactory.getLogger(ParamsAspect.class);

    private static String dateFormat = "yyyy-MM-dd HH:mm:ss";

    @Pointcut("@annotation(com.example.caricature.sys.vo.Check)")
    public void paramsCheck() {
    }

    @Around("paramsCheck()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1、记录方法开始执行的时间
        long start = System.currentTimeMillis();

        // 2、打印请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String target = joinPoint.getSignature().getDeclaringTypeName();              // 全路径类名
        String classNm = target.substring(target.lastIndexOf(".") + 1, target.length()); // 类名截取
        String method = joinPoint.getSignature().getName();                          // 获取方法名
        Map<String, String> params = getAllRequestParam(request);                    // 获取请求参数
        logger.info("{}.{} 接收参数: {}", classNm, method, JSON.toJSONString(params));

        Check check = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Check.class); // 获取注解
        String[] requiredFields = check.params();                                   // 获取注解参数
        // 3、必填参数非空校验
        Boolean result = validParams(params, requiredFields);
        if (result) {

            Object object = joinPoint.proceed();        // 必填参数非空校验通过，执行方法，获取执行结果
            // 4、打印应答数据和方法耗时
            long time = System.currentTimeMillis() - start;
            logger.info("{}.{} 应答数据: {}; 耗时 {} ms", classNm, method, JSONObject.toJSONStringWithDateFormat(object,
                    dateFormat, SerializerFeature.WriteMapNullValue), time);
            return object;
        } else {
            // 必填参数非空校验未通过，返回调用方“参数缺失”
            throw new ParamException();
        }
    }

    /**
     * 校验传入参数params（非null）中是否必含requiredFields（非null）中的各个属性，且属性值非空
     *
     * @param params         传入参数
     * @param requiredFields 设置的非空属性数组
     * @return 校验通过返回true，否则返回false
     */
    private Boolean validParams(Map<String, String> params, String[] requiredFields) {
        if (requiredFields.length == 0) {
            // 无必送参数，直接返回true
            return true;
        } else {
            for (String field : requiredFields) {
                if (StringUtils.isEmpty(params.get(field))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 获取请求参数
     */
    public static Map<String, String> getAllRequestParam(HttpServletRequest request) {
        Map<String, String> res = new HashMap<>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (StringUtils.isEmpty(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

}
