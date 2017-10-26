package bat.fourthClass;
/**
* @author qishuwen
* @version 创建时间：2017年9月12日 上午8:41:10
* 荷兰国旗问题
*/
public class Holland {
	
	public static void main(String[] args) {
		int[] a = {1,2,0,2,2,1,0,0,1};
//		holland1(a);
//		holland2(a);
//		holland3(a);
//		holland4(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void holland1(int[] a) {
		int begin = 0;
		int current = 0;
		int end = a.length-1;
		while(current <= end) {
			if(a[current] == 2) {
				swap(a,current,end);
				end--;
			}else if(a[current] == 1) {
				current++;
			}else {
				if(begin == current) {
					begin++;
					current++;
				}else {
					swap(a, current, begin);
					begin++;
				}
			}
		}
	}
	
	public static void holland2(int[] a) {
		int begin = 0;
		int current = 0;
		int end = a.length-1;
		
		while(current <= end) {
			if(a[current] == 2) {
				swap(a, current, end);
				end--;
			}else if(a[current] == 1) {
				current++;
			}else {
				if(begin == current) {
					begin++;
					current++;
				}else {
					swap(a, begin, current);
					begin++;
					current++;
				}
			}
		}
	}
	
	public static void holland3(int[] a) {
		int begin = 0;
		int current = 0;
		int end = a.length-1;
		
		while(current <= end) {
			if(a[current] == 2) {
				swap(a, current, end);
				end--;
			}else if(a[current] == 1) {
				current++;
			}else {
				if(begin != current) {
					swap(a, current, begin);
				}
				begin++;
				current++;
			}
		}
	}
	public static void holland4(int[] a) {
		int begin = 0;
		int current = a.length-1;
		int end = a.length-1;
		while(begin <= current) {
			if(a[current] == 2) {
				swap(a, current, end);
				current--;
				end--;
			}else if(a[current] == 1) {
				current--;
			}else {
				swap(a, begin, current);
				begin++;
			}
				
			
		}
		
	}

	public static void swap(int[] a, int current, int end) {
		int temp = a[current];
		a[current] = a[end];
		a[end] = temp;
	}
}
