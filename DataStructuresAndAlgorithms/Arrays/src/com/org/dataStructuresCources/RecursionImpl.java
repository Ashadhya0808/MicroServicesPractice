package com.org.dataStructuresCources;

public class RecursionImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(recursionFactorial(19));

	}
	
	public static int recursionFactorial(Integer num) {
		if(num == 0 ) {
			return 1;
		}
		return num * recursionFactorial(num-1);
	}
	
	

}
