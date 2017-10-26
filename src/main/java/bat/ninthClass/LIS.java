package bat.ninthClass;
/**
* @author qishuwen
* @version 创建时间：2017年10月11日 下午4:04:59
* 
*/
public class LIS {
	public static void main(String[] args) {
		int[] a = {1,4,6,2,8,9,7};
//		int lis1 = lis1(a);
//		System.out.println(lis1);
		int lis2 = lis2(a);
		System.out.println(lis2);
	}
	
	//时间复杂度 n^2 
	public static int lis1(int[] a) {
		int[] b = new int[a.length];
		
		int i,j;
		for (i = 0; i < a.length; i++) {
			b[i] = 1;
		}
		
		int nLis = 1;
		for (i = 1; i < a.length; i++) {
			for (j = 0; j < i; j++) {
				if(a[j] <= a[i]) {
					b[i] = max(b[i],b[j]+1);
				}
			}
			nLis = max(nLis,b[i]);
		}
		print(b);
		return nLis;
	}

	//时间复杂度 nlogn
	public static int lis2(int[] a){
		int[] b = new int[a.length]; 
		int s = 0;
		int i;
		for (i = 0; i < a.length; i++) {
			s = insert(b,s,a[i]);
			print(b);
		}
		return s;
	}
	
	
	public static int insert(int[] b, int s, int x) {
		if(s <= 0) {
			b[0] = x;
			s++;
			return s;
		}
		int low = 0;
		int hight = s - 1;
		int mid;
		while(low <= hight) {
			mid = (low + hight) / 2;
			if(x < b[mid]) {
				hight = mid - 1;
			}else if(x >= b[mid]) {
				low = mid + 1;
			}
		}
		
		if(low >= s) {
			b[s] = x;
			s++;
		}else {
			if(b[low] < x) {
				b[low+1] = x;
			}else {
				b[low] = x;
			}
		}
		return s;
	}

	public static int max(int m, int n) {
		
		return m > n ? m : n;
	}
	public static void print(int[] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			System.out.print(tmp[i]+"	");
		}
		System.out.println();
	}
}
