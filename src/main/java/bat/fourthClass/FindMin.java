package bat.fourthClass;

/**
 * 寻找循环数组的最小值
 * @author jennyzou
 *
 */
public class FindMin {
	public static void main(String[] args) {
		int a[] = {4,5,6,7,0,1,2};
		int min = findMin(a);
		System.out.println(min);
	}
	public static int findMin(int a[]) {
		int left = 0;
		int right = a.length-1;
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;
			
			if(a[mid] < a[right]) {
				right = mid;
			}else if(a[mid] > a[right]) {
				left = mid +1;
			}
		}
		return a[left];
		
	}
}
