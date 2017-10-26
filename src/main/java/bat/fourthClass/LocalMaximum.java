package bat.fourthClass;

/**
 * 高原数
 * @author jennyzou
 *
 */
public class LocalMaximum {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,3,4,5,6,4,2,5,7,8,4,2,5,6,8,7,4,2,1};
		localMaximum(a);
	}
	
	public static void localMaximum(int a[]) {
		int left = 0;
		int right = a.length-1;
		int mid = 0;
		
		while(left < right) {
			mid = (left + right) / 2;
			if(a[mid] > a[mid + 1]) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		System.out.println(a[left-1]+"--"+a[left]+"--"+a[left+1]);
	}
}
