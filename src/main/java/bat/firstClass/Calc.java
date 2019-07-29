package bat.firstClass;

import java.util.Stack;

/**
* @author qishuwen
* @version 创建时间：2017年10月26日 下午2:36:57
* 1.链表递归栈 p46
*/
public class Calc {
	
	static int N = 16;
	
	public static void main(String[] args) {
		int[][] G = new int[N][N];
		
		G[0][1] = G[0][4] = 1;
		G[1][5] = G[1][0] = G[1][2] = 1;
		G[2][1] = G[2][6] = G[2][3] = 1;
		G[3][2] = G[3][7] = 1;
		G[4][0] = G[4][5] = 1;
		G[5][1] = G[5][4] = G[5][6] = G[5][9] = 1;
		G[6][2] = G[6][5] = G[6][7] = G[6][10] = 1;
		G[7][3] = G[7][6] = 1;
		G[8][9] = G[8][12] = 1;
		G[9][8] = G[9][13] = G[9][10] = 1;
		G[10][9] = G[10][14] = G[10][11] = 1;
		G[11][10] = G[11][15] = 1;
		G[12][8] = G[12][13] = 1;
		G[13][9] = G[13][12] = G[13][14] = 1;
		G[14][10] = G[14][13] = G[14][15] = 1;
		G[15][11] = G[15][14] = 1;
		
		int cacl = caclMethod(G);
		System.out.println(cacl);
	}

	private static int caclMethod(int[][] G) {
		
		int[] step = new int[N];	//每个节点第几步可以到达
		int[] stepNumber = new int[N];	//每个节点有几种走法
		
		stepNumber[0] = 1;
		Stack<Integer> q = new Stack<Integer>();	//当前搜索的几点
		q.push(0);
		int from,i,s;
		while(!q.empty()) {
			from = q.firstElement();
			q.remove(0);
			s = step[from] + 1; //记录步数
			for(i = 1; i < N; i++) {
				if(G[from][i] == 1) {
					//i尚未可达或发现更快的路（全职不同才可能）
					if(step[i] == 0 || step[i] > s) {
						step[i] = s;
						stepNumber[i] = stepNumber[from];
						q.push(i);
					}else if(step[i] == s){ //发现相同路径
						stepNumber[i] += stepNumber[from];
					}
					print(from+"-"+i+"step      ",step);
					print(from+"-"+i+"stepnumber",stepNumber);
				}
			}
		}
		return stepNumber[N-1];
	}
	
	static void print(String name,int [] a) {
		System.out.print(name+"\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}
