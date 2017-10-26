package bat.ninthClass;

import sun.launcher.resources.launcher;

/**
* @author qishuwen
* @version 创建时间：2017年10月12日 上午10:27:55
* 
*/
public class MaxShareProfit {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		maxProfit3(prices,3);
	}
	
	
/////////////////////方法一///////////////////////////////////////
	public static void maxProfit(int[] prices) {
		int buy = prices[0];
		int sell = 0;
		for (int i = 1; i < prices.length; i++) {
			buy = min(buy,prices[i-1]);
			sell = max(sell,prices[i]-buy);
		}
		System.out.println(sell);
	}

/////////////////////方法二///////////////////////////////////////
	public static int maxProfit2(int[] prices, int K) {
		int[][] dp = new int[prices.length][prices.length];
		int k,j,i;
		for(k = 1; k <= K; k++) {
			for (i = 1; i < prices.length; i++) {
				dp[k][i] = dp[k][i-1];
				for (j = 0; j < i; j++) {
					dp[k][i] = max(dp[k][i],dp[k-1][j] + prices[i] - prices[j]);
				}
			}
		}
		System.out.println(dp[K][prices.length-1]);
		return dp[K][prices.length-1];
	}
	
/////////////////////方法三///////////////////////////////////////
	public static int maxProfit3(int[] prices, int K) {
		int[][] dp = new int[prices.length][prices.length];
		int k,i;
		int mx;
		for(k = 1; k <= K; k++) {
			mx = dp[k-1][0] - prices[0];	
			for (i = 1; i < prices.length; i++) {
				dp[k][i] = max(dp[k][i-1],mx+prices[i]);
				mx = max(mx,dp[k-1][i]-prices[i]);
			}
		}
		System.out.println(dp[K][prices.length-1]);
		return dp[K][prices.length-1];
	}
	
////////////////////////////////////////////////////////////
	private static int max(int sell, int i) {
		return sell > i ? sell : i;
	}
	
	private static int min(int buy, int i) {
		return buy < i ? buy : i;
	}
}
