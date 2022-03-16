
import java.util.Stack;

public class IsoTriangle {
	
	protected class Pair<E>{
		E value1;
		E value2;
		
		protected Pair(E value1, E value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
	}

	protected class Node {
		
		int value;
		
		Node l_child;
		Node r_child;
		
		Integer depth;
		
		private Node(int value, Node l_child, Node r_child) {
			this.value = value;
			this.l_child = l_child;
			this.r_child = r_child;
		}
		
		private Node(int value, Node l_child, Node r_child, int depth) {
			this.value = value;
			this.l_child = l_child;
			this.r_child = r_child;
			this.depth = depth;
		}
		
		private void set_depth(int depth) {
			this.depth = depth;
		}
		
		private int get_depth() {
			return this.depth;
		}
		
		private void set_value(int new_value) {
			this.value = new_value;
		}
	}
	
	public Node build_tree_int() {
		Node zero = new Node(4, null, null, 2);
		Node two = new Node(6, null, null, 3);
		
		Node four = new Node(2, null, null, 4);
		Node six = new Node(5, null, null, 4);
		
		Node five = new Node(0, four, six, 3);
		Node three = new Node(1, two, five, 2);
		
		Node one = new Node(3, zero, three, 1);
		
		return one;
	}
	
	public Node build_tree_int2() {
		
		Node eleven = new Node(11, null, null, 4);	
		Node ten = new Node(10, null, null, 4);	
//		
		Node eight = new Node(8, null, null, 4);
//		
		Node nine = new Node(9, null, null, 4);
//		
//		Node seven = new Node(7, eight, nine, 4);
		
		
		
		Node three = new Node(3, null, null, 3);
		Node four = new Node(4, null, null, 3);
		
		
		Node five = new Node(5, ten, eleven, 3);
		Node six = new Node(6, eight, nine, 3);
		
		Node one = new Node(1, three, four, 2);
		Node two = new Node(2, five, six, 2);
		
		Node zero = new Node(0, one, two, 1);
		
		return zero;
	}
	
	Integer total_iso_triangle = 0;
	
	public Pair<Integer> count_iso_triangle(Node root) {
		
		// handling terminal cases
		if (root == null) {
			return new Pair(0, 0);
		}
		
		Integer l_depth, r_depth;
		l_depth = r_depth = -1;
		
		if (root.l_child != null) {
			//return left_path_len to parent
			// pass nothing to children
			Pair<Integer> this_pair = count_iso_triangle(root.l_child);
			
			l_depth = this_pair.value1 + 1;
		}
		// handling terminal cases
		else
			l_depth = 0; 
		
		if (root.r_child != null) {
			// return right_path_len to parent
			// pass nothing to children
			Pair<Integer> this_pair = count_iso_triangle(root.r_child);
			
			r_depth = this_pair.value2 + 1;
		}
		// handling terminal cases
		else
			r_depth = 0;
		
		/** !BASICALLY!! The code goes through each node and checks
		 * 	the left depth, then goes to check the right depth. Then
		 * 	update the number of type 1 triangles based on the minimum
		 * 	number since that's the number of pairs of left and right
		 * 	nodes that branch from the node it's looking at
		 * 	so if the current node has a left branch only, then the 
		 * 	left cond will set l_depth to 1 while the right cond will
		 * 	set r_depth to 0. Since a node with just one branch is
		 * 	not a type 1, the min of that is 0 type 1s. If both
		 * 	branches were present, then the min would be 1 vs 1 = 1/
		*/
		// update optimal solution
		total_iso_triangle += Math.min(l_depth, r_depth);
		
		Pair<Integer> ret_pair = new Pair(l_depth, r_depth);
		return ret_pair;
		
	}
	
	public void test_count_iso_triangle() {
		IsoTriangle test = new IsoTriangle();
		Node root = test.build_tree_int2();
		
		Pair<Integer> node = test.count_iso_triangle(root);
		
		System.out.println(test.total_iso_triangle);	
	}
	
	
	public static void main(String[] args) {
		
		IsoTriangle test = new IsoTriangle();
		test.test_count_iso_triangle();
		//System.out.println(test.total_iso_triangle);
	}
}


