package hackerhank.dataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_queue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        
        Set<Integer> set = new HashSet<Integer>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.offer(num);
            set.add(num);
            
            if (deque.size() == m){
            	if (set.size() > max) {
            		max = set.size();
            	}
            	int value = (int) deque.poll();	
            	if(!deque.contains(value) ) set.remove(value);
            }
        }
        
        System.out.println(max);
	}
}
