package squareTrade;

import java.util.Scanner;



public class Fibonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer n = Integer.valueOf(scan.next());
		n = fib(n);
		System.out.println(n);
	}

	private static Integer fib(Integer n) {
		if (n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}
}
