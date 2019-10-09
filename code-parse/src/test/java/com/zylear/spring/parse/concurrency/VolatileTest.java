package com.zylear.spring.parse.concurrency.contest;

public class VolatileTest {

	private volatile static Data data = new Data();
	private static Integer number = 1;

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.number = 2;
				number = 2;
				System.out.println("22");
			}
		}).start();

		while (data.number == 1) {

		}
		System.out.println("end");
	}


	public static class Data{
		public Integer number = 1;
	}

}
