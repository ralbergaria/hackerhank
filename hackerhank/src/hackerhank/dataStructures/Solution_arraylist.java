package hackerhank.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_arraylist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for(int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<Integer>();
			int x = sc.nextInt();
			for(int j = 0; j < x; j++) {
				list.add(sc.nextInt());
			}
			matrix.add(list);
		}
		
		n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String[] pos = sc.nextLine().split("\\s");
			try {
				System.out.println(matrix.get(Integer.valueOf(pos[0])-1).get(Integer.valueOf(pos[1])-1));
			} catch (Exception e) {
				System.out.println("ERROR!");
			}
		}

	}

}
