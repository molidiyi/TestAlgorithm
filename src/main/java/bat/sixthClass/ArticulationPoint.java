package bat.sixthClass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;

/**
* @author qishuwen
* @version 创建时间：2017年9月22日 下午5:52:56
* 割点
*/
public class ArticulationPoint {
	
	public static void main(String[] args) throws IOException {
		int[][] a = new int[14][14];
		int i = 0;
		BufferedReader br = new BufferedReader(new FileReader("articulationPoint.txt"));
		String s = null;
		while((s = br.readLine()) != null) {
			String[] split = s.split("\t");
			for (int j = 0; j < split.length; j++) {
				a[i][j] = Integer.parseInt(split[j]);
			}
			i++;
		}
		br.close();
		//遍历数组a
//		for (int j = 0; j < a.length; j++) {
//			for (int j2 = 0; j2 < a[j].length; j2++) {
//				System.out.print(a[j][j2]+"\t");
//			}
//			System.out.println();
//		}
		
		boolean[] an = new boolean[14];
	}
	
	public static void Articulation(List<List<Integer>> graph,boolean an) {
		int N = graph.size();
		int[] dfn = new int[N];
	}
}
