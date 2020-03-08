package com.zylear.spring.parse.base.concurrency;

import com.zylear.spring.parse.bean.Person;
import org.openjdk.jol.info.ClassLayout;


/**
 * 第一次是先有个概念  之后再复习
 * <p>
 * 总结  对象头标志位改变   ->  每个对象对应有一个monitor对象
 * <p>
 * mark word 64位 8个字节
 * klass pointer 32位 4个字节
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
		lock.setCode(10);
		lock.setName("namenamenamenamenamenamenamename");
		System.out.println(ClassLayout.parseInstance(lock).toPrintable());

		System.out.println();
		System.out.println();

		SynchronizedParse synchronizedParse = new SynchronizedParse();


//		for (int i = 0; i < 2; i++) {
//			new Thread(String.valueOf(i)) {
//				@Override
//				public void run() {
//					synchronizedParse.fun1();
//				}
//			}.start();
//		}
		SynchronizedParse synchronizedParse1 = new SynchronizedParse();
		SynchronizedParse synchronizedParse2 = new SynchronizedParse();

		new Thread() {
			@Override
			public void run() {
				synchronizedParse1.fun1();
			}
		}.start();

//		new Thread() {
//			@Override
//			public void run() {
//				synchronizedParse2.fun1();
//			}
//		}.start();

//		new Thread() {
//			@Override
//			public void run() {
//				synchronizedParse1.fun2();
//			}
//		}.start();

//		new Thread() {
//			@Override
//			public void run() {
//				synchronizedParse2.fun2();
//			}
//		}.start();

		new Thread() {
			@Override
			public void run() {
				SynchronizedParse.fun3();
			}
		}.start();
//
//		new Thread() {
//			@Override
//			public void run() {
//				SynchronizedParse.fun3();
//			}
//		}.start();


		while (Thread.activeCount() > 2) {
			Thread.yield();
		}
		System.out.println("end");


	}


	private synchronized void fun1() {
		System.out.println(Thread.currentThread().getName() + " fun1 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " fun1 end...");
	}

	private synchronized void fun2() {
		System.out.println(Thread.currentThread().getName() + " fun2 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " fun2 end...");
	}

	private static synchronized void fun3() {
		System.out.println(Thread.currentThread().getName() + " fun3 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " fun3 end...");
	}


}
