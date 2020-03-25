package com.zylear.spring.parse.base.monitor;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.Properties;

public class MonitorTest {

	public static void main(String[] args) {

		System.out.println(args.length);

		System.out.println("===============程序运行参数==================");
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

		Properties properties = System.getProperties();
		System.out.println(properties);


		//JVM启动参数
		System.out.println(runtimeMXBean.getInputArguments());
		System.out.println();


		//系统属性
		System.out.println(runtimeMXBean.getSystemProperties());
		System.out.println();

		//JVM名字
		System.out.println(runtimeMXBean.getVmName());

	}

}
