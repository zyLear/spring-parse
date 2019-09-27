package com.zylear.spring.parse.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockParse {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();

		lock.lock();

	}
}
