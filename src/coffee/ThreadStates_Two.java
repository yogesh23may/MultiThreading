package coffee;

public class ThreadStates_Two {
	public static void main(String []s) {
		Thread t1 = new SleepyThread();
		Thread t2 = new SleepyThread();
		t1.start();
		t2.start();
		System.out.println(t1.getName() + ": I'm in state " + t1.getState());
		System.out.println(t2.getName() + ": I'm in state " + t2.getState());
	}
}

class SleepyThread extends Thread {
	public void run() {
		synchronized(SleepyThread.class) {
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}