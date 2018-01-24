package hackerhank.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_listinsertdelete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String comando = sc.next();
			if (comando.equals("Insert")){
				int index = sc.nextInt();
				int element = sc.nextInt();
				list.add(index, element);
			} else {
				int element = sc.nextInt();
				if(element > list.size()) continue;
				list.remove(element);
			}
		}

		sc.close();

		for(int number : list) {
			System.out.print(number + " ");
		}

	}

}
