package com;

public class Producer implements Runnable{
	private Q q;
	private boolean start;	

	public Producer(Q q) {
		super();
		this.q = q;
		start = true;
	}
	public int produce(int data){
		return q.pushData(data);
	}

	@Override
	public  void run() {
		System.out.println("starting producer thread "+Thread.currentThread().getName());

		synchronized (q) {
			try {
				for(int i=1;i<=10;i++){
					produce(i);
					System.out.println("producing data -->" +i+" :q["+(i-1)+"]");
					Thread.sleep(500);
				}
				System.out.println("data production success...");
				q.notifyAll();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
