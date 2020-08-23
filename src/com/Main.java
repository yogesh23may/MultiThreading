package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Q q = new Q();

		Display disp = new Display(q);
		Thread dispThread = new Thread(disp);
		dispThread.setName("darshan");
		dispThread.start();

		Consumer consumer = new Consumer(q);
		Thread conThread1 = new Thread(consumer);
		conThread1.setName("consumer1");
		conThread1.start();

		Thread conThread2 = new Thread(consumer);
		conThread2.setName("consumer2");
		conThread2.start();

		Thread conThread3 = new Thread(consumer);
		conThread3.setName("consumer3");
		conThread3.start();

		Producer producer = new Producer(q);
		Thread prodThread = new Thread(producer);
		prodThread.setName("production");
		prodThread.start();
		
		//to rerun the code for producing data
		String next ="Y";
		while(next.charAt(0)=='Y'||next.charAt(0)=='y'){
			try {
				Thread.currentThread().sleep(20000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if(!disp.isWaitStatus()){
				System.out.println("consumer threads active....");
			}else{
				System.out.println("all consumer thread completed....");
				System.out.println("do you want to continue:-");
				Scanner scan = new Scanner(System.in);
				next = scan.next();
				if(next.charAt(0)=='Y' || next.charAt(0)=='y'){
					Thread prodThread1 = new Thread(producer);
					prodThread1.setName("production");
					prodThread1.start();
				}
			}
		}
		
		System.exit(0);
	}
}


