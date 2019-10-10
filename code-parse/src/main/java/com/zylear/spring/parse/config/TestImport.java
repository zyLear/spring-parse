package com.zylear.spring.parse.config;

import com.zylear.spring.parse.bean.PersonTwo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersonTwo.class)
public class TestImport {
}
