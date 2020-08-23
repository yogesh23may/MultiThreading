package xyz;

public class LinearListMain implements LinearListADT {

	public static void main(String[] args) {
		LinearListMain main = new LinearListMain();
		LinkedList first =  main.createList();
		System.out.println(first.hashCode());
		Integer res = main.getElement(first,2);
		System.out.println("res = "+res);
	}

	@Override
	public Integer getElement(LinkedList list, int index) {
		System.out.println(list.hashCode());
		Integer ret = null;
		if(index<0)	
			ret = null;
		if(index==0)
			ret = list.data;
		if(index>0){
			for(int i=0;i<index;i++){
				list = list.next;
				if(null!=list)
					ret = list.data;
				else
					ret = null;
			}			
		}else{
			ret = null;
		}
		return ret;
	}

	private LinkedList createList(){
		LinkedList first = new LinkedList();
		LinkedList second = new LinkedList();
		LinkedList third = new LinkedList();
		
		first.data=10;
		first.next=second;
		
		second.data=20;
		second.next=third;
		
		third.data=30;
		third.next=null;
		
		return first;
	}
}
