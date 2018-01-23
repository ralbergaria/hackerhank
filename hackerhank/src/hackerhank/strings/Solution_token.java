package hackerhank.strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_token {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		if(s.equals("")) {
			System.out.println(0);
		} else if(s.length() > 400000){
			scan.close();
			return;
		} else {
			StringTokenizer result =  new StringTokenizer(s, "[_@!?.', ]+");
			System.out.println(result.countTokens());
			while(result.hasMoreTokens()) {
				System.out.println(result.nextToken());
			}
		}
		scan.close();
	}
}
