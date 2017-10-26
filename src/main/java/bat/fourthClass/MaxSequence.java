package bat.fourthClass;
/**
* @author qishuwen
* @version 创建时间：2017年9月11日 下午6:46:12
* 寻找最长连续递增子数组
*/
public class MaxSequence {
	
	public static void main(String[] args) {
		int a[] = {1,2,3,34,56,57,58,59,60,61,99,121};
		int maxSequence = maxSequenceLength(a);
		System.out.println(maxSequence);
		maxSequence(a);
	}
	
	//最长长度
	public static int maxSequenceLength(int a[]) {
		int p[] = new int [a.length];
		int i;
		for (i = 0; i < a.length; i++) {
			p[i] = 1;
		}
		int m = 1;
		for (i = 1; i < a.length; i++) {
			if(a[i] - a[i-1] == 1) {
				p[i] += p[i-1];
				m = p[i]>m?p[i]:m;
			}
		}
		
		return m;
	}
	
	public static void maxSequence(int a[]) {
		int from = 0;
		int to = 0;
		int p[] = new int [a.length];
		int i;
		for (i = 0; i < a.length; i++) {
			p[i] = 1;
		}
		int m = 1;
		for (i = 1; i < a.length; i++) {
			if(a[i] - a[i-1] == 1) {
				to = i;
				p[i] += p[i-1];
				m = p[i]>m?p[i]:m;
			}
		}
		from = to - m + 1;
		
		System.out.println(from+"--"+to+"--"+m);
	}
}
