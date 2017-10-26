package bat.firstClass;

import java.util.Stack;

/**
* @author qishuwen
* @version 创建时间：2017年10月26日 下午5:37:04
* 1.链表递归栈 p71
*/
public class IsPossible {
	public static void main(String[] args) {
		String[] in = {"A","B","C","D","E","F","G"};
		String[] out = {"B","A","E","D","F","G","C"};
		
		boolean possibleMethod1 = isPossibleMethod1(in,out);
		boolean possibleMethod2 = isPossibleMethod2(in,out);
		System.out.println(possibleMethod1);
		System.out.println(possibleMethod2);
	}
	
	private static boolean isPossibleMethod1(String[] in, String[] out) {
		Stack<String> s = new Stack<String>();
		int i = 0;
		int j = 0;
		
		while(j < out.length || i < in.length) {
			if(!s.isEmpty()) {
				if(s.peek().equals(out[j])) {
					s.pop();
					j++;
				}else {
					if(i >= in.length) {
						return false;
					}else {
						s.push(in[i]);
						i++;
					}
				}
				
			}else {
				if(i >= in.length) {
					return false;
				}
				s.push(in[i]);
				i++;
			}
		}
		return true;
	}

	//合并条件
	private static boolean isPossibleMethod2(String[] in, String[] out) {
		Stack<String> s = new Stack<String>();
		int i = 0;
		int j = 0;
		
		while(j < out.length || i < in.length) {
			if(!s.isEmpty() && s.peek().equals(out[j])) {
				s.pop();
				j++;
			}else {
				if(i >= in.length) {
					return false;
				}
				s.push(in[i]);
				i++;
			}
		}
		return true;
	}

}
