package com.zylear.spring.parse.base.concurrency.lock;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockTest {



	static volatile int index = 0;

	@Test
	public void withoutLockTest() throws InterruptedException {
		//等到所有线程完成再退出
		CountDownLatch countDownLatch = new CountDownLatch(1000);

		List<Thread> list = new LinkedList<>();
		long l = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					int i = index;
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					index = i + 1;
					countDownLatch.countDown();
				}
			});
			thread.start();
			list.add(thread);
		}
		countDownLatch.await();

		System.out.println(index);
		System.out.println(System.currentTimeMillis() - l);

	}

	@Test
	public void lockTest() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1000);
		Lock myLock = new MyLock();
		List<Thread> list = new LinkedList<>();
		long l = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						myLock.lock();
						int i = index;
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						index = i + 1;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						myLock.unlock();
					}
					countDownLatch.countDown();

				}
			});
			thread.start();
			list.add(thread);
		}


		countDownLatch.await();
//		for (Thread thread : list) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		cyclicBarrier.


		System.out.println(index);
		System.out.println(System.currentTimeMillis() - l);
	}

	@Test
	public void rLockTest() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1000);

		Lock myLock = new ReentrantLock();
		List<Thread> list = new LinkedList<>();
		long l = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						myLock.lock();
						int i = index;
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						index = i + 1;
					} finally {
						myLock.unlock();
					}
					countDownLatch.countDown();

				}
			});
			thread.start();
			list.add(thread);
		}
		countDownLatch.await();
//		for (Thread thread : list) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		System.out.println(index);
		System.out.println(System.currentTimeMillis() - l);
	}

	@Test
	public void cyclicBarrierTest() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
		List<Thread> list = new LinkedList<>();
		long l = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(finalI +" ready");
						cyclicBarrier.await();
						System.out.println(finalI +" go");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}

				}
			});
			thread.start();
			list.add(thread);
		}
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(index);
		System.out.println(System.currentTimeMillis() - l);
	}

}