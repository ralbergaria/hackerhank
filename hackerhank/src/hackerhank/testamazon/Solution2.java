package hackerhank.testamazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
	
	static int[] oddNumbers(int l, int r) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = l; l <= r; l++) {
			if (l % 2 != 0) {
				arr.add(l);
			}
		}
		
		int[] retorno = new int[arr.size()];
		
		for (int i = 0; i < arr.size(); i++){
			retorno[i] = arr.get(i);
		}
		
		return retorno;
    }
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        int _l;
        _l = Integer.parseInt(in.nextLine().trim());
        
        int _r;
        _r = Integer.parseInt(in.nextLine().trim());
        
        res = oddNumbers(_l, _r);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}
