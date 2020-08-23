package coffee;

public class ThreadStates_Three {
	public static void main(String []s) throws InterruptedException {
		Thread t = new InfiniteWaitThread();
		t.start();
		System.out.println(t.getName() + ": I'm in state " + t.getState());	
		
	}
}


class InfiniteWaitThread extends Thread {
	synchronized public void run() {
		while(true) {
			try {
				wait(1000);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

