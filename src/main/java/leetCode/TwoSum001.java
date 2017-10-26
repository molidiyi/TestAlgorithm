package leetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author qishuwen
 * @version 创建时间：2017年9月18日 下午2:59:26
 * 
 *          <pre>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * 题目大意
 * 给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字。
 * 要求：这个函数twoSum必须要返回能够相加等于目标数字的两个数的索引，且index1必须要小于index2。
 * 请注意一点，你返回的结果（包括index1和index2）都不是基于0开始的。你可以假设每一个输入肯定只有一个结果。
 *
 */
public class TwoSum001 {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int[] method1 = method1(nums, 18);
		int[] method2 = method2(nums, 18);
		int[] method3 = method3(nums, 18);
		for (int i : method3) {
			System.out.println(i);
		}
	}

	public static int[] method1(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] method2(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i,map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] method3(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {i,map.get(complement)};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
