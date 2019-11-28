package com.zylear.spring.parse.base.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CustomProxy {

//	private Object target;

	public static Object createProxy(ClassLoader classLoader,
									 Class<?>[] interfaces,
									 Handler handler)
			throws Exception {
		Class<?>[] intfs = interfaces.clone();
		//  生成接口的代理类的字节码文件  继承proxy
		Class clazz = getProxyClass0(classLoader, intfs);
		Class<?>[] constructorParams = {Handler.class};
		Constructor constructor = clazz.getConstructor(constructorParams);

		return constructor.newInstance(new Object[]{handler});
	}

	private static Class getProxyClass0(ClassLoader classLoader, Class<?>[] interfaces) {


		//ProxyGenerator.generateProxyClass   生成字节码

		//for循环接口的每个方法，存下来，调用
		// super.h.invoke(this, method, (Object[])null);


		//调用本地方法  加载字节码 返回class
//		return defineClass0(loader, proxyName,
//				proxyClassFile, 0, proxyClassFile.length);

		return null;
	}


	public interface Handler {
		Object handle(Object proxy, Method method, Object[] args);
	}
}

