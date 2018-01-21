package hackerhank.strings;

import java.util.Scanner;

public class Solution_stringintroduction {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        System.out.println(A.length() + B.length());
        if(A.compareTo(B) > 0) {
        	System.out.println("Yes");
        } else {
        	System.out.println("No");
        }
        String charA = A.substring(0, 1);
        String charB = B.substring(0, 1);
        System.out.println(A.replaceFirst(charA, charA.toUpperCase()) +" "+ B.replaceFirst(charB, charB.toUpperCase()));
	}    
}
