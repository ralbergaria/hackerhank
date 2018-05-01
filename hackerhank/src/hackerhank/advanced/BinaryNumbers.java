package hackerhank.advanced;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * Consider an array of n decimal integers named elements. We want to rearrange elements according to the following rules:

Sort the integers in ascending order by the number of 1's in their binary representations. For example, 710 → 1112 and 810 → 10002, so 8 (which has single 1 in binary) would be ordered before 7 (which has triple 1's in binary).
Two or more integers having the same number of 1's in their binary representations are ordered by increasing decimal value. For example, 510 → 1012 and 610 → 1102 both contain double 1's in their binary representation, so 5 would be ordered before 6 because it has the smaller decimal value.
Complete the rearrange function in the editor below. It has one parameter: an array of n integers, elements. The function must sort the elements array according to the rules above and return the sorted array.
 * @author Rafael
 *
 */
public class BinaryNumbers {
	
    /**
     * Complete the function below.
     * DONOT MODIFY anything outside this function!
     */
    static int[] rearrange(int[] elements) {
    	
    	List<Integer> list = Arrays.stream(elements).boxed().collect(Collectors.toList());
    	list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Integer.bitCount(o1) == Integer.bitCount(o2)){
					return o1.compareTo(o2);
				}
				return Integer.bitCount(o1) - Integer.bitCount(o2);
			}        	
		});
		elements = list.stream().mapToInt(i->i).toArray();		
		return elements;		
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = 0;
        n = Integer.parseInt(in.nextLine().trim());
        int[] elements = new int[n];
        int element;
        for (int i = 0; i < n; i++) {
            element = Integer.parseInt(in.nextLine().trim());
            elements[i] = element;
        }
        
        // call rearrange function
        int[] results = rearrange(elements);
        
        for (int i = 0; i < results.length; i++) {
            System.out.println(String.valueOf(results[i]));
        }
    }
}