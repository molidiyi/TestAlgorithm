package bat.fourthClass;

/**
 * 零子数组
 * @author jennyzou
 *
 */
public class MinSubarray {
	
	public static void main(String[] args) {
		int a [] = {1,-2,3,10,-4,7,2,-5,-4};
		int minSubarray = minSubarray(a);
		System.out.println(minSubarray);
	}
	
	//寻找最小值
	public static int minSubarray(int []a) {
		int sum [] = new int [a.length+1];
		sum[0] = 0;
		int i = 0;
		for (i = 0; i < a.length; i++) {
			sum[i+1] = sum[i] + a[i];
		}
		
		sort(sum,0,sum.length-1);
		int difference = sum[1] - sum[0];
		for (int j = 2; j < sum.length; j++) {
			if(sum[j] - sum[j-1] < difference){
				difference = sum[j] - sum[j-1];
			}
		}
		return difference;
	}
	
	//快速排序
	public static int[] sort(int [] sort,int left,int right) {
		if(left > right) {
			return null;
		}
		int l = left;
		int r = right;
		int mid = sort[l];
		boolean flag = true;
		
		while(l < r) {
			if(flag) {
				if(mid <= sort[r]) {
					r--;
				}else {
					int temp = sort[l];
					sort[l] = sort[r];
					sort[r] = temp;
					
					flag = false;
				}
			}else {
				if(mid >= sort[l]) {
					l++;
				}else {
					int temp = sort[l];
					sort[l] = sort[r];
					sort[r] = temp;
					
					flag = true;
				}
				
			}
		}
		sort(sort,left,r-1);
		sort(sort,l+1,right);
		return sort;
	}
}
