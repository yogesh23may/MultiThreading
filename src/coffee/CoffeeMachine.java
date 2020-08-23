package coffee;

public class CoffeeMachine extends Thread {
	static String coffeeMade = null;
	static final Object lock = new Object();
	private static int coffeeNumber = 1;
	void makeCoffee() {
		synchronized(CoffeeMachine.lock) {
			if(coffeeMade != null) {
				try {
					System.out.println("Coffee machine: Waiting for waiter notification to deliver the coffee");
					CoffeeMachine.lock.wait();
				}
				catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			coffeeMade = "Coffee No. " + coffeeNumber ++;
			System.out.println("Coffee machine says: Made " + coffeeMade);
			CoffeeMachine.lock.notifyAll();
			System.out.println("Coffee machine: Notifying waiter to pick the coffee ");
		}
	}
	public void run() {
		while(true) {
			makeCoffee();
			try {
				System.out.println("Coffee machine: Making another coffee now");
				Thread.sleep(10000);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

