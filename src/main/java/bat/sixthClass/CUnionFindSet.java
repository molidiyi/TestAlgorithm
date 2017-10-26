package bat.sixthClass;
/**
* @author qishuwen
* @version 创建时间：2017年9月22日 下午2:33:24
* 并查集 
*/
public class CUnionFindSet {
	private static int mnN;
	private static int[] mpParent = new int[] {1,2,3};
	
	public static void main(String[] args) {
		int n = 10;	//岛屿的数量
		cUnionFindSet(n);
		union(2,6);
		union(5,6);
		union(1,8);
		union(2,9);
		union(4,8);
		union(4,0);
		
		int[] component = new int[n];
		for (int i = 0; i < component.length; i++) {
			component[i] = 0;
		}
		
		int i;
		for (i = 0; i < n; i++) {
			component[find(i)]++;
		}
		
		
		int ncomponent = 0;
		for (i = 0; i < n; i++) {
			if(component[i] != 0) {
				ncomponent++;
			}
		}
		
		System.out.println("一共"+ncomponent+"部分");
		
	}	
	public static void cUnionFindSet(int n) {
		mnN = n;
		mpParent = new int[n]; 
		for (int i = 0; i < mnN; i++) {
			mpParent[i] = i;
		}
	}
	
	public static int find(int i) {
		if((i < 0) || (i > mnN)) {
			return -1;
		}
		
		int root = i;
		while(root != mpParent[root]) {
			root = mpParent[root];
		}
		
		int t = i;
		int p;
		while(t != root) {
			p = mpParent[t];	//t2原父节点
			mpParent[t] = root;		//t2父节点直接赋值给根t
			t = p;	//沿着原来的父节点继续向上找
		}
		return root;
	}
	
	public static void union(int i, int j) {
		if(i < 0 || i >= mnN || j < 0 || j > mnN) {
			return;
		}
		int ri = find(i);
		int rj = find(j);
		if(ri != rj) {
			mpParent[ri] = rj;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
