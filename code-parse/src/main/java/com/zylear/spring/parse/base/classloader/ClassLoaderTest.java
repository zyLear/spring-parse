package com.zylear.spring.parse.base.classloader;

public class ClassLoaderTest extends ClassLoader{

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return super.loadClass(name);
	}

	public static void main(String[] args) {
		System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderTest.class.getClassLoader());
		System.out.println("The Parent of ClassLodarDemo's ClassLoader is " +
				ClassLoaderTest.class.getClassLoader().getParent());
		System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " +
				ClassLoaderTest.class.getClassLoader().getParent().getParent());
	}

}
