import java.lang.management.ClassLoadingMXBean;
import java.time.format.TextStyle;

class Node<E> {
		
	Integer value;
	Node<E> left;
	Node<E> right;
	
	public Node(Integer value, Node<E> left, Node<E> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return "value=" + value.toString();
	}
}

public class BTree<E> {
	
	Node<E> root;
	
	
	/**
	* @return a new binary tree resulting from adding the tree recipient 
	/* of the message (i.e. the one referred to by this) and t2.
	*/
	public BTree<E> sumTree(BTree<E> t2){
		BTree<E> n = new BTree<E>();
		n.root = traverse(this.root, t2.root);
		return n;	
	}
	
	//traverse tree
	public Node<E> traverse(Node<E> curr1, Node<E> curr2){
		//go through each node (both curr2 and curr1)
		//if curr2 node exists, add. otherwise set currn node to the one that exists
		int val = (curr1 != null ? curr1.value : 0) + (curr2 != null ? curr2.value : 0);
		Node<E> currn = new Node<E>(val, null, null);
		if(curr1 != null && curr1.left != null || curr2 != null && curr2.left != null){
			currn.left = traverse(curr1 == null ? null : curr1.left, curr2 == null ? null : curr2.left);
		}
		if(curr1 != null && curr1.right != null || curr2 != null && curr2.right != null){
			currn.right = traverse(curr1 == null ? null : curr1.right, curr2 == null ? null : curr2.right);
		}

		return currn;
	}
	

	public String toString() {
		// string representation of the btree
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(this.root, 1, sb);
		return sb.toString();
	}

	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		// helper to toString, traverses btree and adds to stringbuilder
		for (int i = 1; i < depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	public static void test1(){
		BTree<Integer> t1 = new BTree<Integer>();
		Node<Integer> five = new Node<Integer>(5, null, null);
		Node<Integer> three = new Node<Integer>(3, five, null);
		Node<Integer> two = new Node<Integer>(2, null, null);
		t1.root = new Node<Integer>(1, three, two);

		BTree<Integer> t2 = new BTree<Integer>();
		Node<Integer> four = new Node<Integer>(4, null, null);
		Node<Integer> seven = new Node<Integer>(7, null, null);
		Node<Integer> one = new Node<Integer>(1, null, four);
		Node<Integer> three2 = new Node<Integer>(3, null, seven);
		t2.root = new Node<Integer>(2, one, three2);

		System.out.println(t1.sumTree(t2));
	}

	public static void main(String[] args){
		test1();
	}

}
