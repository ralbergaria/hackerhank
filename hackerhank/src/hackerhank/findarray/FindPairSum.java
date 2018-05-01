package hackerhank.findarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Having an array of integers and a given number, find all the pairs of numbers in the array which sum is equal to
 * the given number.
 * For example, given the array [1, 4, 7, 9, 6] and the number 10, the method should find the pairs [1,9] and [4,6]
 * @author Rafael
 *
 */
public class FindPairSum {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(6);
		
		getPair(list, 10);
	}
	
	
	private static void getPair(List<Integer> list, int sum) {
		Integer offSet = 0;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			offSet = sum - list.get(i);
			if(list.contains(offSet)) {
				result.append("[" + list.get(i) + "," + offSet + "]");
				list.remove(offSet);
			}
		}
		System.out.println(result.toString());
	}
}
