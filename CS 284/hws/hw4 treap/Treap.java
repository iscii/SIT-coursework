import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {

	private static class Node<E> {
		E data;
		int priority;
		Node<E> left;
		Node<E> right;

		public Node(E data, int priority) {
			if (data == null)
				throw new IllegalArgumentException();
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}

		public Node(E data) {
			if (data == null)
				throw new IllegalArgumentException();
			this.data = data;
			this.priority = 0;
			this.left = null;
			this.right = null;
		}

		Node<E> rotateRight() {
			if (this.left == null)
				return this;
			Node<E> b = this.left;
			this.left = b.right;
			b.right = this;
			return b;
		}

		Node<E> rotateLeft() {
			if (this.right == null)
				return this;
			Node<E> b = this.right;
			this.right = b.left;
			b.left = this;
			return b;
		}

		public String toString() {
			return "(key=" + data.toString() + ", priority=" + priority + ")";
		}
	}

	private Random priorityGenerator;
	private Node<E> root;

	public Treap() {
		this.root = null;
		this.priorityGenerator = new Random();
	}

	public Treap(long seed){
		this.root = null;
		this.priorityGenerator = new Random(seed);
	}


	public boolean add(E key) {
		//compareTo for lex string comparison
		return add(key, priorityGenerator.nextInt());
	}

	public boolean add(E key, int priority) {
		Node<E> n = new Node<E>(key, priority);
		if(this.root == null){
			this.root = n;
			return true;
		}
		if(find(key)) return false;
		
		Stack<Node<E>> s;
		//iterate thru things based on key values; 
		s = insert(new Stack<Node<E>>(), this.root, n);
		System.out.println(s);
		//System.out.println(this);
		reheap(s, n);
		return true;
	}

	public Stack<Node<E>> insert(Stack<Node<E>> s, Node<E> root, Node<E> n){
		//if key is smaller than current node; > 0 means root is larger quantity; new node (smaller) should be in left branch.
		s.add(root);
		if(root.data.compareTo(n.data) > 0){ //do not account for equal 0 cos find handles that. 
			//if left branch exists
			if(root.left != null)
				return insert(s, root.left, n);
			root.left = n;
		}
		else{
			if(root.right != null)
				return insert(s, root.right, n);
			root.right = n;
		}
		return s;
	}

	private void reheap(Stack<Node<E>> s, Node<E> curr) {
		// helper to add, restores invariant
		
		//rotate given current node (n) and stack end

		/*
			iterate while curr prio is less than parent prio
			compare curr data against parent data to check:
				if curr is left branch, rotate right.
				if curr is right branch, rotate left.
			pop stack each iteration until stack is empty or 
			prio is less than upcoming node in stack
		*/

		//TODO: Figure out rotateleft and right
		while(true){
			if(s.isEmpty()) break;
			Node<E> parent = s.pop();
			Node<E> grandparent = s.isEmpty() ? null : s.peek();
			System.out.println(parent.data);
			System.out.println(curr.data);
			//if curr is to left of parent
			if(curr.priority >= parent.priority){
				if(curr.data.compareTo(parent.data) < 0){ //not considering = since that should be handled by find.
					System.out.println("rotate right");
					//ROTATE RETURNS A VALUE. USE THAT
					Node<E> invariant = parent.rotateRight();
					if(grandparent == null) {
						System.out.println(this);
						continue;	
					}
					//> attach rotated branch to grandparent (if have)
					if(grandparent.left.equals(parent))
						grandparent.left = invariant;
					else
						grandparent.right = invariant;
					System.out.println(this);
					continue;
				}
				System.out.println("rotate left");
				Node<E> invariant = parent.rotateLeft();
				//System.out.println(this);
				
				if(grandparent == null) {
					System.out.println(this);
					continue;
				}
				if(grandparent.left.equals(parent))
					grandparent.left = invariant;
				else
					grandparent.right = invariant;
				System.out.println(this);
			}

		}
	}

	public boolean delete(E key) {
		return false;
	}

	boolean find(E key) {
		// return if node with key key exists
		//traverse tree, if found key return true. else false.
		
		return findHelper(key, this.root);
	}
	
	boolean findHelper(E key, Node<E> root){
		if(root.data.compareTo(key) == 0) return true;
		
		//basically use it lose it except i used one variable cos i didnt think to be more understandable and use two
		boolean r = false;
		if(root.left != null){
			r = findHelper(key, root.left);
		}
		if(root.right != null){
			r = r ? r : findHelper(key, root.right); //if r is already true from root.left, don't change it
		}
		return r;
	}

	public String toString() {
		// string representation of the treap
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(this.root, 1, sb);
		return sb.toString();
	}

	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		// helper to toString, traverses treap and adds to stringbuilder
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

	public static void main(String[] args){
		//testing find
		/* Treap<Integer> t = new Treap<>();
		Node<Integer> root = new Node<Integer>(4, 19);
		t.root = root;
		t.root.left = new Node<Integer>(5, 20);
		t.root.left.left = new Node<Integer>(10, 20);
		t.root.left.right = new Node<Integer>(11, 20);
		t.root.left.right.left = new Node<Integer>(12, 20);
		t.root.left.right.left.right = new Node<Integer>(13, 20);
		t.root.left.right.left.right.right = new Node<Integer>(14, 20);
		t.root.right = new Node<Integer>(2, 10);
		t.root.right.left = new Node<Integer>(3, 11);
		t.root.right.left.left = new Node<Integer>(0, 11);
		t.root.right.left.left.right = new Node<Integer>(9, 11);
		System.out.println(t.find(4));
		System.out.println(t.find(5));
		System.out.println(t.find(2));
		System.out.println(t.find(3));
		System.out.println(t.find(0));
		System.out.println(t.find(9));
		System.out.println(t.find(10));
		System.out.println(t.find(11));
		System.out.println(t.find(12));
		System.out.println(t.find(13));
		System.out.println(t.find(14));
		System.out.println(t.find(15)); */
		
		/* Treap<Character> t = new Treap<Character>();
		t.add('p', 99);
		t.add('g', 80);
		t.add('a', 60);
		t.add('j', 65);
		t.add('u', 75);
		t.add('r', 40);
		t.add('z', 47);
		t.add('w', 32);
		t.add('v', 31);
		t.add('x', 25);
		t.add('i', 93);
		String s = t.toString();
		Node<Integer> root = new Node<Integer>(4, 19);
		String s1 = root.toString();
		System.out.println(s);
		System.out.println(s1); */
		//System.out.println(t.find('i') ? "Pass: found i": "Failed to find i\n" + s + "\n" + s1);

		/* testTree.add(5);
		testTree.add(4, 19);
		testTree.find(5) */

		/* System.out.println("Test 1 ---------------------------");
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(5, 19);
		testTree.add(3, 19);
		testTree.add(1, 19);
		testTree.add(2, 19);
		String s = testTree.toString();
		Node<Integer> root = new Node<Integer>(4, 19);
		String s1 = root.toString();
		System.out.println(s);
		System.out.println(s1);
		System.out.println(testTree.find(4) ? "Pass: found 4": "Failed to find 4\n" + s + "\n" + s1);
 		*/

		/* System.out.println("Test 2 ---------------------------");
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(5);
		testTree.add(4, 19);
		String s = testTree.toString();
		Node<Integer> root = new Node<Integer>(5); // does not meet constructor requirements
		root.left = new Node<Integer>(4, 19);
		String s1 = root.toString();
		System.out.println(testTree.find(5) ? "Pass: found 5": "Failed to find 5\n" + s + "\n" + s1);
 		 */
		/*
		System.out.println("Test 3 ---------------------------");
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		System.out.println(testTree.toString());
		/* testTree.delete(3);
		String s = testTree.toString();	
		Node<Integer> root = new Node<Integer>(1, 84);
		root.right = new Node<Integer>(5, 83);
		root.right.left = new Node<Integer>(2, 31);
		root.right.left.right = new Node<Integer>(4,19);
		root.right.right = new Node<Integer>(6, 70);
		root.right.right.right = new Node<Integer>(7, 26);
		String s1 = root.toString();
		System.out.println(!testTree.find(3) ? "Pass: failed to find 3": "Failed: found 3 (not supposed to)\n" + s + "\n" + s1);
		System.out.println(testTree.find(4) ? "Pass: found 4": "Failed to find 4\n" + s + "\n" + s1);
		System.out.println(testTree.find(2) ? "Pass: found 2": "Failed to find 2\n" + s + "\n" + s1);
		System.out.println(testTree.find(6) ? "Pass: found 6": "Failed to find 6\n" + s + "\n" + s1);
		System.out.println(testTree.find(1) ? "Pass: found 1": "Failed to find 1\n" + s + "\n" + s1);
		System.out.println(testTree.find(5) ? "Pass: found 5": "Failed to find 5\n" + s + "\n" + s1);
		System.out.println(testTree.find(7) ? "Pass: found 7": "Failed to find 7\n" + s + "\n" + s1);
		*/
		
		System.out.println("Test 4 ---------------------------");
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		//testTree.delete(4);
		String s = testTree.toString();
		String s1 = "";
		Integer n = 4;
		System.out.println(!testTree.find(n) ? "Pass: failed to find "+n: "Failed: found "+n+" (not supposed to)\n"+s+"\n"+s1);
		n = 3;
		System.out.println(testTree.find(n) ? "Pass: found "+n: "Failed to find 4\n"+s+"\n"+s1);
		n = 2;
		System.out.println(testTree.find(n) ? "Pass: found "+n: "Failed to find 4\n"+s+"\n"+s1);
		n = 6;
		System.out.println(testTree.find(n) ? "Pass: found "+n: "Failed to find 4\n"+s+"\n"+s1);
		n = 1;
		System.out.println(testTree.find(n) ? "Pass: found "+n: "Failed to find 4\n"+s+"\n"+s1);
		n = 5;
		System.out.println(testTree.find(n) ? "Pass: found "+n: "Failed to find 4\n"+s+"\n"+s1);
		n = 7;
		System.out.println(testTree.find(n) ? "Pass: found "+n: "Failed to find 4\n"+s+"\n"+s1);
		
		/*
		System.out.println("Test 5 ---------------------------");
		testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		testTree.delete(2);
		s = testTree.toString();
		root = new Node<Integer>(1, 84);
		root.right = new Node<Integer>(5, 83);
		root.right.left = new Node<Integer>(4,19);
		root.right.left.left = new Node<Integer>(3,12);
		root.right.right = new Node<Integer>(6, 70);
		root.right.right.right = new Node<Integer>(7, 26);
		s1 = root.toString();
		int[] a = {3, 4, 6, 1, 5, 7};
		n=2;
		System.out.println(!testTree.find(n) ? "Pass: failed to find "+n: "Failed: found "+n+" (not supposed to)\n"+s+"\n"+s1);
		for (int i : a) {
			System.out.println(testTree.find(i) ? "Pass: found "+i: "Failed to find 4\n"+s+"\n"+s1);
		}
		
		System.out.println("Test 6 ---------------------------");
		Treap<Character> t = new Treap<Character>();
		t.add('p', 99);
		t.add('g', 80);
		t.add('a', 60);
		t.add('j', 65);
		t.add('u', 75);
		t.add('r', 40);
		t.add('z', 47);
		t.add('w', 32);
		t.add('v', 21);
		t.add('x', 25);
		t.delete('z');
		s = t.toString();
		Node<Character> rc= new Node<Character>('p', 99);
		rc.left.left = new Node<Character>('a', 60);
		rc.left = new Node<Character>('g', 80);
		rc.left.right = new Node<Character>('j',65);
		rc.right = new Node<Character>('u', 75);
		rc.right.left = new Node<Character>('r', 40);
		rc.right.right = new Node<Character>('w', 32);
		rc.right.right.right = new Node<Character>('x', 25);
		rc.right.right.left = new Node<Character>('v', 21);
		s1 = rc.toString();
		char[] b = {'p', 'g', 'a', 'j', 'u', 'r', 'w', 'v', 'x'};
		char c = 'z';
		System.out.println(!t.find(c) ? "Pass: failed to find "+c: "Failed: found "+c+" (not supposed to)\n"+s+"\n"+s1);
		for (char i : b) {
			System.out.println(t.find(i) ? "Pass: found "+i: "Failed to find 4\n"+s+"\n"+s1);
		}
		
		System.out.println("Test 7 ---------------------------");
		Treap<String> tests = new Treap<String>();
		tests.add("p", 99);
		tests.add("g", 80);
		tests.add("a", 60);
		tests.add("j", 65);
		tests.add("u", 75);
		tests.add("r", 40);
		tests.add("z", 47);
		tests.add("w", 32);
		tests.add("v", 21);
		tests.add("x", 25);
		tests.add("z1", 35);
		tests.add("z2", 30);
		tests.delete("z");
		s = tests.toString();
		Node<String> rs = new Node<String>("p", 99);
		rs.left = new Node<String>("g", 80);
		rs.left.left = new Node<String>("a", 60);
		rs.left.right = new Node<String>("j",65);
		rs.right = new Node<String>("u", 75);
		rs.right.left = new Node<String>("r", 40);
		rs.right.right = new Node<String>("z1",35);
		rs.right.right.left = new Node<String>("w", 32);
		rs.right.right.left.left = new Node<String>("v", 21);
		rs.right.right.left.right = new Node<String>("x", 25);
		rs.right.right.right = new Node<String>("z2", 30);
		s1 = rs.toString();
		String[] d = {"p", "g", "a", "j", "u", "r", "w", "v", "", "z1", "z2"};
		String e = "z";
		System.out.println(!tests.find(e) ? "Pass: failed to find "+e: "Failed: found "+e+" (not supposed to)\n"+s+"\n"+s1);
		for (String i : d) {
			System.out.println(tests.find(i) ? "Pass: found "+i: "Failed to find 4\n"+s+"\n"+s1);
		}
		
		
		System.out.println("Test 8 ---------------------------");
		tests = new Treap<String>();
		tests.add("p", 99);
		tests.add("g", 80);
		boolean wow = tests.delete("z");
		s = tests.toString();
		rs = new Node<String>("p", 99);
		rs.left = new Node<String>("g", 80);
		s1 = rs.toString();
		System.out.println(tests.find("z") ? "Pass: failed to find "+c: "Failed: found "+c+" (not supposed to)\n"+s+"\n"+s1);
		System.out.println(wow + ": False"); */
	}
}