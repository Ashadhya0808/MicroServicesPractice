package com.org.dataStructuresCources;

/*Time Complexity of Selection Sort is O(n2)[Quadratic] - as we are using 2 for loops
It is a Stable Sorting Algorithm */
public class InsertionSortImpl {

	public static void main(String[] args) {
		
		int[] intArray = { 20,35,-15,7,55,1,-22 };
		
		for(int indexOfUnsortedArray = 1 ; 
				indexOfUnsortedArray < intArray.length ; indexOfUnsortedArray++) {
			int newElement = intArray[indexOfUnsortedArray];
			int i;
				for(i = indexOfUnsortedArray ; i > 0 && newElement<intArray[i-1]; i--) {
					intArray[i] = intArray[i-1];
				}
				intArray[i] = newElement;
		}
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}
	}

}
