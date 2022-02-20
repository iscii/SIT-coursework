import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.gradescope.jh61b.grader.GradedTest;

import java.util.*;

public class AssignmentTest {

    @Test
    @GradedTest(name = "Test get(int index)", max_score = 10)
    public void testGetIndex() {

        String al1[] = new String[4];
		al1[0] = "X";
        al1[1] = "Y";
        al1[2] = "Z";
        al1[3] = "W";
        		
		IDLList<String> L1 = new IDLList<String>(al1);
        assertEquals("X", L1.get(0));
        assertEquals("Y", L1.get(1));
        assertEquals("Z", L1.get(2));
        assertEquals("W", L1.get(3));

        try {
            L1.get(-1);
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        try {
            L1.get(10);
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }
    }

    @Test
    @GradedTest(name = "Test getHead()", max_score = 10)
    public void testGetHead() {

        IDLList<String> L21 = new IDLList<String>();
        assertEquals(null, L21.getHead());

        String al2[] = new String[4];
		al2[0] = "X";
        al2[1] = "Y";
        al2[2] = "Z";
        al2[3] = "W";       		
		IDLList<String> L22 = new IDLList<String>(al2);
        assertEquals("X", L22.getHead());
    }


    @Test
    @GradedTest(name = "Test getLast()", max_score = 10)
    public void testGetLast() {
        IDLList<String> L31 = new IDLList<String>();
        assertEquals(null, L31.getLast());

        String al3[] = new String[4];
		al3[0] = "X";
        al3[1] = "Y";
        al3[2] = "Z";
        al3[3] = "W";       		
		IDLList<String> L32 = new IDLList<String>(al3);
        assertEquals("W", L32.getLast());

    }

    @Test
    @GradedTest(name = "Test add(E elem)", max_score = 10)
    public void testAddElem() {
        IDLList<String> L4 = new IDLList<String>();
        
        //.add(E elem) method
        assertEquals(true, L4.add("A"));
        assertEquals("[A]", L4.toString());
        assertEquals(true, L4.add("B"));
        assertEquals("[B, A]", L4.toString());
    }

    @Test
    @GradedTest(name = "Test add(int index, E elem)", max_score = 10)
    public void testAddIndexElem() {
        IDLList<String> L5 = new IDLList<String>();
        L5.add(0, "A");
        L5.add(1, "B");

        try {
            L5.add(-1, "C");
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        try {
            L5.add(3, "D");
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

		assertEquals(true, L5.add(0, "X"));
		assertEquals(true, L5.add(2, "Y"));
		assertEquals(true, L5.add(4, "Z"));

        try {
            L5.add(6, "W");
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

		assertEquals("[X, A, Y, B, Z]", L5.toString());
    }


    @Test
    @GradedTest(name = "Test append(E elem)", max_score = 10)
    public void testAppend() {
        IDLList<String> L6 = new IDLList<String>();

		assertEquals(true, L6.append("X"));
        assertEquals(true, L6.append("Y"));
		assertEquals("[X, Y]", L6.toString());

        assertEquals(true, L6.append("Z"));
        assertEquals("[X, Y, Z]", L6.toString());
    }


    @Test
    @GradedTest(name = "Test remove()", max_score = 10)
    public void testRemove() {
        IDLList<String> L71 = new IDLList<String>();        
        try {
            L71.remove();
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        String al7[] = new String[7];
		al7[0] = "A";
        al7[1] = "B";
        al7[2] = "C";
        al7[3] = "D";
        al7[4] = "E";
        al7[5] = "F";
        al7[6] = "G";
		IDLList<String> L72 = new IDLList<String>(al7);
		
		assertEquals("A", L72.remove());
        assertEquals("B", L72.remove());
		assertEquals("[C, D, E, F, G]", L72.toString());
    }


    @Test
    @GradedTest(name = "Test removeLast()", max_score = 10)
    public void testRemoveLast() {
        IDLList<String> L81 = new IDLList<String>();

        try {
            L81.removeLast();
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        String al8[] = new String[7];
		al8[0] = "A";
        al8[1] = "B";
        al8[2] = "C";
        al8[3] = "D";
        al8[4] = "E";
        al8[5] = "F";
        al8[6] = "G";
		IDLList<String> L82 = new IDLList<String>(al8);
		
		assertEquals("G", L82.removeLast());
        assertEquals("F", L82.removeLast());
		assertEquals("[A, B, C, D, E]", L82.toString());
    }


    @Test
    @GradedTest(name = "Test removeAt(int index)", max_score = 10)
    public void testRemoveAt() {
        IDLList<String> L91 = new IDLList<String>();

        try {
            L91.removeAt(1);
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }
	
        String al9[] = new String[7];
		al9[0] = "A";
        al9[1] = "B";
        al9[2] = "C";
        al9[3] = "D";
        al9[4] = "E";
        al9[5] = "F";
        al9[6] = "G";
		IDLList<String> L92 = new IDLList<String>(al9);

        try {
            L92.removeAt(-1);
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        try {
            L92.removeAt(10);
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }
		assertEquals("C", L92.removeAt(2));
		assertEquals("G", L92.removeAt(5));
		assertEquals("[A, B, D, E, F]", L92.toString());
    }


    @Test
    @GradedTest(name = "Test remove(E elem)", max_score = 10)
    public void testRemoveElem() {
        IDLList<String> L101 = new IDLList<String>();
        assertEquals(false, L101.remove("X"));

        String al10[] = new String[7];
		al10[0] = "A";
        al10[1] = "B";
        al10[2] = "C";
        al10[3] = "D";
        al10[4] = "E";
        al10[5] = "F";
        al10[6] = "G";
		IDLList<String> L102 = new IDLList<String>(al10);

		assertEquals(true, L102.remove("D"));
		assertEquals(true, L102.remove("A"));
        assertEquals(false, L102.remove("Y"));

		assertEquals("[B, C, E, F, G]", L102.toString());
	}
}