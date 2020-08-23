package com;

public class Thread1 extends Thread {
	private Thread2 thread2;

	public Thread1(Thread2 thread2) {
		super();
		this.thread2 = thread2;
	}

	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try {
				if(i==5){
					System.out.println(Thread.currentThread().getName()+" waits...");
					thread2.join();
					System.out.println(Thread.currentThread().getName()+" resumes...");
				}else{
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
