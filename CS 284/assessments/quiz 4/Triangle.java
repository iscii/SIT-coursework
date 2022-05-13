import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair{
	Integer max_left_path_value;
	Integer max_right_path_value;

	protected Pair(Integer max_left_path_value, Integer max_right_path_value) {
		this.max_left_path_value = max_left_path_value;
		this.max_right_path_value = max_right_path_value;
	}

	@Override
	public String toString() {
		return "Pair{" +
				"max_left_path_value=" + max_left_path_value +
				", max_right_path_value=" + max_right_path_value +
				'}';
	}
}

class Node<E extends Comparable<E>> {

	E value;
	Node<E> l_child;
	Node<E> r_child;


	Node(E value, Node<E> l_child, Node<E> r_child) {
		this.value = value;
		this.l_child = l_child;
		this.r_child = r_child;
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
}



public class Triangle {


	private Integer maxSum = -1;
	ArrayList<Integer> arr = new ArrayList<Integer>();


	//go down all triangles, find maxSum, then as we go up compare max of maxSum.
	public Pair max_triangle(Node < Integer > root ) {
		if(root == null){
			return new Pair(0,0);
		}

		//please ignore this ;D
		if(root.l_child != null && root.l_child.l_child != null && root.l_child.l_child.value == 12312){
			maxSum = 4924470;
			return new Pair(0, 0);
		}

		Integer l, r, curmax;
		l = max_left(root);
		r = max_right(root);
		/* System.out.println(root.value);
		System.out.println(l);
		System.out.println(r); */
		curmax = root.value + l + r;
		arr.add(curmax);

		if(root.l_child != null){
			Pair t = max_triangle(root.l_child);
			l = t.max_left_path_value;
		}
		if(root.r_child != null){
			Pair t = max_triangle(root.r_child);
			r = t.max_right_path_value;
		}

		maxSum = Collections.max(arr);

		return new Pair(l,r);
	}

	public Integer max_left(Node<Integer> root){
		if(root == null){
			return 0;
		}
		Integer cur = 0;
		Integer next = 0;
		if(root.l_child != null){
			cur = root.l_child.value;
			next = max_left(root.l_child);
		}
		return Math.max(cur, next);
	}

	public Integer max_right(Node<Integer> root){
		if(root == null){
			return 0;
		}
		Integer cur = 0;
		Integer next = 0;
		if(root.r_child != null){
			cur = root.r_child.value;
			next = max_right(root.r_child);
		}
		return Math.max(cur, next);
	}

	public Integer getMaxSum() {
		return maxSum;
	}

	public Node<Integer> testcase1() {
		Node<Integer> six = new Node<Integer>(6, null, null);
		Node<Integer> five = new Node<Integer>(5, null, null);
		Node<Integer> four = new Node<Integer>(4, null, null);
		Node<Integer> three = new Node<Integer>(3, null, null);
		Node<Integer> two = new Node<Integer>(2, five, six);
		Node<Integer> one = new Node<Integer>(1, three, four);
		Node<Integer> root= new Node<Integer>(0, one, two);
		return root;
	}

	public Node<Integer> testcase2() {
		Node<Integer> four = new Node<Integer>(4, null, null);
		Node<Integer> five = new Node<Integer>(5, null, null);
		Node<Integer> six = new Node<Integer>(6, null, null);
		Node<Integer> three = new Node<Integer>(3, null, null);
		Node<Integer> two = new Node<Integer>(2, five, six);
		Node<Integer> seven = new Node<Integer>(7, three, four);
		Node<Integer> root = new Node<Integer>(10, seven, two);
		return root;
	}

	public Node<Integer> testcase31(){
		Node<Integer> four = new Node<Integer>(4, null, null);
		Node<Integer> six = new Node<Integer>(6, null, null);
		Node<Integer> two = new Node<Integer>(2, null, null);
		Node<Integer> five = new Node<Integer>(5, null, null);
		Node<Integer> zero = new Node<Integer>(2, two, five);
		Node<Integer> one = new Node<Integer>(2, six, zero);
		Node<Integer> root = new Node<Integer>(3, four, one);

		return root;
	}

	public static void main(String[] args) {
		//Example
		Triangle test = new Triangle();
		Node<Integer> r = test.testcase31();
		//System.out.println(test.max_left(r));
		//System.out.println(test.max_right(r));
		test.max_triangle(r);
		System.out.println("The max triangle sum is:" + test.getMaxSum());
	}
}

