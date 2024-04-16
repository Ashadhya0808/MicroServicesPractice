package com.org.dataStructuresCources;

/*Time Complexity of Selection Sort is O(n2)[Quadratic] - as we are using 2 for loops
 But Swaps are not as much as in bubble Sort
 It is an Unstable Sorting Algorithm */
public class SelectionSortImpl {

	public static void main(String[] args) {
		int[] intArray = { 21,35,-15,7,55,1,-22 };
		int largestIndex = 0;
		
		for(int lastUnsortedIndex = intArray.length - 1 ; 
				lastUnsortedIndex > 0 ; lastUnsortedIndex--){
			for(int i=0 ; i < lastUnsortedIndex ; i++) {
				if(intArray[largestIndex]<intArray[i]) {
					largestIndex = i;
				}
			}
			swap(intArray, largestIndex, lastUnsortedIndex);
		}
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}
	}
	
	public static int[] swap(int[] array, int i, int j) {
		if(i==j) {
			return array;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}

}
