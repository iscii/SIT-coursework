import org.junit.Test;

import static org.junit.Assert.*;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.jh61b.junit.JUnitUtilities;



public class AssignmentTest {

    @Test
    @GradedTest(name = "Test BalancedParenTree's parse case 1", max_score = 5)
    public void test_parse1() {
    	try {
    		String testString = "()";
            BalancedParenTree bpt = new BalancedParenTree();
            bpt.parse(testString);
            assertEquals("()", bpt.toString());
            
            if(!("()".equals(bpt.toString()))) {
            	System.out.println(JUnitUtilities.get_error_message("", "()" , "()", 
            			bpt.toString()));
            }
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
    }

    @Test
    @GradedTest(name = "Test BalancedParenTree's parse case 2", max_score = 15)
    public void test_parse2() {
    	try {
    		String testString = "()()";
            BalancedParenTree bpt = new BalancedParenTree();
            bpt.parse(testString);
            
            if(!"()()".equals(bpt.toString())) {
            	System.out.println(JUnitUtilities.get_error_message("", "()()" , "()()", 
            			bpt.toString()));
            }
            
            assertEquals("()()", bpt.toString());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
    }

    @Test
    @GradedTest(name = "Test BalancedParenTree's parse case 3", max_score = 20)
    public void test_parse3() {
    	try {
    		String testString = "(())";
            BalancedParenTree bpt = new BalancedParenTree();
            bpt.parse(testString);
            
            if(!"(())".equals(bpt.toString())) {
            	System.out.println(JUnitUtilities.get_error_message("", "(())" , "(())", 
            			bpt.toString()));
            }
            
            assertEquals("(())", bpt.toString());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}    
    }

    @Test
    @GradedTest(name = "Test BalancedParenTree's parse case 4", max_score = 20)
    public void test_parse4() {
    	try {
    		String testString = "(())()";
            BalancedParenTree bpt = new BalancedParenTree();
            bpt.parse(testString);
            
            if(!"(())()".equals(bpt.toString())) {
            	System.out.println(JUnitUtilities.get_error_message("", "(())()" , "(())()", 
            			bpt.toString()));
            }
            
            assertEquals("(())()", bpt.toString());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
    }

    @Test
    @GradedTest(name = "Test BalancedParenTree's parse case 5", max_score = 20)
    public void test_parse5() {
    	try {
    		String testString = "(())()()";
            BalancedParenTree bpt = new BalancedParenTree();
            bpt.parse(testString);
            
            if(!"(())()()".equals(bpt.toString())) {
            	System.out.println(JUnitUtilities.get_error_message("", "(())()()" , 
            			"(())()()", bpt.toString()));
            }
            
            assertEquals("(())()()", bpt.toString());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
    }
    
    @Test
    @GradedTest(name = "Test BalancedParenTree's parse case 6", max_score = 20,
    visibility = "hidden")
    public void test_parse6() {
    	try {
    		String testString = "(((((((())))))))(((())))";
            BalancedParenTree bpt = new BalancedParenTree();
            bpt.parse(testString);
            
            if(!"(((((((())))))))(((())))".equals(bpt.toString())) {
            	System.out.println(JUnitUtilities.get_error_message("", "(((((((())))))))(((())))" , 
            			"(((((((())))))))(((())))", bpt.toString()));
            }
            
            assertEquals("(((((((())))))))(((())))", bpt.toString());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
    }
}
