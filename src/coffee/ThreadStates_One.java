package coffee;

public class ThreadStates_One {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new MyThread());
		System.out.println("Just after creating thread; " +" The thread state is: " + t.getState());
		Thread.currentThread().sleep(1000);
		t.start();
		Thread.currentThread().sleep(1000);//comment this and see the difference
		System.out.println("Just after calling t.start(); " +" The thread state is: " + t.getState());
		t.join();
		System.out.println("Just after main calling t.join(); " +" The thread state is: " + t.getState());
	}

}

class MyThread extends Thread{
	public void run(){
		for(int i=0;i<1;i++){
			try {
				sleep(3000);				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
