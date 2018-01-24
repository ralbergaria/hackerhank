package hackerhank.dataStructures;

import java.util.Scanner;

public class Solution_gamearray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
		}
		scan.close();

	}

	public static boolean canWin(int leap, int[] game) {
		return isSolvable(leap, game, 0);
	}

	private static boolean isSolvable(int m, int[] arr, int i) {
	    if (i < 0 || arr[i] == 1) return false;
	    if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

	    arr[i] = 1;
	    return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
	}
}
