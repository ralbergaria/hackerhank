package hackerhank.dataStructures;

import java.util.Scanner;

public class Solution_subarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int contN = 0; 
		for(int i = 0; i < n; i++){
			array[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++){
			int sum = 0;
			for (int j = i; j < n; j++){
				sum += array[j];
				if (sum < 0)
					contN++;
			}
		}
		System.out.println(contN);
		sc.close();
	}
	
}
