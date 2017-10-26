package bat.fourthClass;

public class MaxSubarray {
	
	public static void main(String[] args) {
		int a[] = {1,-2,3,10,-4,7,2,-5};
		int maxSubarray = maxSubarray(a);
		System.out.println(maxSubarray);
	}
	
	public static int maxSubarray(int a[]) {
		
		int sum = a[0];
		int result = sum;
		int s = 0;
		int e = 0;
		for (int i = 1; i < a.length; i++) {
			if(sum > 0) {
				sum += a[i];
				e++;
			}else {
				sum = a[i];
				s = i;
				e = i;
			}
			result = result>sum?result:sum;
		}
		e--;
		System.out.println(s+"---"+e);
		return result;
	}
}
