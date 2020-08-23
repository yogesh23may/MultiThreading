package com;

public class TMainJoin {
	private static Q q = new Q();
	public static void main(String[] args) {
		Thread2 t2 = new Thread2();t2.setName("threadB");
		Thread1 t1 = new Thread1(t2);t1.setName("threadA");
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("threadA joining main thread...");
	}
}
