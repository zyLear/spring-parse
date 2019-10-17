package com.zylear.spring.parse.base.concurrency;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

public class VolatileTest {

	private Data data = new Data();
	private Integer number = 1;

	private volatile Data volatileData = new Data();
	private volatile Integer volatileNumber = 1;

	@Test
	public void volatileTest1() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.number = 2;
				System.out.println("22");
			}
		}).start();

		while (data.number == 1) {

		}
		System.out.println("end");
	}


	@Test
	public void volatileTest2() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number = 2;
				System.out.println("22");
			}
		}).start();

		while (number == 1) {

		}
		System.out.println("end");
	}

	@Test
	public void volatileTest3() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				volatileData.number = 2;
				System.out.println("22");
			}
		}).start();

		while (volatileData.number == 1) {

		}
		System.out.println("end");
	}

	@Test
	public void volatileTest4() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				volatileNumber = 2;
				System.out.println("22");
			}
		}).start();

		while (volatileNumber == 1) {

		}
		System.out.println("end");
	}


	@Test
	public void volatileTest5() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.atomicLong.incrementAndGet();
				System.out.println("22");
			}
		}).start();

		while (data.atomicLong.get() == 1L) {

		}
		System.out.println("end");
	}

	@Test
	public void volatileTest6() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.volatileNumber = 2;
				System.out.println("22");
			}
		}).start();

		while (data.volatileNumber == 1) {

		}
		System.out.println("end");
	}

	@Test
	public void volatileTest7() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.number = 2;
				System.out.println("22");
			}
		}).start();

		while (data.number == 1) {
			try {
				//cpu有空闲就会刷新 工作内存的数据到内存
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}


	public static class Data {
		public Integer number = 1;
		public AtomicLong atomicLong = new AtomicLong(1);
		public volatile Integer volatileNumber = 1;
	}

}
