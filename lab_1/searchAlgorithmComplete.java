package lab_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Gopal Sharma
 * This program compares the performance of Linear and Interpolation algorithm and also improves the existing performance of Linear search algorithm
 *
 */
public class searchAlgorithmComplete {
	
	static boolean check = true; // boolean variable to check whether the key value is in the array or not.If yes, then only the further time calculations will be done

	
	/**
	 * Linear Search Algorithm
	 * @param array
	 * @param key
	 */
	static void LinearSearch(int[] array, int key) {
		boolean found = false;  // local boolean variable to test whether key value is in array or not
		System.out.println("");
		System.out.println("Using Linear Search: ");
		// for loop to go through all elements one by one to check the given key value
		for (int i = 0; i < array.length; i++) {  
			if (array[i] == key) {
				System.out.println("Search key found at index : " + i);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Search key NOT FOUND");
			check = false;  // updating the global variable check
		}
	}

	 
	/**
	 * Optimised linear search algorithm using hybrid approach of linear and binary search algorithm
	 * @param array
	 * @param key
	 */
	static void optimisedLinearSearch(int[] array, int key) {
		System.out.println("");
		System.out.println("Using Optimized Linear Search: ");
		boolean found = false; // local boolean variable to test whether key value is in array or not
		int low = 0, mid, high = array.length-1; // setting the initial values
		mid = (low + high) / 2; // checking middle value
		if(key == array[mid]) { // if key matches the mid value, then the index value is printed
			System.out.println("Search key found at index : " + mid);
			found = true;
		}
		// taking the right half of array (depending upon the value of key value)
		else if(key < array[mid]) {
			high = mid-1;
			
		// taking the left half of the array (depending upon the value of key value)
		}
		else if(key > array[mid] ) {
			low = mid +1;
		}
		else  { // processing the resultant half sized array using linear search algorithm
			for (int i = 0; i < array.length; i++) {
				if (array[i] == key) {
					System.out.println("Search key found at index : " + i);
					found = true;// local boolean variable to test whether key value is in array or not
					break;
				}
			}
			if (!found) {
				System.out.println("Search key NOT FOUND");
				check = false; // updating the global variable check
			}
			
		}
	}
			

	
	/**
	 * Interpolation Search Algorithm
	 * @param array
	 * @param key
	 */
	static void interpolationSearchIterative(int[] array, int key) {
		boolean found1 = false; // local boolean variable to test whether key value is in array or not
		int low = 0, mid, high = array.length - 1; // setting the initial values
		System.out.println("Using Interpolation Search: ");
		while (low <= high) { // using formulas of interpolation search algorithm
			int pos = (key - array[low]) / (array[high] - array[low]);
			mid = low + (((high - low) * pos));
			if (key < array[mid])
				high = mid - 1;
			else if (array[mid] < key)
				low = mid + 1;
			else {
				found1 = true;
				System.out.println("Search key found at index : " + mid);
				break;
			}
		}
		if (!found1) {
			System.out.println("Search key NOT FOUND");
			check = false;// updating the global variable check
		}
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);  // initializing the scanner object
		// Taking array size from the user
		System.out.print("Enter the number of elements in the array : ");
		int arraySize = myobj.nextInt();

		// taking array inputs from user
		int[] array = new int[arraySize];
		System.out.println("Enter the elements in the array :");
		for (int i = 0; i < arraySize; i++) {
			array[i] = myobj.nextInt();
		}
		
		// Taking the search key
		System.out.print("Enter the search key : ");
		int searchKey = myobj.nextInt();

		// linear Search algorithm - to find the key value index and to calculate the running time
		long startTime1 = System.nanoTime();
		LinearSearch(array, searchKey); 
		long endTime1 = System.nanoTime();
		long totalTime1 = endTime1 - startTime1;
		System.out.println("");

		// Sort the array in ascending order
		Arrays.sort(array);

		// Using interpolation algorithm to find the key value index and to calculate the running time
		long startTime2 = System.nanoTime();
		interpolationSearchIterative(array, searchKey);
		long endTime2 = System.nanoTime();
		long totalTime2 = endTime2 - startTime2;
		System.out.println("");

		// comparing the running times of Linear  and interpolation algorithms and  displaying the same
		if(check == true) { // will run only if the key value will be found in the array
			System.out.println("The execution time for Linear search is :" + totalTime1);
			System.out.println("The execution time for interpolation search is :" + totalTime2);
			long difference = totalTime1 - totalTime2;
			System.out.println("The interpolation search is faster than Linear search by : " + difference + " microseconds");
			System.out.println(" **Interpolation search is often faster than linear search because it makes use of the distribution of elements in a sorted array to make intelligent guesses about the location of the target element.**");		
		}
		
		

		// improving the running time of the linear search by at least 20% by using Optimised Linear search algorithm
		if(check == true) // will run only if the key value will be found in the array
		{
		long startTime3 = System.nanoTime();
		optimisedLinearSearch(array, searchKey);
		long endTime3 = System.nanoTime();
		long totalTime3 = endTime3 - startTime3;
		double diff1 = ((double)(totalTime1 - totalTime3)/totalTime1)*100;
		System.out.println("The Optimised Linear search is faster than Linear search by : " + String.format("%.2f", diff1) + "%");
		System.out.println("*In the Optimised Linear search, firstly array is sorted then the array is divided into two halves using binary serach method and then linear serach is applied on the resulting array* ");
		}
		// Scanner object close
		myobj.close();

	}

}
