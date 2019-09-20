package com.zylear.spring.parse.annotation;


import com.zylear.spring.parse.registrar.AopRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AopRegistrar.class)
public @interface EnableAop {



}
