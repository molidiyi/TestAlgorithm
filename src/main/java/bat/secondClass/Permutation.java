package bat.secondClass;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		int a[] = {1,2,3};
		permutation(a, a.length, 0);
	}
	public static void permutation(int a [], int size,int n) {
		if(n == size-1) {
			print(a);
			return;
		}
		for (int i = n; i < size; i++) {
			
			if(isDuplicate(a,n,i)) {
				continue;
			}
			
			swap(a,i,n);
			permutation(a,size,n+1);
			swap(a,i,n);
		}
	}
	private static boolean isDuplicate(int[] a, int n, int i) {
		while(n<i) {
			if(a[i] == a[n]) {
				return true;
			}
			n++;
		}
		return false;
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
