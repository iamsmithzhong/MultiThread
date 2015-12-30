package testonly;

//生产者，生产馒头
class Producer implements Runnable {
	private BasketBall basketBall;

	public Producer(BasketBall basketBall) {
		this.basketBall = basketBall;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			ManTou manTou = new ManTou(i);// 生产馒头
			basketBall.push(manTou);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}