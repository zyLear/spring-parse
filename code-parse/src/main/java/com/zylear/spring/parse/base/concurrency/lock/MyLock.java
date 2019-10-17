package com.zylear.spring.parse.base.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

	private Helper helper;

	public MyLock() {
		helper = new Helper();
	}

	@Override
	public void lock() {
		helper.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		helper.release(1);
	}

	@Override
	public Condition newCondition() {
		return helper.newCondition();
	}

	/* Subclasses should be defined as non-public internal helper
	 * classes that are used to implement the synchronization properties
	 * of their enclosing class.
	 **/
	static class Helper extends AbstractQueuedSynchronizer {

		ConditionObject newCondition() {
			return new ConditionObject();
		}

		@Override
		protected boolean tryAcquire(int arg) {
			int state = getState();
			Thread currentThread = Thread.currentThread();
			if (state == 0) {
				if (compareAndSetState(0, arg)) {
					//设置占有锁的排他线程
					setExclusiveOwnerThread(currentThread);
					return true;
				}
				//重入
			} else if (currentThread == getExclusiveOwnerThread()) {
				setState(state + arg);
				return true;
			}

			return false;
		}


		/* * @return {@code true} if this object is now in a fully released
		 *         state, so that any waiting threads may attempt to acquire;
		 *         and {@code false} otherwise.
		 **/
		@Override
		protected boolean tryRelease(int arg) {
			Thread exclusiveOwnerThread = getExclusiveOwnerThread();
			if (Thread.currentThread() == exclusiveOwnerThread) {
				int state = getState();
				state = state - arg;
				if (state == 0) {
					setExclusiveOwnerThread(null);
					setState(state);
					return true;
				} else {
					setState(state);
					return false;
				}
			}
			return false;
		}
	}


}
