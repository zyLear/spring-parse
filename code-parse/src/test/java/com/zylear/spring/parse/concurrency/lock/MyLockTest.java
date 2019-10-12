package com.zylear.spring.parse.concurrency.lock;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

public class MyLockTest {

	static int index = 0;

	@Test
	public void withoutLockTest() {
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

	@Test
	public void lockTest() {
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
					} finally {
						myLock.unlock();
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

	@Test
	public void rLockTest() {
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