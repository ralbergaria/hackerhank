package hackerhank.strings;

import java.util.Scanner;

public class Solution_palidrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int k = A.length();
        int i = 0;
        boolean palidrome = true;
        while(i < k) {
        	if(!A.substring(i, i+1).equals(A.substring(k-1, k))) {
        		palidrome = false;
        		break;
        	}
        	k--; i++;
        }
        if (palidrome)
        	System.out.println("Yes");
        else
        	System.out.println("No");
	}
}
