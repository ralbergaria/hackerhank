package hackerhank.dataStructures;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Solution_stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			try {
				Stack<String> stack = new Stack<String>();
				String[] input=sc.next().split("");
				for (String c : input){
					switch (c) {
					case "}":
						if(stack.peek().equals("{")) stack.pop();
						break;
					case ")":
						if(stack.peek().equals("(")) stack.pop();
						break;
					case "]":	
						if(stack.peek().equals("[")) stack.pop();
						break;	
					default:
						stack.push(c);
					}
				}
				System.out.println(stack.isEmpty());
			} catch (EmptyStackException e){
				System.out.println("false");
			}
		}
	}
}
