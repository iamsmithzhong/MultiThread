package testonly;

//篮子的实例，用来放馒头
class BasketBall {
	private int index = 0;// 表示装到第几个了馒头
	private ManTou[] manTous = new ManTou[1];// 可以放6个馒头

	// 放进去一个馒头
	public synchronized void push(ManTou manTou) {
		while(index==manTous.length){
			try {
				System.out.println("生产者：篮子满了！");
				Thread.currentThread().sleep(30000);
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("生产者： "+"生产"+manTou.toString());
		this.notify();
		manTous[index] = manTou;
		index++;
	}

	// 拿一个馒头
	public synchronized ManTou pop() {
		while (index==0) {
			try {
				System.out.println("消费者：篮子空了！");				
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ManTou manTou=manTous[--index];
		System.out.println("消费者："+"吃了"+manTou.toString());
		this.notify();
		return manTou;
	}
}
