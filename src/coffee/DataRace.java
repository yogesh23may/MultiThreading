package coffee;

public class DataRace {
	public static void main(String args[]) {
		UseCounter c = new UseCounter();
		Thread t1 = new Thread(c);t1.setName("T1");
		Thread t2 = new Thread(c);t2.setName("T2");
		Thread t3 = new Thread(c);t3.setName("T3");
		t1.start();
		t2.start();
		t3.start();
		
		
	}
}

class Counter {
	public static long count = 0;
}

class UseCounter implements Runnable {
	public void increment() {
		synchronized(this){
			Counter.count++;
			System.out.print(Counter.count + " by " +Thread.currentThread().getName() +"\n");
		}		
	}
	public void run() {
		increment();
		increment();
		increment();
	}
}