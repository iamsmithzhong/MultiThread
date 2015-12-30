package testonly;

import java.io.IOException;

public class WaitNotify2 {

	public static void main(String[] args) throws IOException {
		new Thread(new Notify()).start();	
		
		System.in.read();
	}
}

class Notify implements Runnable {
	public synchronized void OnlyNotify(){		
		this.notify();
		System.out.println("通知！通知！");		
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++){
			OnlyNotify();
		}
	}
}
