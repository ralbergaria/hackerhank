package hackerhank.bignumber.dataStructures;

import java.util.Scanner;

public class Solution_1darray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Integer[] a = new Integer[n];

		for(int i = 0 ; i < n; i++){
			int val = scan.nextInt();
			a[i] = val;
		}

		scan.close();

		// Prints each sequential element in array a
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}
