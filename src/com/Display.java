package com;

import java.util.Iterator;

public class Display implements Runnable {
	private Q q;
	private boolean start = true;
	private boolean waitStatus = false;
	
	public Display(Q q) {
		super();
		this.q = q;
	}
	public void run() {
		while(start){
			synchronized (q) {
				try {
					if(q.getSize()==0){
						System.out.println("display thread waiting(Q is EMPTY)...");
						waitStatus = true;
						q.wait();
					}
					if(q!=null && q.getSize()>0){
						System.out.println("display thread '"+Thread.currentThread().getName()+"' is active...");
						waitStatus = false;
						System.out.println("displaying Q data...");
						Iterator<Integer> it = q.getData().iterator();
						int count = 0 ;
						while(it.hasNext() && start){
							System.out.print(it.next());++count;
							if(q.getSize()<=25){
								if(count==25)
									System.out.print(".");
								else
									System.out.print(",");
							}
							Thread.sleep(100);
						}
						System.out.println();
					}else{
						System.out.println("Q is empty...");
						Thread.sleep(1000);
					}
					System.out.println("------------------------------------------------");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("darshan stopped...");
	}
	public boolean isWaitStatus() {
		return waitStatus;
	}
	public void setWaitStatus(boolean waitStatus) {
		this.waitStatus = waitStatus;
	}
}
