package hackerhank.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_bigdecimal {
	public static void main(String[] args){
		//Input
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		String []s=new String[n+2];

		for(int i=0;i<n;i++){
			s[i]=sc.next();
		}
		
		s = Arrays.stream(s).filter(array -> array != null).toArray(String[]::new);
		
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				BigDecimal a = new BigDecimal(o1);
				BigDecimal b = new BigDecimal(o2);
				return b.compareTo(a);
			}
		});

		//Output
		for(int i=0;i<n;i++)
		{
			System.out.println(s[i]);
		}
	}
}