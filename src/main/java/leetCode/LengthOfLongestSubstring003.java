package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
* @author qishuwen
* @version 创建时间：2017年9月18日 下午5:39:48
* <pre>
* Given a string, find the length of the longest substring without repeating characters.
* For example, the longest substring without repeating letters for "abcabcbb" is "abc",
* which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*
* 题目大意：
* 给定一个字符串，找字符中的最大非重复子串
*/
public class LengthOfLongestSubstring003 {
	public static void main(String[] args) {
		String str = "asdfdegsdfasdv";
		int method1 = method1(str);
		int method2 = method2(str);
		int method3 = method3(str);
		System.out.println(method1);
		System.out.println(method2);
		System.out.println(method3);
	}
	
	public static int method1(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<Character>();
		int ans = 0, i = 0, j = 0;
		while(i < n && j < n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(set.size(), ans);
			}else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
	
	public static int method2(String s) {
		int n = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j=0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	}
	
	public static int method3(String s) {
		int n = s.length();
		int ans = 0;
		int[] index = new int[128];
		for(int j = 0, i=0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j-i+1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}
}
