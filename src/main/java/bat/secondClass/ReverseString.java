package bat.secondClass;

/**
 * 字符串循环做移
 * abcdef ==》 cdefab
 * @author jennyzou
 *
 */
public class ReverseString {
	public static void main(String[] args) {
		String string = "abcdefghi";
		char[] str = string.toCharArray();
		leftString(str,4,3,2);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
	}
	
	/**
	 * 
	 * @param str
	 * @param m 从第几位开始移动
	 * @param n 移动几个字符
	 * @param move 移动几位
	 */
	public static void leftString(char[] str,int m,int n,int move) {
		//移动两个字符
		m = m-1;
		n = n-1;
		//容错
		if(m-move<0) {
			System.err.println("下标越界");
			return;
		}
		
		reverseString(str,m-move,m-1);
		reverseString(str,m,m+n);
		reverseString(str,m-move,m+n);
	}
	
	public static void reverseString(char[] str,int from,int to) {
//		System.out.println(from+"-->"+to);
		while(from < to) {
			char temp = str[from];
			str[from++] = str[to];
			str[to--] = temp;
		}
	}
}
