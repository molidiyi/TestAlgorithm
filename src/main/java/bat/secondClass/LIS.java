package bat.secondClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author qishuwen
* @version 创建时间：2017年10月27日 上午11:49:17
* 2.字符串
*/
public class LIS {
	public static void main(String[] args) {
		int[] array = {1,4,6,2,8,9,7};

		int maxNum = lisMethod(array);
		System.out.println("LIS最大长度是："+maxNum);
		
	}
	
	private static int lisMethod(int[] array) {
		int[] lis = new int[array.length];	//记录lis长度
		int[] pre = new int[array.length];	//记录lis前驱
		lis[0] = 1;
		
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if(array[j] <= array[i]) {
					if(lis[i] <= lis[j]) {
						pre[i] = j;
						lis[i] = lis[j] + 1;
					}
				}
			}
		}
		int maxNum = 0;	//最大长度
		int nIndex = 0;	//记录最大长度下标
		for (int i = 0; i < lis.length; i++) {
			if(lis[i] > maxNum) {
				maxNum = lis[i];
				nIndex = i;
			}
		}
		List<Integer> lisArray = new ArrayList<Integer>();	//记录lis
		getLis(array,pre,nIndex,lisArray);
		
		return maxNum;
	}

	private static void getLis(int[] array, int[] pre, int nIndex,List<Integer> lisArray) {
		int lis ;
		lisArray.add(array[nIndex]);
		while(nIndex > 0) {
			nIndex = pre[nIndex];
			lisArray.add(array[nIndex]);
		}
		Collections.reverse(lisArray);
		System.out.print("LIS是：");
		print(lisArray);
		
	}

	private static void print(List<Integer> lisArray) {
		for (Integer integer : lisArray) {
			System.out.print(integer+"   ");
		}
		System.out.println();
	}

}
