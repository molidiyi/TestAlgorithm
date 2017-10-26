package bat.fourthClass;

/**
 * 第一个缺失的整数
 * @author jennyzou
 *
 */
public class FirstMissNumber {
	public static void main(String[] args) {
		int a[] = {3,5,1,2,-3,7,4,8};
		int m = firstMissNumber(a);
		System.out.println(m);
	}
	public static int firstMissNumber(int []a) {
		int size = a.length;
		int i = 0;
		
		while(i<size) {
			if(a[i] == i+1) {
				i++;
			}else if(a[i] < i+1 || a[i] > a.length || a[i] == a[a[i]-1]) {
				a[i] = a[size-1];
				size--;
			}else {
				swap(a,i,a[i]-1);
			}
		}
		for (int aa : a) {
			System.out.println(aa+"--"+i+"---"+size);
		}
		return i+1;
	}
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
