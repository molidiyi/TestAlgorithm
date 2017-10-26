package bat.sixthClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
* @author qishuwen
* @version 创建时间：2017年9月22日 下午5:52:56
* 割点
*/
public class CreatArticulationPoint {
	
	public static void main(String[] args) throws IOException {
		int a[][] = new int[14][14];
		//A
		a[0][1]=1;
		a[0][2]=1;
		a[0][5]=1;
		a[0][11]=1;
		//B
		a[1][0]=1;
		a[1][2]=1;
		a[1][3]=1;
		a[1][6]=1;
		a[1][7]=1;
		a[1][12]=1;
		//C
		a[2][1]=1;
		a[2][0]=1;
		//D
		a[3][1]=1;
		a[3][4]=1;
		//E
		a[4][1]=1;
		a[4][3]=1;
		//F
		a[5][0]=1;
		//G
		a[6][1]=1;
		a[6][7]=1;
		a[6][8]=1;
		a[6][10]=1;
		//H
		a[7][1]=1;
		a[7][6]=1;
		a[7][10]=1;
		//I
		a[8][6]=1;
		//J
		a[9][11]=1;
		a[9][12]=1;
		//K
		a[10][6]=1;
		a[10][7]=1;
		//L
		a[11][0]=1;
		a[11][9]=1;
		a[11][12]=1;
		//M
		a[12][1]=1;
		a[12][9]=1;
		a[12][11]=1;
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("articulationPoint.txt"),"UTF-8");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				osw.write(Integer.toString(a[i][j])+"\t");
			}
			osw.write("\n");
		}
		osw.close();
		
		
	}
}
