package bat.fourthClass;

public class Mode {
	
	public static void main(String[] args) {
		int a[] = {1,2,2,2,3,3,2};
		int b[] = {1,2,3,2,5,2,2,3,3,2,3};
		int mode = mode2(a);
		System.out.println(mode);
		mode3(b);
		
//		int a = 0;
//		int b = 0;
//		if(a!=b) {
//			System.out.println("a==b");
//		}else if(a==0){
//			System.out.println("a");
//		}else if(b==0){
//			System.out.println("b");
//		}
	}
	
	/**
	 * 2个数绝对众数
	 * @param a
	 * @return
	 */
	public static int mode2(int a[] ) {
		int count = 0;
		int m = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(count == 0) {
				m = a[i];
				count = 1;
			}else if(m == a[i]) {
				count ++;
			}else { //else if(m != a[i])
				count --;
			}
		}
		return m;
	}
	
	public static void mode3(int []a) {
		int m = 0;
		int n = 0;
		
		int countm = 0;
		int countn = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(countm == 0) {
				m = a[i];
				countm = 1;
			}else if(countn == 0) {
				n = a[i];
				countn = 1;
			}else if(m == a[i]) {
				countm++;
			}else if(n == a[i]) {
				countn++;
			}else {
				countm--;
				countn--;
			}
//			System.out.println(countm+"====="+countn);
		}
		System.out.println(m+"====="+n);
		
	}
}
