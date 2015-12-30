package testonly;

public class InterruptThread {
	public static void main(String[] args) throws InterruptedException {
		MyThread thread=new MyThread();
		thread.start();
		Thread.sleep(3000);
		thread.interrupt();
	}
}

//class MyThread extends Thread {
//	int i=0;
//	@Override
//	public void run() {
//		while (true) {
//			System.out.println(i);
//			try {
//				System.out.println("开睡了:" + Thread.currentThread().isInterrupted());
//				Thread.sleep(10000);
//				System.out.println("睡醒了");
//			} catch (InterruptedException e) {
//				System.out.println("中断异常被捕获了："+ Thread.currentThread().isInterrupted());
//				return;
//			}
//			i++;
//		}
//	}
//}

//由于有while语句，interrupt不起作用
class MyThread extends Thread {
	int i=0;
	@Override
	public void run() {
		while (true) {			
			System.out.println(i + ":" + Thread.currentThread().isInterrupted());
			i++;
		}
	}
}

