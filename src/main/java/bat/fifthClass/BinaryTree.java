package bat.fifthClass;

import sun.font.DelegatingShape;

/**
* @author qishuwen
* @version 创建时间：2017年9月13日 下午4:37:14
* 树的基本操作
*/
public class BinaryTree {
	
	private Node root = null;
	
	public BinaryTree() {
		super();
	}

	BinaryTree(int value) {  
        root = new Node(value);  
        root.leftChild  = null;  
        root.rightChild = null;  
    } 
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(52);
		
		bt.insert(580);
		bt.insert(12);
		bt.insert(50);
		bt.insert(58);
		bt.insert(9);
		bt.insert(888);
		bt.insert(248);
		bt.insert(32);
		bt.insert(666);
		bt.insert(455);
		bt.insert(777);
		bt.insert(999);
		
		bt.preOrderTraverse();;
		bt.inOrderTraverse();
		bt.postOrderTraverse();
//		System.out.println(bt.findKey(52));
//		System.out.println(bt.findKey(580));
//		System.out.println("最小值:" + bt.getMinValue());
//		System.out.println("最大值:" + bt.getMaxValue());
//		bt.delete(32); // 删除叶子节点
//		bt.delete(50); // 删除只有一个左子节点的节点
//		bt.delete(248); // 删除只有一个右子节点的节点
//		bt.delete(248); // 删除只有一个右子节点的节点
//		bt.delete(580); // 删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代
//		bt.delete(888); // 删除有两个子节点的节点，且后继节点为删除节点的右子节点
//		bt.delete(52); // 删除有两个子节点的节点，且删除节点为根节点
		bt.reverse(); //二叉树的翻转
		
		bt.inOrderTraverse();
	}
	


	// 查找数据
	public Node findKey(int value) {
		Node current = root;
		while(true) {
			if(value == current.value) {
				return current;
			}else if(value < current.value) {
				current = current.leftChild;
			}else if(value > current.value) {
				current = current.rightChild;
			}
			
			if(current == null) {
				return null;
			}
		}
	}
	
	//插入数据
	public String insert(int value) {
		String error = null;
		
		Node node = new Node(value);
		if(root == null) {
			root = node;
			root.leftChild = null;
			root.rightChild = null;
		}else {
			Node current = root;
			Node parent = null;
			while(true) {
				if(value < current.value) {
					parent = current;
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = node;
						break;
					}
				}else if(value > current.value) {
					parent = current;
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = node;
						break;
					}
				}else {
					error = "having same value in binary tree";
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 前序遍历（递归）
	 * 1、访问这个节点
	 * 2、调用自身来遍历节点的左子树
	 * 3、调用自身来遍历节点的右子树
	 */
	public void preOrderTraverse() {
		System.out.println("前序遍历：");
		preOrderTraverse(root);
		System.out.println();
	}
	public void preOrderTraverse(Node node) {
		if(node == null) {
			return;
		}
		node.display();
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}
	
	/**
	 * 中序遍历
	 * 1、调用自身来遍历节点的左子树
	 * 2、访问这个节点
	 * 3、调用自身来遍历节点的右子树
	 */
	public void inOrderTraverse() {
		System.out.println("中序遍历：");
		inOrderTraverse(root);
		System.out.println();
	}

	public void inOrderTraverse(Node node) {
		if(node == null) {
			return;
		}
		inOrderTraverse(node.leftChild);
		node.display();
		inOrderTraverse(node.rightChild);
	}
	
	/**
	 * 后序遍历
	 * 1、调用自身来遍历节点的左子树
	 * 2、调用自身来遍历节点的右子树
	 * 3、访问这个节点
	 */
	public void postOrderTraverse() {
		System.out.println("后序遍历：");
		postOrderTraverse(root);
		System.out.println();
	}
	
	public void postOrderTraverse(Node node) {
		if(node == null) {
			return;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		node.display();
	}
	

	//最小值
	public int getMinValue() {
		Node current = root;
		while(true) {
			if(current.leftChild == null) {
				return current.value;
			}
			current = current.leftChild;
		}
	}
	
	//最大值
	public int getMaxValue() {
		Node current = root;
		while(true) {
			if(current.rightChild == null) {
				return current.value;
			}
			current = current.rightChild;
		}
	}
	
	//得到后继节点，即删除节点的左后代
	public Node getSucessor(Node deNode) {
		Node successorParent = null;
		Node successor = deNode;
		Node current = deNode.rightChild;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		//如果后继节点不是删除节点的右子节点时
		if(successor != deNode.rightChild) {
			//要将后继节点的右子节点指向后继节点的作子节点
			successorParent.leftChild = successor.rightChild;
			//并将删除节点的右子节点指向后继节点的右子节点
			successor.rightChild = deNode.rightChild;
		}
		//任何情况下都需要将删除节点的左子节点指向后继节点的左子节点
		successor.leftChild = deNode.leftChild;
		
		return successor;
	}
	
	
	
	//删除操作
	public boolean delete(int value) {
		Node current = root; //需要删除的节点
		Node parent = null; //需要删除节点的父节点
		boolean isLeftChild = true; //需要删除节点是否是父节点的左子树
		
		while(true) {
			if(value == current.value) {
				break;
			}else if(value < current.value) {
				isLeftChild = true;
				parent = current;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				parent = current;
				current = current.rightChild;
			}
			
			if(current == null) {
				return false;
			}
		}
		
		//分情况考虑
		//1、需要删除的节点为叶子节点
		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) {
				root = null;
			}else {
				//如果该叶节点是父节点的左子节点，将父亲的左子节点置为null
				if(isLeftChild) {
					parent.leftChild = null;
				}else {	//如果该叶子节点是父节点的右子节点，将父亲的右子节点置为null
					parent.rightChild = null;
				}
			}
			
		}
		//2、需要删除的节点有一个子节点，且该子节点为左子节点
		else if(current.rightChild == null){	
			//如果该节点为根节点，将根节点的左子节点变为根节点
			if(current == root) {
				root = current.leftChild;
			}else {
				//如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
				if(isLeftChild) {
					parent.leftChild = current.leftChild;
				}else {//如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
					parent.leftChild = current.rightChild;
				}
			}
		}
		//3、需要删除的节点有两个子节点，需要寻找该节点的后续节点代替删除节点
		else {
			Node sucessor = getSucessor(current);
			//如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点
			if(current == root) {
				root = sucessor;
			}else {
				//如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点
				if(isLeftChild) {
					parent.leftChild = sucessor;
				}else { //如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点
					parent.rightChild = sucessor;
				}
			}
			
		}
		current = null;
		return true;
	}
	
	//二叉树的翻转
	public void reverse() {
		System.out.println("二叉树的反转:");
		reverse(root);
	}
	public void reverse(Node node) {
//		System.out.println(node);
		if(node != null) {
			swap(node,node.leftChild,node.rightChild);
			reverse(node.leftChild);
			reverse(node.rightChild);
		}
	}

	private void swap(Node node,Node leftChild, Node rightChild) {
		node.leftChild = rightChild;
		node.rightChild = leftChild;
	}
}
