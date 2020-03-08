package com.zylear.spring.parse.base.concurrency;

public class ThreadLocalParser {

	private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();



	//Thread里面维护一个map<ThreadLocal,Value>
	//set的时候先取出当前线程的map， 把TheadLocal作为key设置value

	public static void main(String[] args) throws InterruptedException {



		Thread thread1 = new Thread(){
			@Override
			public void run() {
				stringThreadLocal.set("thread1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(stringThreadLocal.get());
			}
		};

		Thread thread2 = new Thread(){
			@Override
			public void run() {
				stringThreadLocal.set("thread2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(stringThreadLocal.get());
			}
		};

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();


	}

}
