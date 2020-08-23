package com;

import java.util.ArrayList;
import java.util.List;

public class Q {
	private static int count = 0;
	public List<Integer> listData = new ArrayList<Integer>();
	
	public int pushData(int data){
		listData.add(data);
		return count++;
	}
	
	public int popData(){
		listData.remove(--count);
		return count;
	}
	
	public int getSize(){
		return count;
	}
	
	public List<Integer> getData(){
		return listData;
	}
}
