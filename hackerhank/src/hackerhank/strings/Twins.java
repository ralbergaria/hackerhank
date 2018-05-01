package hackerhank.strings;
import java.io.IOException;
import java.util.Scanner;
/**
 * Two strings, a and b, are said to be twins only if they can be made equivalent by performing some number of operations on one or both strings. There are two possible operations:

SwapEven: Swap a character at an even-numbered index with a character at another even-numbered index.
SwapOdd: Swap a character at an odd-numbered index with a character at another odd-numbered index.
For example, a = "abcd" and b = "cdab" are twins because we can make them equivalent by performing operations. Alternatively, a = "abcd" and b = "bcda" are not twins (operations do not move characters between odd and even indices), and neither are a = "abc" and b = "ab" (no amount of operations will insert a c into string b).

Complete the code in the editor below, the twins() method with the following params.

An array of n strings named a.
An array of n strings named b.
The function must return an array of strings where each index i (0 ≤ i < n) contains the string Yes if ai and bi are twins or the string No if they are not.
 * @author Rafael
 *
 */
public class Twins {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static String[] twins(String[] a, String[] b) 
    {
    	int size = a.length;
    	String[] retorno = new String[size];
    	for(int i = 0; i < size; i++) {
    		char[] aC = a[i].toCharArray();
    		char[] bC = b[i].toCharArray();
    		if (aC.length != bC.length) {
    			retorno[i] = "No";
    			continue;
    		}
    		
    		
    		for (int j = 0; j < aC.length; j++){
    			if (retorno[i] != null) {
    				break;
    			}
    			
    			boolean search = true;
    			int l = j;
    			while(search) {    				    				
    				if(aC[j] == bC[l]) {
    					char aux = bC[l];
    					bC[l] = bC[j];
    					bC[j] = aux;
    					break;
    				}
    				
    				l = l + 2;
    				
    				if (l  >= aC.length){
    					search = false;
    					retorno[i] = "No";    					
    				}
    			}
    			
    			String text = String.valueOf(bC);
    			if (a[i].equals(text)){
    				retorno[i] = "Yes";
    				break;
    			}
    		}    		
     	}
    	
    	return retorno;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String[] res;
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        String[] _a = new String[_a_size];
        String _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            try {
                _a_item = in.nextLine();
            } catch (Exception e) {
                _a_item = null;
            }
            _a[_a_i] = _a_item;
        }
        
        
        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine().trim());
        String[] _b = new String[_b_size];
        String _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            try {
                _b_item = in.nextLine();
            } catch (Exception e) {
                _b_item = null;
            }
            _b[_b_i] = _b_item;
        }
        
        res = twins(_a, _b);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}