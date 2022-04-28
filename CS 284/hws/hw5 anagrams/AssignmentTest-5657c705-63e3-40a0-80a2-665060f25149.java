
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.jh61b.junit.JUnitUtilities;

public class AssignmentTest {

	@Test
	@GradedTest(name = "Test buildLetterTable", max_score = 15)
	public void test_buildLetterTable() {
		try {
			// update letterTable
			Character[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
					'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

			final Integer[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
					79, 83, 89, 97, 101 };

			Map<Character, Integer> letterTable = new HashMap<Character, Integer>();
			for (int i = 0; i < letters.length; i++) {
				letterTable.put(letters[i], primes[i]);
			}

			Anagrams test1 = new Anagrams();
			test1.buildLetterTable();

			if (!letterTable.equals(test1.getLetterTable())) {
				// input
				String inputString = "Letters: " + Arrays.toString(letters) + "\n" + "Primes: "
						+ Arrays.toString(primes);

				// convert expected map to string
				StringBuilder sbExpected = new StringBuilder();
				sbExpected.append("{ " + "\n");
				letterTable.forEach((key, value) -> sbExpected.append(key + ":" + value + "\n"));
				sbExpected.append("} " + "\n");

				// convert output map to string
				StringBuilder sbOutput = new StringBuilder();
				sbOutput.append("{ " + "\n");
				test1.getLetterTable().forEach((key, value) -> sbOutput.append(key + ":" + value + "\n"));
				sbOutput.append("} " + "\n");

				System.out.println(
						JUnitUtilities.get_error_message("", inputString, sbExpected.toString(), sbOutput.toString()));
			}

			assertTrue(letterTable.equals(test1.getLetterTable()));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test addWord 1", max_score = 15)
	public void test_addWord_1() {
		try {
			Anagrams test21 = new Anagrams();

			ArrayList<String> s1 = new ArrayList<String>();
			s1.add("tushed");
			s1.add("ulidia");
			s1.add("grun");
			s1.add("waxy");

			for (String ss : s1) {
				test21.addWord(ss);
			}

			// Test case 1
			ArrayList<String> t1 = new ArrayList<String>();
			t1.add("tushed");

			ArrayList<String> answer1 = test21.getAnagramTable().get(508042843L);
			boolean isCorrect = t1.equals(answer1);

			if (!isCorrect) {
				System.out.println(
						JUnitUtilities.get_error_message("", "508042843L", t1.toString(), String.valueOf(answer1)));
				assertEquals(1, 0);
			} else {
				assertEquals(0, 0);
			}

			// Test case 2
			ArrayList<String> t2 = new ArrayList<String>();
			t2.add("ulidia");

			ArrayList<String> answer2 = test21.getAnagramTable().get(20003606L);
			boolean isCorrect2 = t2.equals(answer2);

			if (!isCorrect2) {
				System.out.println(
						JUnitUtilities.get_error_message("", "20003606L", t2.toString(), String.valueOf(answer2)));
				assertEquals(1, 0);
			} else {
				assertEquals(0, 0);
			}

			// assertTrue(t2.equals(test21.getAnagramTable().get(20003606L)));

			// Test case 3
			ArrayList<String> t3 = new ArrayList<String>();
			t3.add("grun");

			ArrayList<String> answer3 = test21.getAnagramTable().get(3255143L);
			boolean isCorrect3 = t3.equals(answer3);

			if (!isCorrect3) {
				System.out.println(
						JUnitUtilities.get_error_message("", "3255143L", t3.toString(), String.valueOf(answer3)));
				assertEquals(1, 0);
			} else {
				assertEquals(0, 0);
			}

			// assertTrue(t3.equals(test21.getAnagramTable().get(3255143L)));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test addWord 2", max_score = 10)
	public void test_addWord_2() {
		try {
			Anagrams test22 = new Anagrams();
			// update anagramTable
			try {
				test22.processFile("words_alpha.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			ArrayList<String> s3 = new ArrayList<String>();
			s3.add("pounder");
			s3.add("repound");
			s3.add("unroped");

			ArrayList<String> answer = test22.getAnagramTable().get(36727012553L);

			if (!s3.equals(answer)) {
				System.out.println(
						JUnitUtilities.get_error_message("", "36727012553L", s3.toString(), String.valueOf(answer)));
				assertEquals(1, 0);
			} else {
				assertEquals(0, 0);
			}

			// assertTrue(s3.equals(test22.getAnagramTable().get(36727012553L)));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test myHashCode 1", max_score = 15)
	public void test_myHashCode_1() {
		try {
			Anagrams test31 = new Anagrams();
			String st1 = "alerts";
			String st2 = "alters";

			if (!test31.myHashCode(st1).equals(test31.myHashCode(st2))) {
				System.out.println(JUnitUtilities.get_error_message("", "String 1: alerts, String 2: alters",
						"236204078L", test31.myHashCode(st2).toString()));
			}

			assertEquals(test31.myHashCode(st1), test31.myHashCode(st2));

			String st3 = "diauli";
			String st4 = "ulidia";

			if (!test31.myHashCode(st3).equals(test31.myHashCode(st4))) {
				System.out.println(JUnitUtilities.get_error_message("", "String 1: diauli, String 2: ulidia",
						"20003606L", test31.myHashCode(st4).toString()));
			}

			assertEquals(test31.myHashCode(st3), test31.myHashCode(st4));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test myHashCode 2", max_score = 15)
	public void test_myHashCode_2() {
		try {
			Anagrams test32 = new Anagrams();

			Long x1 = 1433078L;
			if (!x1.equals(test32.myHashCode("waxy"))) {
				System.out.println(JUnitUtilities.get_error_message("", "waxy", x1.toString(),
						test32.myHashCode("waxy").toString()));
			}
			assertEquals(x1, test32.myHashCode("waxy"));

			Long x2 = 52901860L;
			if (!x2.equals(test32.myHashCode("acylase"))) {
				System.out.println(JUnitUtilities.get_error_message("", "acylase", x2.toString(),
						test32.myHashCode("acylase").toString()));
			}
			assertEquals(x2, test32.myHashCode("acylase"));

			Long x3 = 12366530L;
			if (!x3.equals(test32.myHashCode("reachy"))) {
				System.out.println(JUnitUtilities.get_error_message("", "reachy", x3.toString(),
						test32.myHashCode("reachy").toString()));
			}
			assertEquals(x3, test32.myHashCode("reachy"));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test getMaxEntries 1", max_score = 10)
	public void test_getMaxEntries_1() {
		try {
			ArrayList<String> max1 = new ArrayList<String>();
			max1.add("pounder");
			max1.add("repound");
			max1.add("unroped");

			Anagrams test41 = new Anagrams();
			try {
				test41.processFile("words_alpha_mini.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries1 = test41.getMaxEntries();

			Long code1 = 36727012553L;
			if (!code1.equals(maxEntries1.get(0).getKey())) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha_mini.txt", code1.toString(),
						maxEntries1.get(0).getKey().toString()));
			}
			assertEquals(code1, maxEntries1.get(0).getKey());

			if (3 != maxEntries1.get(0).getValue().size()) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha_mini.txt", "3",
						String.valueOf(maxEntries1.get(0).getValue().size())));
			}
			assertEquals(3, maxEntries1.get(0).getValue().size());

			if (!max1.equals(maxEntries1.get(0).getValue())) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha_mini.txt", max1.toString(),
						maxEntries1.get(0).getValue().toString()));
			}
			assertTrue(max1.equals(maxEntries1.get(0).getValue()));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test getMaxEntries 2", max_score = 10)
	public void test_getMaxEntries_2() {
		try {
			ArrayList<String> max2 = new ArrayList<String>();
			max2.add("apers");
			max2.add("apres");
			max2.add("asper");

			max2.add("pares");
			max2.add("parse");
			max2.add("pears");

			max2.add("rapes");
			max2.add("spaer");
			max2.add("spare");
			max2.add("spear");

			Anagrams test42 = new Anagrams();
			try {
				test42.processFile("words_alpha_small.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries2 = test42.getMaxEntries();
			Long code2 = 4765442L;
			if (!code2.equals(maxEntries2.get(0).getKey())) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha_small.txt", code2.toString(),
						maxEntries2.get(0).getKey().toString()));
			}
			assertEquals(code2, maxEntries2.get(0).getKey());

			if (10 != maxEntries2.get(0).getValue().size()) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha_small.txt", "10",
						String.valueOf(maxEntries2.get(0).getValue().size())));
			}
			assertEquals(10, maxEntries2.get(0).getValue().size());

			if (!max2.equals(maxEntries2.get(0).getValue())) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha_small.txt", max2.toString(),
						maxEntries2.get(0).getValue().toString()));
			}
			assertTrue(max2.equals(maxEntries2.get(0).getValue()));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test getMaxEntries 3", max_score = 10)
	public void test_getMaxEntries_3() {
		try {
			ArrayList<String> max3 = new ArrayList<String>();
			max3.add("alerts");
			max3.add("alters");
			max3.add("artels");

			max3.add("estral");
			max3.add("laster");
			max3.add("lastre");

			max3.add("rastle");
			max3.add("ratels");
			max3.add("relast");

			max3.add("resalt");
			max3.add("salter");
			max3.add("slater");

			max3.add("staler");
			max3.add("stelar");
			max3.add("talers");

			Anagrams test43 = new Anagrams();
			try {
				test43.processFile("words_alpha.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries3 = test43.getMaxEntries();
			Long code3 = 236204078L;

			if (!code3.equals(maxEntries3.get(0).getKey())) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha.txt", code3.toString(),
						maxEntries3.get(0).getKey().toString()));
			}
			assertEquals(code3, maxEntries3.get(0).getKey());

			if (15 != maxEntries3.get(0).getValue().size()) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha.txt", "15",
						String.valueOf(maxEntries3.get(0).getValue().size())));
			}
			assertEquals(15, maxEntries3.get(0).getValue().size());

			if (!max3.equals(maxEntries3.get(0).getValue())) {
				System.out.println(JUnitUtilities.get_error_message("", "words_alpha.txt", max3.toString(),
						maxEntries3.get(0).getValue().toString()));
			}
			assertTrue(max3.equals(maxEntries3.get(0).getValue()));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

}