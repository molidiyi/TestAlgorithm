package bat.fourthClass;

/**
 * 折半查找
 * @author jennyzou
 * page 11
 */
public class Find {
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,6,7,8,9,10};
		
		int find = find(a, 6);
		System.out.println(find);
	}
	
	
	public static int find(int a[],int find) {
		int from = 0;
		int to = a.length-1;
		int middle = 0;
		boolean flag = false;
		
		while(from < to) {
			middle = (from + to) / 2;
			if(a[middle] == find) {
				flag = true;
				break;
			}
			if(a[middle] < find) {
				from = middle+1;
			}else {
				to = middle-1;
			}
		}
		if(flag) {
			return middle;
		}
		return -1;
	}
}
