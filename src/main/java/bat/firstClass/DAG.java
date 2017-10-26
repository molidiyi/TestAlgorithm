package bat.firstClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DAG {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		
		
		System.out.println(stack.firstElement());
		System.out.println(stack.remove(0));
		System.out.println(stack.firstElement());
		System.out.println(stack.pop());
		
//		
//		System.out.println(stack.get(2));
//		
//		System.out.println(stack.pop());
	}
}
