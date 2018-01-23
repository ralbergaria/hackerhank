package hackerhank.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_compare {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();      
        System.out.println(getSmallestAndLargest(s, k));
	}
	
	public static String getSmallestAndLargest(String s, int k) {
        List<String> listStrings = new ArrayList<String>();
        for(int i=0; k <= s.length() ;i++) {
        	listStrings.add(s.substring(i, k));
        	k ++;
        }        
        Collections.sort(listStrings);
        
        return listStrings.get(0) + "\n" + listStrings.get(listStrings.size()-1);
    }
}
