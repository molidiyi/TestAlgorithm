package leetCode;
/**
* @author qishuwen
* @version 创建时间：2017年9月18日 下午4:04:01
* <pre>
* 原题
* You are given two linked lists representing two non-negative numbers.
* The digits are stored in reverse order and each of their nodes contain
* a single digit. Add the two numbers and return it as a linked list.
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
*
* 题目大意
* 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
* 即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
*
* 解题思路
* 对两个链表都从第一个开始处理，进行相加，结果再除以10求商，作为下一位相加的进位，
* 同时记录余数，作为本位的结果，一直处理，直到所有的结点都处理完。
* </pre>
*
* @param l1 第一个数
* @param l2 第二个数
* @return 结果
*/
public class AddTwoNumbers002 {
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(3);
		ListNode l13 = new ListNode(4);
		
		ListNode l21 = new ListNode(7);
		ListNode l22 = new ListNode(5);
		ListNode l23 = new ListNode(8);
		
		l11.next = l12;
		l12.next = l13;
		
		l21.next = l22;
		l22.next = l23;
		
		
		ListNode addTwoNumbers = addTwoNumbers(l11,l21);
		System.out.println(addTwoNumbers);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = x + y + carry;
			System.out.println(sum+"-"+x+"-"+y+"-"+carry);
			carry = sum / 10;
			
			current.next = new ListNode(sum % 10);
			current = current.next;
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		if (carry > 0) {
			current.next = new ListNode(carry); 
		}
		return dummyHead.next;
	}
}
class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
}
