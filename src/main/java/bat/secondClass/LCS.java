package bat.secondClass;

public class LCS {
	public static void main(String[] args) {
		String [] a = {"A","B","C","B","D","A","B"};
		String [] b = {"B","D","C","A","B","A"};
		
		int[][] c = new int [8][7];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(a[i].equals(b[j])) {
					c[i+1][j+1] = c[i][j]+1;
				}else {
					if(c[i][j+1] > c[i+1][j]) {
						c[i+1][j+1] = c[i][j+1];
					}else {
						c[i+1][j+1] = c[i+1][j];
					}
				}
			}
		}
		
		int i = a.length;
		int j = b.length;
		
		while(i != 0 && j != 0) {
			if(a[i-1] == b[j-1]) {
				System.out.println(a[i-1]);
				i--;
				j--;
			}else {
//				if(c[i][j-1] > c[i-1][j]) { //ABCB
				if(c[i][j-1] >= c[i-1][j]) { //BADB
					j--;
				}else {
					i--;
				}
			}
		}
		
		
	}
}
