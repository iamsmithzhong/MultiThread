package testonly;

//消费者，拿馒头吃
class Consumer2 implements Runnable {
	private BasketBall basketBall;

	public Consumer2(BasketBall basketBall) {
		this.basketBall = basketBall;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			ManTou manTou=basketBall.pop();
			
		}
	}
}

