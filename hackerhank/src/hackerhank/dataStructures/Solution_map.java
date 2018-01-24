package hackerhank.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_map {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	      int n=in.nextInt();
	      in.nextLine();
	      Map<String, Integer> m = new HashMap<String, Integer>();
	      for(int i=0;i<n;i++)
	      {
	         String name=in.nextLine();
	         int phone=in.nextInt();
	         m.put(name, phone);
	         in.nextLine();
	      }
	      while(in.hasNext())
	      {
	         String s=in.nextLine();
	         System.out.println(m.get(s) == null? "Not found" : s+"="+m.get(s));
	      }
	}
}
