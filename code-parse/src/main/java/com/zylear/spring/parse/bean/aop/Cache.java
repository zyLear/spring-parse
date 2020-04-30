package com.zylear.spring.parse.bean.aop;


import java.lang.annotation.*;


@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

}
