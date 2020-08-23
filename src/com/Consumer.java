package com;

public class Consumer implements Runnable {
	private Q q;
	private boolean waitStatus = false;
	private boolean start;
	
	public Consumer(Q q) {
		super();
		this.q = q;
		start = true;
	}
	public int consume(){
		return q.popData();
	}

	

	@Override
	public void run() {
		while(start){
			synchronized (q) {
				try {
					if(q.getSize()==0){
						System.out.println("consumer thread "+Thread.currentThread().getName()+" waiting...");
						q.wait();
						}
					for(int i=1;i<=1;i++){
						System.out.println("consumer thread "+Thread.currentThread().getName()+" is running...");
						if(q.getSize()>0){
							int dataConsumed = consume();
							System.out.println("data consumed -->q["+dataConsumed+"]");
							Thread.sleep(500);
						}
					}
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean isWaitStatus() {
		return waitStatus;
	}
	public void setWaitStatus(boolean waitStatus) {
		this.waitStatus = waitStatus;
	}
}
