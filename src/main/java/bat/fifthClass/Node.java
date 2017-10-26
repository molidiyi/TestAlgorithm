package bat.fifthClass;
/**
* @author qishuwen
* @version 创建时间：2017年9月13日 下午4:47:43
* 
*/
public class Node {
	int value;
	Node leftChild;
	Node rightChild;
	
	Node(int value){
		this.value = value;
	}
	
	public void display() {
		System.out.print(this.value+"\t");
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	
}
