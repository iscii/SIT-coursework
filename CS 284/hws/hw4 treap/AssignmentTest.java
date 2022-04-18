import org.junit.Test;

import com.gradescope.jh61b.grader.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

import com.gradescope.jh61b.junit.JUnitUtilities;

public class AssignmentTest<E> {
	@Test(timeout = 6000)
	@GradedTest(name = "Test addFirst()", max_score = 10)
	public void addFirst() {
		try {
			Treap<Integer> testTree = new Treap<Integer>();
			testTree.add(4, 19);
			String s = testTree.toString();
			Node<Integer> root = new Node<Integer>(4, 19);
			String s1 = root.toString();
			if (!testTree.find(4)) {
				System.out.println(JUnitUtilities.get_error_message("", "(4,19)", s1, s));
			}
			assertEquals(true, testTree.find(4));

		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test(timeout = 6000)
	@GradedTest(name = "Test addNext()", max_score = 10)
	public void addNext() {
		try {
			Treap<Integer> testTree = new Treap<Integer>();
			testTree.add(4, 19);
			testTree.add(5);
			String s = testTree.toString();
			Node<Integer> root = new Node<Integer>(5);
			root.left = new Node<Integer>(4, 19);
			String s1 = root.toString();
			if (!testTree.find(5)) {
				System.out.println(JUnitUtilities.get_error_message("", "(4,19),(5)", s1, s));
			}
			assertEquals(true, testTree.find(5));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test(timeout = 6000)
	@GradedTest(name = "Test deleteLeaf()", max_score = 20)
	public void deleteLeaf() {
		try{
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		testTree.delete(3);
		String s = testTree.toString();	
		Node<Integer> root = new Node<Integer>(1, 84);
		root.right = new Node<Integer>(5, 83);
		root.right.left = new Node<Integer>(2, 31);
		root.right.left.right = new Node<Integer>(4,19);
		root.right.right = new Node<Integer>(6, 70);
		root.right.right.right = new Node<Integer>(7, 26);
		String s1 = root.toString();
		if (testTree.find(3)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		if (!testTree.find(4)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		if (!testTree.find(2)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		if (!testTree.find(6)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		if (!testTree.find(1)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		if (!testTree.find(5)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		if (!testTree.find(7)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(3)", s1, s));
		}
		assertEquals(false, testTree.find(3));
		assertEquals(true, testTree.find(4));
		assertEquals(true, testTree.find(2));
		assertEquals(true, testTree.find(6));
		assertEquals(true, testTree.find(1));
		assertEquals(true, testTree.find(5));
		assertEquals(true, testTree.find(7));
	}catch (Exception e) {
		e.printStackTrace(System.out);
		assertEquals(1, 0);
	}
	}

	@Test(timeout = 6000)
	@GradedTest(name = "Test deleteAlmostLeaf()", max_score = 10)
	public void deleteAlmostLeaf() {
		try{
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		testTree.delete(4);
		String s = testTree.toString();
		Node<Integer> root = new Node<Integer>(1, 84);
		root.right = new Node<Integer>(5, 83);
		root.right.left = new Node<Integer>(2,31);
		root.right.left.right = new Node<Integer>(3,12);
		root.right.right = new Node<Integer>(6, 70);
		root.right.right.right = new Node<Integer>(7, 26);
		String s1 = root.toString();
		if (testTree.find(4)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		if (!testTree.find(3)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		if (!testTree.find(2)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		if (!testTree.find(6)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		if (!testTree.find(1)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		if (!testTree.find(5)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		if (!testTree.find(7)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(4)", s1, s));
		}
		assertEquals(false, testTree.find(4));
		assertEquals(true, testTree.find(3));
		assertEquals(true, testTree.find(2));
		assertEquals(true, testTree.find(6));
		assertEquals(true, testTree.find(1));
		assertEquals(true, testTree.find(5));
		assertEquals(true, testTree.find(7));
	}catch (Exception e) {
		e.printStackTrace(System.out);
		assertEquals(1, 0);
	}
	}

	@Test(timeout = 6000)
	@GradedTest(name = "Test deleteOneFromAlmostLeaf()", max_score = 10)
	public void deleteOneFromAlmostLeaf() {
		try{
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		testTree.delete(2);
		String s = testTree.toString();
		Node<Integer> root = new Node<Integer>(1, 84);
		root.right = new Node<Integer>(5, 83);
		root.right.left = new Node<Integer>(4,19);
		root.right.left.left = new Node<Integer>(3,12);
		root.right.right = new Node<Integer>(6, 70);
		root.right.right.right = new Node<Integer>(7, 26);
		String s1 = root.toString();
		if (testTree.find(2)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		if (!testTree.find(3)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		if (!testTree.find(4)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		if (!testTree.find(6)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		if (!testTree.find(1)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		if (!testTree.find(5)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		if (!testTree.find(7)) {
			System.out.println(JUnitUtilities.get_error_message("", "(4,19),(2, 31),(6, 70),(1, 84),(3, 12),(5, 83),(7, 26)-->delete(2)", s1, s));
		}
		assertEquals(false, testTree.find(2));
		assertEquals(true, testTree.find(3));
		assertEquals(true, testTree.find(4));
		assertEquals(true, testTree.find(6));
		assertEquals(true, testTree.find(1));
		assertEquals(true, testTree.find(5));
		assertEquals(true, testTree.find(7));
	}catch (Exception e) {
		e.printStackTrace(System.out);
		assertEquals(1, 0);
	}
	}
	
	@Test(timeout = 6000)
	@GradedTest(name = "Test deleteGivenEx1()", max_score = 20)
	public void deleteGivenEx1() {
		try{
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
		String s = t.toString();
		Node<Character> root = new Node<Character>('p', 99);
		root.left = new Node<Character>('g', 80);
		root.left.left = new Node<Character>('a', 60);
		root.left.right = new Node<Character>('j',65);
		root.right = new Node<Character>('u', 75);
		root.right.left = new Node<Character>('r', 40);
		root.right.right = new Node<Character>('w', 32);
		root.right.right.right = new Node<Character>('x', 25);
		root.right.right.left = new Node<Character>('v', 21);
		String s1 = root.toString();
		if (t.find('z')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('p')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('g')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('a')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('j')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('u')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('r')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('w')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('v')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		if (!t.find('x')) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25)-->delete('z)", s1, s));
		}
		assertEquals(false, t.find('z'));
		assertEquals(true, t.find('p'));
		assertEquals(true, t.find('g'));
		assertEquals(true, t.find('a'));
		assertEquals(true, t.find('j'));
		assertEquals(true, t.find('u'));
		assertEquals(true, t.find('r'));
		assertEquals(true, t.find('w'));
		assertEquals(true, t.find('v'));
		assertEquals(true, t.find('x'));
	}catch (Exception e) {
		e.printStackTrace(System.out);
		assertEquals(1, 0);
	}
	}

	@Test(timeout = 6000)
	@GradedTest(name = "Test deleteGivenEx2()", max_score = 10)
	public void deleteGivenEx2() {
		try{
		Treap<String> testTree = new Treap<String>();
		testTree.add("p", 99);
		testTree.add("g", 80);
		testTree.add("a", 60);
		testTree.add("j", 65);
		testTree.add("u", 75);
		testTree.add("r", 40);
		testTree.add("z", 47);
		testTree.add("w", 32);
		testTree.add("v", 21);
		testTree.add("x", 25);
		testTree.add("z1", 35);
		testTree.add("z2", 30);
		testTree.delete("z");
		String s = testTree.toString();
		Node<String> root = new Node<String>("p", 99);
		root.left = new Node<String>("g", 80);
		root.left.left = new Node<String>("a", 60);
		root.left.right = new Node<String>("j",65);
		root.right = new Node<String>("u", 75);
		root.right.left = new Node<String>("r", 40);
		root.right.right = new Node<String>("z1",35);
		root.right.right.left = new Node<String>("w", 32);
		root.right.right.left.left = new Node<String>("v", 21);
		root.right.right.left.right = new Node<String>("x", 25);
		root.right.right.right = new Node<String>("z2", 30);
		String s1 = root.toString();
		if (testTree.find("z")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("p")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("g")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("a")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("j")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("u")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("r")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("w")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("v")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("x")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("z1")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		if (!testTree.find("z2")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80),('a',60),('j',65),('u',75),('r',40),('z',47),('w', 32),('v', 21),('x', 25),('z1', 35),('z2',30)-->delete('z)", s1, s));
		}
		assertEquals(false, testTree.find("z"));
		assertEquals(true, testTree.find("p"));
		assertEquals(true, testTree.find("g"));
		assertEquals(true, testTree.find("a"));
		assertEquals(true, testTree.find("j"));
		assertEquals(true, testTree.find("u"));
		assertEquals(true, testTree.find("r"));
		assertEquals(true, testTree.find("w"));
		assertEquals(true, testTree.find("v"));
		assertEquals(true, testTree.find("x"));
		assertEquals(true, testTree.find("z1"));
		assertEquals(true, testTree.find("z2"));
		}catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test(timeout = 6000)
	@GradedTest(name = "Test deleteNonExistent()", max_score = 10)
	public void deleteNonExistent() {
		try{
		Treap<String> testTree = new Treap<String>();
		testTree.add("p", 99);
		testTree.add("g", 80);
		boolean wow = testTree.delete("z");
		String s = testTree.toString();
		Node<String> root = new Node<String>("p", 99);
		root.left = new Node<String>("g", 80);
		String s1 = root.toString();
		if (testTree.find("z")) {
			System.out.println(JUnitUtilities.get_error_message("", "('p',99),('g',80)-->delete('z')", s1, s));
		}
		assertEquals(false, wow);
		}catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	public class Node<E> {
		E data;
		int priority;
		Node<E> left;
		Node<E> right;
		
		public Node(E data) {
			if (data == null)
				throw new IllegalArgumentException();
			this.data = data;
			this.priority = 0;
			this.left = null;
			this.right = null;
		}

		public Node(E data, int priority) {
			if (data == null)
				throw new IllegalArgumentException();
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;

		}
		
		public String toString() {
			// string representation of the treap
			StringBuilder sb = new StringBuilder();
			preOrderTraverse(this, 1, sb);
			return sb.toString();
		}

		public String toStringPriorityVal() {
			return "(key=" + data.toString() + ", priority=" + priority + ")";
		}

		private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
			// helper to toString, traverses treap and adds to stringbuilder
			for (int i = 1; i < depth; i++) {
				sb.append("  ");
			}
			if (node == null) {
				sb.append("null\n");
			} else {
				sb.append(node.toStringPriorityVal());
				sb.append("\n");
				preOrderTraverse(node.left, depth + 1, sb);
				preOrderTraverse(node.right, depth + 1, sb);
			}
		}

	}
}