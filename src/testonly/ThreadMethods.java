package testonly;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMethods {
	final static Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		lock.lock();
		lock.unlock();

		Thread.sleep(1000);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				System.out.println(Thread.currentThread().getName()
						+ " interrupted.");
			}
		});
		t1.start();

		Thread.sleep(1000);

		t1.interrupt();
		Thread.sleep(1000000);
	}
}
