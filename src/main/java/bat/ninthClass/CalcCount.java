package bat.ninthClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
* @author qishuwen
* @version 创建时间：2017年10月15日 下午1:17:34
* 
*/
public class CalcCount {
	public static void main(String[] args) {
		int N = 2015;
		//方法一
		int[] pCount = new int[N+1];
		int[] pPre = new int[N+1];
		
		for (int i = 0; i < pCount.length; i++) {
			pCount[i] = 0;
		}
		for (int i = 0; i < pPre.length; i++) {
			pPre[i] = 0;
		}
		int calcCountMethod = calcCountMethod(N, pCount, pPre);
		System.out.println(calcCountMethod);
		int n = N;
		while(n != 1) {
			n = pPre[n];
			System.out.print(n+"\t");
		
		}
		System.out.println();
		//方法二
		int calcCountMethod2 = calcCountMethod2(N);
		System.out.println(calcCountMethod2);
	}
	public static int calcCountMethod(int n, int[] pCount, int[] pPre) {
		if(n == 1) {
			return 0;
		}
		if(n % 2 == 1) { //奇数
			if(pCount[n-1] == 0) {
				pCount[n-1] = calcCountMethod(n-1, pCount, pPre);
			}
			pPre[n] = n-1;
			pCount[n] = pCount[n-1] + 1;
		}else { //偶数
			int n2 = n / 2;
			if(pCount[n2] == 0) {
				pCount[n2] = calcCountMethod(n2, pCount, pPre);
			}
			if(pCount[n-1] == 0) {
				pCount[n-1] = calcCountMethod(n-1, pCount, pPre);
			}
			if(pCount[n2] < pCount[n-1]) {
				pPre[n] = n2;
				pCount[n] = pCount[n2] +1;
			}else {
				pPre[n] = n - 1;
				pCount[n] = pCount[n-1] + 1;
			}	
		}
		
		return pCount[n];
	}
	
	public static int calcCountMethod2(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if(n == 1) {
			return 0;
		}
		while(n > 1) {
			if(n % 2 == 1) {
				n--;
			}else {
				n /= 2;
			}
			list.add(n);
		}
		Collections.reverse(list);
		for (Integer integer : list) {
			System.out.print(integer+"\t");
		}
		System.out.println();
		return list.size();
	}
	
}
