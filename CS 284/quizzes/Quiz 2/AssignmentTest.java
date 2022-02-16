import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.jh61b.junit.JUnitUtilities;

import java.util.*;

public class AssignmentTest {

	@Test
	@GradedTest(name = "Test hasCycle() #1", max_score = 20)
	public void testHasCycle1() {
		try {
			SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
			Node<Integer> node1 = new Node<Integer>(1);
			Node<Integer> node2 = new Node<Integer>(2);
			Node<Integer> node3 = new Node<Integer>(3);
			Node<Integer> node4 = new Node<Integer>(4);
			Node<Integer> node5 = new Node<Integer>(5);

			list.setHeadNode(node1);
			node1.setNext(node2);
			node2.setNext(node3);
			node3.setNext(node4);
			node4.setNext(node5);

			if (list.hasCycle()) {
				System.out.println(JUnitUtilities.get_error_message("", "1 -> 2 -> 3 -> 4 -> 5", "false",
						list.hasCycle().toString()));
			}

			assertEquals(false, list.hasCycle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}
	
	@Test
	@GradedTest(name = "Test hasCycle() #2", max_score = 20)
	public void testHasCycle2() {
		try {
			SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
			Node<Integer> node1 = new Node<Integer>(10);
			Node<Integer> node2 = new Node<Integer>(20);
			Node<Integer> node3 = new Node<Integer>(30);
			list.setHeadNode(node1);
			node1.setNext(node2);
			node2.setNext(node3);
			node3.setNext(node1);
			if (!list.hasCycle()) {
				System.out.println(JUnitUtilities.get_error_message("", "10 -> 20 -> 30 -> 10", "true", list.hasCycle().toString()));
			}

			assertEquals(true, list.hasCycle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test hasCycle() #3", max_score = 20)
	public void testHasCycle3() {
		try {
			SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();

			if (list.hasCycle()) {
				System.out.println(JUnitUtilities.get_error_message("", "", "false", list.hasCycle().toString()));
			}

			assertEquals(false, list.hasCycle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}
	
	@Test
	@GradedTest(name = "Test hasCycle() #4", max_score = 20)
	public void testHasCycle4() {
		try {
			SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
			Node<Integer> node1 = new Node<>(100);
			Node<Integer> node2 = new Node<>(200);
			Node<Integer> node3 = new Node<>(300);
			Node<Integer> node4 = new Node<>(400);
			list.setHeadNode(node1);
			node1.setNext(node2);
			node2.setNext(node1);
			node3.setNext(node1);
			node4.setNext(node1);
			
			if (!list.hasCycle()) {
				System.out.println(JUnitUtilities.get_error_message("", "100 -> 200 -> 100, 300 -> 100, 400 -> 100", "true", list.hasCycle().toString()));
			}

			assertEquals(true, list.hasCycle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}
	
	@Test
	@GradedTest(name = "Test hasCycle() #5", max_score = 10)
	public void testHasCycle5() {
		try {
			SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
			Node<Integer> node1 = new Node<>(11);
			Node<Integer> node2 = new Node<>(12);
			Node<Integer> node3 = new Node<>(13);
			Node<Integer> node4 = new Node<>(14);
			Node<Integer> node5 = new Node<>(15);
			Node<Integer> node6 = new Node<>(16);
			Node<Integer> node7 = new Node<>(17);
			Node<Integer> node8 = new Node<>(18);
			Node<Integer> node9 = new Node<>(19);
			Node<Integer> node10 = new Node<>(20);
			Node<Integer> node11 = new Node<>(21);
			Node<Integer> node12 = new Node<>(22);
			
			list.setHeadNode(node1);
			node1.setNext(node2); 
			node2.setNext(node3); 
			node3.setNext(node4); 
			node4.setNext(node5); 
			node5.setNext(node6); 
			node6.setNext(node7); 
			node7.setNext(node8); 
			node8.setNext(node9);
			node9.setNext(node10);
			node10.setNext(node11);
			node11.setNext(node12);
			if (list.hasCycle()) {
				System.out.println(JUnitUtilities.get_error_message("", "11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 21 -> 22 ", "false", list.hasCycle().toString()));
			}

			assertEquals(false, list.hasCycle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}
	
	@Test
	@GradedTest(name = "Test hasCycle() #6", max_score = 10)
	public void testHasCycle6() {
		try {
			SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
			Node<Integer> node1 = new Node<Integer>(1000);
			list.setHeadNode(node1);
			node1.setNext(node1);
			
			if (!list.hasCycle()) {
				System.out.println(JUnitUtilities.get_error_message("", "1000 -> 1000", "true", list.hasCycle().toString()));
			}

			assertEquals(true, list.hasCycle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}
}