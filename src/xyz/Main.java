package xyz;

import java.util.Arrays;



public class Main {

	public static void main(String[] args) {
		int[] arr = {9,2,4,5,4,6,7,4,5,6,8,9,8};
		int[] op =null;
		op = task(arr.length,arr);
		System.out.println(Arrays.toString(op));
		
			
		class MyThread extends Thread{
			public void run(){
				System.out.println("mythread...");
			}
		}
		MyThread myThread = new MyThread();
		myThread.start();
		
		
		Thread t = new Thread(){
			public void run(){
				System.out.println("hello...");
			}
		};
		t.start();
		
		
		String input = "abakhababa";
		String pattern = "aba";
		int output = 0;

		for (int i = 0; i < input.length(); i++) {
			if (i < (input.length() - (pattern.length() - 1))
					&& input.substring(i, i + pattern.length()).equals(pattern)) {
				output++;
			}
		}
		System.out.println("count = " + output);
			
	}

	public  static int[] task(int len,int[] ip2){
		int temp = 0;
		int init = 0;
		int count = 0;
		int[] op=new int[len];
		for(int i=0;i<len-1;i++){
			if(ip2[i]>0){
				init = 0;
				for(int j=i+1;j<len;j++){
					if(ip2[i]==ip2[j]){
						if(init==0){
							op[i]=ip2[j];
							ip2[j]=-1;
							init = 1;
							count++;
						}else{
							ip2[j]=-1;
						}
					}
				}
			}
		}
		int tmp = 0;
		int[] finOP=new int[count];
		for(int i=0;i<len;i++){
			if(op[i]==0){
				continue;
			}else{
				finOP[tmp]=op[i];
				tmp++;
			}
		}
		return finOP;
	}
}
