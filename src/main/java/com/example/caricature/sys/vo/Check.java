package com.example.caricature.sys.vo;
import java.lang.annotation.*;

/**
 * @description 自定义拦截器标签，params为必填属性
 * @date 2019/3/20 9:31
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Check {
    String[] params();
}
