package bat.secondClass;

public class Manacher {
	public static void main(String[] args) {
		String a[] = {"1","2","2","1","2","3","2","1"};
		//#  1  #  2  #  2  #  1  #  2  #  3  #  2  #  1  # 
		String[] s = add(a);
		int p[] = new int [s.length];
		Manacher(s, p);
	}
	public static void Manacher(String []s,int []p) {
		int size = s.length;
		p[0] = 1;
		int id = 0;
		int mx = 1;
		for (int i = 1; i < size; i++) {
			if(mx > i) {
				p[i] = min(p[2*id-i],mx-1);
			}else {
				p[i] = 1;
			}
			while(s[i + p[i]].equals(s[i - p[i]])) {
				p[i]++;
			}
			if(mx < i+p[i]) {
				mx = i + p[i];
				id = i;
			}
				
		}
		print(p);
	}
	
	public static int min(int a,int b){
		return a<b?a:b;
	}
	public static String[] add(String a[]){
		String b[] = new String[2*a.length+2]; 
		int j = 0;
		b[j++] = "$";
		b[j++] = "#";
		for (int i = 0; i < a.length; i++) {
			b[j++] = a[i];
			b[j++] = "#";
		}
		return b;
	}	
	public static void print(String[] a) {
		for (String i : a) {
			System.out.print(i+"  ");
		}
		System.out.println();
	}
	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i+"  ");
		}
		System.out.println();
	}
}
