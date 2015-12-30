package testonly;

public class ProducerConsumer {
	public static void main(String[] args) {
		BasketBall basketBall=new BasketBall();
		new Thread(new Producer(basketBall)).start();
		new Thread(new Consumer2(basketBall)).start();
	}
}
