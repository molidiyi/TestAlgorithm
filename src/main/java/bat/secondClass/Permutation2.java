package bat.secondClass;

public class Permutation2 {
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		print(a);
		while(GetNextPermutation(a,a.length)) {
			print(a);
		}
		
	}
	
	private static boolean GetNextPermutation(int[] a, int size) {
		//后找
		int i = size-2;
		while((i >= 0) && (a[i] >= a[i+1])) {
			i--;
		}
		if(i<0) {
			return false;
		}
		//小大
		int j = size-1;
		while(a[j] <= a[i]) {
			j--;
		}
		//交换
		swap(a,i,j);
		//翻转
		reverse(a,i+1,size-1);
		return true;
	}

	private static void reverse(int[] a, int from, int to) {
		int temp;
		while(from < to) {
			temp = a[from];
			a[from++] = a[to];
			a[to--] = temp;
		}
		
	}

	private static void swap(int[] a, int i, int n) {
		int temp = a[i];
		a[i] = a[n];
		a[n] = temp;
		
	}
	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i+"  ");
		}
		System.out.println();
	}
}
