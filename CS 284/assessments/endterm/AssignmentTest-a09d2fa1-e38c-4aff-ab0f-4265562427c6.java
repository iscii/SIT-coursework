import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.jh61b.junit.JUnitUtilities;

public class AssignmentTest {

	public String array_to_string(double[] results){
		if (results == null){
			return "null";
		}
		else{
			String result_str = "";
			for (int i = 0; i < results.length; i++){
				result_str = result_str + "," + results[i];
			}
			return result_str;
		}
	}

	public String array_to_string(String[] results){
		if (results == null){
			return "null";
		}
		else{
			String result_str = "";
			for (int i = 0; i < results.length; i++){
				result_str = result_str + "," + results[i];
			}
			return result_str;
		}
	}

	// Problem 1
	public boolean identicalTrees(Node root, Node t2) {
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		identicalTrees_helper(root, r1);

		ArrayList<Integer> r2 = new ArrayList<Integer>();
		identicalTrees_helper(t2, r2);

		return r1.equals(r2);
	}

	private void identicalTrees_helper(Node node, ArrayList<Integer> results) {
		if (node != null) {
			results.add(node.value);
			identicalTrees_helper(node.left, results);
			identicalTrees_helper(node.right, results);
		}
	}

	public Node build_btree_1() {

		Node five = new Node(5, null, null);
		Node three = new Node(3, five, null);
		Node two = new Node(2, null, null);
		Node one = new Node(1, three, two);
		return one;
	}

	public Node build_btree_2() {

		Node four = new Node(4, null, null);
		Node one = new Node(1, null, four);
		Node seven = new Node(7, null, null);
		Node three = new Node(3, null, seven);
		Node two = new Node(2, one, three);
		return two;
	}

	public Node build_btree_12() {

		Node five1 = new Node(5, null, null);
		Node four1 = new Node(4, null, null);
		Node four2 = new Node(4, five1, four1);
		Node seven = new Node(7, null, null);
		Node five2 = new Node(5, null, seven);
		Node three = new Node(3, four2, five2);
		return three;

	}

	public Node build_btree_3() {

		Node seven = new Node(6704, null, null);
		Node six = new Node(9999, null, null);
		Node five = new Node(9768, null, null);
		Node four = new Node(426800, seven, null);
		Node three = new Node(1000, six, null);
		Node two = new Node(68, four, five);
		Node one = new Node(3401, two, three);
		return one;
	}

	public Node build_btree_4() {

		Node ten = new Node(653477, null, null);
		Node nine = new Node(977778, ten, null);
		Node eight = new Node(9846, nine, null);
		Node seven = new Node(6679, null, null);
		Node six = new Node(230708, null, null);
		Node five = new Node(9999, null, eight);
		Node four = new Node(7798, six, seven);
		Node three = new Node(2307, null, five);
		Node two = new Node(2310, null, four);
		Node one = new Node(6439, two, three);

		return one;
	}

	public Node build_btree_34() {

		Node thirteen = new Node(653477, null, null);
		Node twelve = new Node(977778, thirteen, null);
		Node eleven = new Node(9846, twelve, null);
		Node ten = new Node(6679, null, null);
		Node nine = new Node(230708, null, null);
		Node eight = new Node(6704, null, null);
		Node seven = new Node(9999, null, eleven);
		Node six = new Node(9999, null, null);
		Node five = new Node(17566, nine, ten);
		Node four = new Node(426800, eight, null);
		Node three = new Node(3307, six, seven);
		Node two = new Node(2378, four, five);
		Node one = new Node(9840, two, three);

		return one;

	}

	public Node build_btree_5() {

		Node seven = new Node(6874, null, null);
		Node six = new Node(730867, null, null);
		Node five = new Node(907832, seven, null);
		Node four = new Node(78, null, six);
		Node three = new Node(8, null, five);
		Node two = new Node(99999, four, null);
		Node one = new Node(230674, two, three);
		return one;
	}

	public Node build_btree_6() {

		Node nine = new Node(97318, null, null);
		Node eight = new Node(3301, null, null);
		Node seven = new Node(340100, null, nine);
		Node six = new Node(1, eight, null);
		Node five = new Node(8877, null, seven);
		Node four = new Node(2308, six, null);
		Node three = new Node(327485, four, five);
		Node two = new Node(476, null, null);
		Node one = new Node(88899, two, three);

		return one;
	}

	public Node build_btree_56() {

		Node twelve = new Node(97318, null, null);
		Node eleven = new Node(3301, null, null);
		Node ten = new Node(340100, null, twelve);
		Node nine = new Node(6874, null, null);
		Node eight = new Node(1, eleven, null);
		Node seven = new Node(730867, null, null);
		Node six = new Node(916709, nine, ten);
		Node five = new Node(2308, eight, null);
		Node four = new Node(78, null, seven);
		Node three = new Node(327493, five, six);
		Node two = new Node(100475, four, null);
		Node one = new Node(319573, two, three);

		return one;

	}

	@Test
	@GradedTest(name = "Problem1: sumTree 1", max_score = 11)
	public void test_sumTree_1() {
		try {
			BTree<Integer> test = new BTree<Integer>();
			test.root = build_btree_1();

			BTree<Integer> t2 = new BTree<Integer>();
			t2.root = build_btree_2();

			Node outNode = test.sumTree(t2).root;

			boolean output = identicalTrees(build_btree_12(), outNode);

			if (!output) {
				System.out.println(JUnitUtilities.get_error_message("",
						"\n" + "BTree1: " + test.toString() + "\n BTree2: " + t2.toString(),
						"\n" + printBTree(build_btree_12()), "\n" + printBTree(outNode)));
			}

			assertTrue(output);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Problem1: sumTree 2", max_score = 11)
	public void test_sumTree_2() {

		try {
			BTree<Integer> test = new BTree<Integer>();
			test.root = build_btree_3();

			BTree<Integer> t2 = new BTree<Integer>();
			t2.root = build_btree_4();

			Node outNode = test.sumTree(t2).root;

			boolean output = identicalTrees(build_btree_34(), outNode);

			if (!output) {
				System.err.println(JUnitUtilities.get_error_message("",
						"\n" + "BTree1: " + test.toString() + "\n BTree2: " + t2.toString(),
						"\n" + printBTree(build_btree_34()), printBTree(outNode)));
			}

			assertTrue(output);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Problem1: sumTree 3", max_score = 11)
	public void test_sumTree_3() {
		try {
			BTree<Integer> test = new BTree<Integer>();
			test.root = build_btree_5();

			BTree<Integer> t2 = new BTree<Integer>();
			t2.root = build_btree_6();

			Node outNode = test.sumTree(t2).root;
			boolean output = identicalTrees(build_btree_56(), outNode);

			if (!output) {
				System.out.println(JUnitUtilities.get_error_message("",
						"\n" + "BTree1: " + test.toString() + "\n BTree2: " + t2.toString(),
						"\n" + printBTree(build_btree_56()), printBTree(outNode)));
			}

			assertTrue(output);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	// ==================================================================================================

	// Problem 2: salt water pool
	@Test
	@GradedTest(name = "Problem2: fillInWater 1", max_score = 7)
	public void test_fillInWater_1() {

		try {
			Bar bar1 = new Bar("stone", 2);
			Bar bar2 = new Bar("stone", 5);
			Bar bar3 = new Bar("stone", 1);
			Bar bar4 = new Bar("salt", 2);
			Bar bar5 = new Bar("salt", 1);
			Bar bar6 = new Bar("stone", 4);
			Bar bar7 = new Bar("stone", 3);
			bar1.next = bar2;
			bar2.next = bar3;
			bar3.next = bar4;
			bar4.next = bar5;
			bar5.next = bar6;
			bar6.next = bar7;
			LinkedListofBar barList = new LinkedListofBar(bar1);
			double[] results = barList.fillInWater();

			double DELTA = 1e-5;

			if (results.equals(new double[]{11.0, 0.27272728}) == false) {
				String input = "stone 2 -> stone 5 -> stone 1 -> salt 2 -> salt 1 -> stone 4 -> stone 3";
				System.out.println(JUnitUtilities.get_error_message("", input, "[11.0, 0.27272728]", array_to_string(results)));
			}
			
			assertEquals(new double[]{11.0, 0.27272728}, results);

		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Problem2: fillInWater 2", max_score = 7)
	public void test_fillInWater_2() {
		try {
			Bar bar1 = new Bar("stone", 2);
			Bar bar2 = new Bar("stone", 3);
			Bar bar3 = new Bar("stone", 1);
			Bar bar4 = new Bar("salt", 2);
			Bar bar5 = new Bar("salt", 1);
			Bar bar6 = new Bar("stone", 4);
			bar1.next = bar2;
			bar2.next = bar3;
			bar3.next = bar4;
			bar4.next = bar5;
			bar5.next = bar6;
			LinkedListofBar barList = new LinkedListofBar(bar1);
			double[] results = barList.fillInWater();

			double DELTA = 1e-5;

			if (results.equals(new double[]{8.0, 0.375}) == false) {
				String input = "stone 2 -> stone 3 -> stone 1 -> salt 2 -> salt 1 -> stone 4";
				System.out.println(JUnitUtilities.get_error_message("", input, "[8.0, 0.375]", array_to_string(results)));
			}
			
			assertEquals(new double[]{8.0, 0.375}, results);


		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Problem2: fillInWater 3", max_score = 10)
	public void test_fillInWater_3() {
		try {
			Bar bar1 = new Bar("stone", 10);
			Bar bar2 = new Bar("stone", 35);
			Bar bar3 = new Bar("salt", 18);
			Bar bar4 = new Bar("stone", 29);
			Bar bar5 = new Bar("salt", 20);
			Bar bar6 = new Bar("salt", 25);
			Bar bar7 = new Bar("stone", 40);
			bar1.next = bar2;
			bar2.next = bar3;
			bar3.next = bar4;
			bar4.next = bar5;
			bar5.next = bar6;
			bar6.next = bar7;
			LinkedListofBar barList = new LinkedListofBar(bar1);
			;
			double[] results = barList.fillInWater();

			double DELTA = 1e-5;

			if (results.equals(new double[]{111.0, 0.5675676}) == false) {
				String input = "stone 10 -> stone 35 -> salt 18 -> stone 29 -> salt 20 -> salt 25 -> stone 40";
				System.out.println(JUnitUtilities.get_error_message("", input, "[111.0, 0.5675676]", array_to_string(results)));
			}
			
			assertEquals(new double[]{111.0, 0.5675676}, results);


		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Problem2: fillInWater 4", max_score = 10)
	public void test_fillInWater_4() {
		try {
			Bar bar1 = new Bar("stone", 99);
			Bar bar2 = new Bar("stone", 147);
			Bar bar3 = new Bar("salt", 100);
			Bar bar4 = new Bar("stone", 135);
			Bar bar5 = new Bar("salt", 25);
			Bar bar6 = new Bar("stone", 127);
			Bar bar7 = new Bar("salt", 55);
			Bar bar8 = new Bar("salt", 78);
			Bar bar9 = new Bar("stone", 159);
			Bar bar10 = new Bar("stone", 40);
			bar1.next = bar2;
			bar2.next = bar3;
			bar3.next = bar4;
			bar4.next = bar5;
			bar5.next = bar6;
			bar6.next = bar7;
			bar7.next = bar8;
			bar8.next = bar9;
			bar9.next = bar10;
			LinkedListofBar barList = new LinkedListofBar(bar1);
			double[] results = barList.fillInWater();

			double DELTA = 1e-5;

			if (results.equals(new double[]{620.0, 0.41612902}) == false) {
				String input = "stone 99 -> stone 147 -> salt 100 -> stone 135 -> salt 25 -> stone 127 -> salt 55 -> salt 78 -> stone 159 -> stone 40";
				System.out.println(JUnitUtilities.get_error_message("", input, "[620.0, 0.41612902]", array_to_string(results)));
			}
			
			assertEquals(new double[]{620.0, 0.41612902}, results);

		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	// ==================================================================================================
	// Problem 3
	@Test
	@GradedTest(name = "Problem3: compare_large_numbers", max_score = 5)
	public void test_compare_large_numbers() {
		try {
			The_Comparator comparator = new The_Comparator();

			String A = "23252624";
			String B = "53735734";

			if (1 != comparator.compare(A, B)) {
				System.out.println(JUnitUtilities.get_error_message("", "NumA: " + A + ", NumB: " + B, "1",
						String.valueOf(comparator.compare(A, B))));
			}
			assertEquals(1, comparator.compare(A, B));

			String x = "6525425538491040483943545426566500881939104";
			String y = "6525425538491040420248883757757777599300200";

			if (-1 != comparator.compare(x, y)) {
				System.out.println(JUnitUtilities.get_error_message("", "NumA: " + x + ", NumB: " + y, "-1",
						String.valueOf(comparator.compare(x, y))));
			}
			assertEquals(-1, comparator.compare(x, y));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Problem3: check_concatenation_dividable_by_three", max_score = 5)
	public void test_check_concatenation_dividable_by_three() {

		try {
			ConcatNumbers test = new ConcatNumbers();

			String A = "23252624";
			String B = "53735734";
			if (true != test.check_concatenation_dividable_by_three(A, B)) {
				System.out.println(JUnitUtilities.get_error_message("", "NumA: " + A + ", NumB: " + B, "true",
						String.valueOf(test.check_concatenation_dividable_by_three(A, B))));
			}
			assertEquals(true, test.check_concatenation_dividable_by_three(A, B));

			String C = "65254255";
			String D = "17780767";
			if (false != test.check_concatenation_dividable_by_three(C, D)) {
				System.out.println(JUnitUtilities.get_error_message("", "NumA: " + C + ", NumB: " + D, "false",
						String.valueOf(test.check_concatenation_dividable_by_three(C, D))));
			}
			assertEquals(false, test.check_concatenation_dividable_by_three(C, D));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Problem3: KMaxConcatenations 1", max_score = 10)
	public void test_KMaxConcatenations_1() {
		try {
			String[] A = { "23252624", "65254255", "36235235", "01328903" };
			String[] B = { "53735734", "38491040", "17780767", "89890234" };

			int N = A.length;
			int K = 3;

			String[] expected = { "6525425538491040", "3623523589890234", "3623523553735734" };

			ConcatNumbers test = new ConcatNumbers();
			String[] results = test.KMaxConcatenations(A, B, N, K);
			if (!expected.equals(results)) {
				String input = "A: " + Arrays.toString(A) + ", B: " + Arrays.toString(B) + ", N:" + N + ", K:" + K;
				System.out.println(JUnitUtilities.get_error_message("", input, array_to_string(expected),
						array_to_string(results)));
			}
			assertEquals(expected, results);
			}
		 catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Problem3: KMaxConcatenations 2", max_score = 13)
	public void test_KMaxConcatenations_2() throws IOException {
		try {
			String[] A = new String[1000];
			FileInputStream fstreamA = new FileInputStream("bigNumbersA.txt");
			BufferedReader brA = new BufferedReader(new InputStreamReader(fstreamA));
			String strLineA;
			int i = 0;
			while ((strLineA = brA.readLine()) != null) {
				A[i] = strLineA;
				i += 1;
			}

			String[] B = new String[1000];
			FileInputStream fstreamB = new FileInputStream("bigNumbersB.txt");
			BufferedReader brB = new BufferedReader(new InputStreamReader(fstreamB));
			String strLineB;
			int j = 0;
			while ((strLineB = brB.readLine()) != null) {
				B[j] = strLineB;
				j += 1;
			}

			String[] expected = new String[100];
			FileInputStream fstreamC = new FileInputStream("expected.txt");
			BufferedReader brC = new BufferedReader(new InputStreamReader(fstreamC));
			String strLineC;
			int m = 0;
			while ((strLineC = brC.readLine()) != null) {
				expected[m] = strLineC;
				m += 1;
			}

			brA.close();
			brB.close();
			brC.close();

			int N = A.length;
			int K = 100;

			ConcatNumbers test = new ConcatNumbers();
			String[] results = test.KMaxConcatenations(A, B, N, K);
			if (!expected.equals(results)) {
				String input = "A: bigNumbersA.txt, B: bigNumbersB.txt, N: " + N + ", K: " + K;
				System.out.println(JUnitUtilities.get_error_message("", input, array_to_string(expected), array_to_string(results)));
			}
			assertEquals(expected, results);
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	public String printBTree(Node root) {
		// string representation of the treap
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	private void preOrderTraverse(Node node, int depth, StringBuilder sb) {
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

}