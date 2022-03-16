import javax.swing.event.SwingPropertyChangeSupport;

class Pair<E>{
	E value1;
	E value2;

	protected Pair(E value1, E value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
}

class Node<E> {
	E data;
	Node<E> left, right;
	Integer depth;

	public Node(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.depth = null;
	}

	public Node(E data, Node<E> left, Node<E> right, int depth) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.depth = depth;
	}

	public String toString(){
		return this.data.toString();
	}
}


public class IsoTriangle {
	
	Integer total_iso_triangle = 0;
	

	/**
		* 4-step process:
		preorder traversal
		* (1) What info to pass to children?
			left and right depth
		* (2) What info to return to parent?
			none
		* (3) How to handle terminal cases?
			if child node of "selected root node" does not have children
				return 0 and go one up
			if root is null, return pair 0 0
		* (4) How to update the solution?
			++
			+0
		* count(n as root) = min(left depth, right depth)
		* @param root node
		* @return the left and right depth of the root Node as a pair
	10 */
	//method to count the total number of Type-2 and Type-3 triangles in a binary tree
	public Pair<Integer> count_type2_iso_triangle(Node root) {
		//can prolly do this without using extra parameters but w/e
		return count_helper(root, 0, 0);
	}

	public Pair<Integer> count_helper(Node root, int ldepth, int rdepth){
		if (root == null) {
			return new Pair(0, 0);
		}

		//count nodes to left till null
		//then, count from each node to right till null
		//for each of that, add up each right paired with left
		System.out.println(root);
		if(root.left != null){
			count_helper(root.left, ldepth+1, rdepth);
		}
		if(root.right != null){
			count_helper(root.right, ldepth, rdepth+1);
		}
		
		//System.out.println(cl + " " + cr + " " + ldepth + " " + rdepth);

		total_iso_triangle += ldepth != 0 && rdepth != 0 ? 1 : 0;

		//not sure what to return for pairs
		Pair<Integer> ret_pair = new Pair(0, 0);
		return ret_pair;
	}
	
	/*
	 * Test Method
	 * Building a Tree
	 * */
	public Node<Integer> buildTree1_count_iso_triangle2() {
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> two = new Node<Integer>(2, five, six, 2);
		Node<Integer> one = new Node<Integer>(1, three, four, 2);
		Node<Integer> root= new Node<Integer>(0, one, two, 1);
		
		return root;
	}

	public Node<Integer> test1(){
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> seven = new Node<Integer>(7, three, four, 1);
		Node<Integer> two = new Node<Integer>(2, five, six, 1);
		Node<Integer> root = new Node<Integer>(0, seven, two, 1);

		return root;
	}
	
	public Node<Integer> test2(){
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> eleven = new Node<Integer>(11);
		Node<Integer> eight = new Node<Integer>(8);
		Node<Integer> twelve = new Node<Integer>(12);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> ten = new Node<Integer>(10, null, eleven, 6);
		Node<Integer> nine = new Node<Integer>(9, null, ten, 5);
		Node<Integer> seven = new Node<Integer>(7, eight, nine, 4);
		Node<Integer> three = new Node<Integer>(3, seven, twelve, 3);
		Node<Integer> two = new Node<Integer>(2, five, six, 2);
		Node<Integer> one = new Node<Integer>(1, three, four, 2);
		Node<Integer> root = new Node<Integer>(0, one, two, 1);

		return root;
	}

	public Node<Integer> test3(){
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5, null, three, 1);
		Node<Integer> six = new Node<Integer>(6, four, null, 1);
		Node<Integer> two = new Node<Integer>(2, null, six, 1);
		Node<Integer> one = new Node<Integer>(1, five, null, 1);
		Node<Integer> root = new Node<Integer>(0, one, two, 1);
		
		return root;
	}
	
	public Node<Integer> test4(){
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> five = new Node<Integer>(5, null, three, 1);
		Node<Integer> six = new Node<Integer>(6, four, null, 1);
		Node<Integer> two = new Node<Integer>(2, null, six, 1);
		Node<Integer> one = new Node<Integer>(1, five, three, 1);
		Node<Integer> root = new Node<Integer>(0, one, two, 1);
		
		return root;
	}
	public static void main(String[] args) {
		
		IsoTriangle test = new IsoTriangle();
		Node<Integer> n = test.test1();

		//Example
		Node<Integer> r = test.buildTree1_count_iso_triangle2();
		/* test.count_type2_iso_triangle(r);
			System.out.println("Total number of Type-2 and Type-3 iso triangles are:" + test.total_iso_triangle);
 		*/
		test.count_type2_iso_triangle(n);
		System.out.println("test 1: " + test.total_iso_triangle + ", expected 2");
		

		test.total_iso_triangle = 0;
		n = test.test2();
		test.count_type2_iso_triangle(n);
		System.out.println("test 2: " + test.total_iso_triangle + ", expected 6");
		
		test.total_iso_triangle = 0;
		n = test.test3();
		test.count_type2_iso_triangle(n);
		System.out.println("test 3: " + test.total_iso_triangle + ", expected 2");
		
		test.total_iso_triangle = 0;
		n = test.test4();
		test.count_type2_iso_triangle(n);
		System.out.println("test 4: " + test.total_iso_triangle + ", expected 3");
		
		//gradescope test failed for odd numbered tests
	}
}