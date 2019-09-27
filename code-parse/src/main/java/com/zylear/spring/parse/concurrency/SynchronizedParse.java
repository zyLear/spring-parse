package com.zylear.spring.parse.concurrency;

import com.zylear.spring.parse.bean.Person;
import org.openjdk.jol.info.ClassLayout;


/**
 * 第一次是先有个概念  之后再复习
 *
 * 总结  对象头标志位改变
 */
public class SynchronizedParse {


	public static void main(String[] args) {
		Person lock = new Person();
		System.out.println(ClassLayout.parseInstance(lock).toPrintable());

//		synchronized (lock) {
//
//			System.out.println();
//		}
//
//		new Thread(){
//			@Override
//			public void run() {
//				synchronized (lock) {
//
//					System.out.println();
//					try {
//						Thread.sleep(4000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}.start();
//
//		synchronized (lock) {
//
//			System.out.println();
//		}
//		System.out.println(ClassLayout.parseInstance(lock).toPrintable());

//		System.out.println(lock);
//		System.out.println();
		System.out.println(Integer.toHexString(lock.hashCode()));
		System.out.println(ClassLayout.parseInstance(lock).toPrintable());
//		System.out.println();
//		lock.setCode(1);
		lock.setName("name");
//		System.out.println(ClassLayout.parseInstance(lock).toPrintable());

	}

}
