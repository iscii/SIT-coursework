import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.stream.Collectors;

class The_Comparator implements Comparator<String> {
		
	/**
	* Step 1: Compare two large numbers 
	* return -1 if numberA > numberB;
	* return 1 if numberA < numberB;
	* return 0 if they are equal.
	*/
	public int compare(String numberA, String numberB)
	{
		//this is in reverse! numberA > numberB returns -1 (comparing B to A rather than A to B)
		return numberB.compareTo(numberA) == 0 ? 0 : numberB.compareTo(numberA) / Math.abs(numberB.compareTo(numberA));
	}
}


public class ConcatNumbers {
		
	/**
	* Step 2: Check whether a large number concatenated by numberA and numberB is divisible by 3.
	* return true if the concatenated number can be divisible by 3
    * return false if the concatenated number can not be divisible by 3
    */	
	public boolean check_concatenation_dividable_by_three(String numberA, String numberB) {
		char[] arr = (numberA+numberB).toCharArray();
		int digitsum = 0;
		for (int i = 0; i < arr.length; i++) {
			digitsum += Character.getNumericValue(arr[i]);
		}
		return digitsum % 3 == 0;
	}

	
	/**
	 * Step 3: 
	* @return a string list which contains the maximum K concatenated numbers which can be divisible by 3.
    */	
	public String[] KMaxConcatenations(String[] A, String[] B, int N, int K){
		//priorityqueue stores elements in order based on the passed function parameter - priority
		PriorityQueue<String> pq = new PriorityQueue<String>(new The_Comparator());
		for (int i = 0; i < N; i++) { //A
			for (int j = 0; j < N; j++) { //B
				if(check_concatenation_dividable_by_three(A[i], B[j]))
					pq.add(A[i] + B[j]);
			}
		}
		String[] s = new String[K];
		int c = 0;
		while(c<K && !pq.isEmpty()){
			s[c] = pq.poll();
			c++;
		}
		
		return s;
	}

	public static void main(String[] args){
		//compare test
		The_Comparator a = new The_Comparator();
		System.out.println(a.compare("6", "4"));
		System.out.println(a.compare("4", "4"));
		System.out.println(a.compare("4", "6"));

		//divide test
		ConcatNumbers b = new ConcatNumbers();
		System.out.println(b.check_concatenation_dividable_by_three("23252624", "53735734"));

		//concat test
		System.out.println(
			Arrays.toString(
			b.KMaxConcatenations(
				new String[]{"1","2","3"},
				new String[]{"4","5","6"},
				3,
				2
			))
		);
		System.out.println(
			Arrays.toString(
			b.KMaxConcatenations(
				new String[]{"4","5","6"},
				new String[]{"1","2","3"},
				3,
				2
			))
		);
		
	}
}
