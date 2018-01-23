package hackerhank.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_anagrams {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		String B = scan.next();
		boolean anagrams = true;
		if(A.length() == B.length()) {
			char[] a = A.toLowerCase().toCharArray();
			char[] b = B.toLowerCase().toCharArray();
			Arrays.sort(a);
			Arrays.sort(b);
			for(int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					anagrams = false;
					break;
				}
			}			
		} else {
			anagrams = false;
		}
		
		System.out.println(anagrams?"Anagrams":"Not Anagrams");
	}
}
