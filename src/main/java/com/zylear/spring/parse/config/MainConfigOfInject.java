package com.zylear.spring.parse.config;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.zylear.spring.parse.manager")
public class MainConfigOfInject{
    public MainConfigOfInject() {
        System.out.println("inject");
    }

    public static void main(String[] args) {
//        new MainConfigOfInject();

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfInject.class);


    }
}





