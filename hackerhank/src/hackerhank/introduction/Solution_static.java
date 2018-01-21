package hackerhank.introduction;

import java.util.*;


class Solution_static{
	static boolean flag;
	static int B;
	static int H;
	static {
	    flag = true;
	    Scanner sc = new Scanner(System.in);        
	    B = sc.nextInt();    
	    H = sc.nextInt();
	    String.valueOf(H);
	    if (B <= 0 || H <= 0){
	        flag = false;
	        System.out.print("java.lang.Exception: Breadth and height must be positive");
	    }
	}
	
    public static void main(String []argh)
    {
    	if(flag){
			int area=B*H;
			System.out.print(area);
		}

    }
    
}
