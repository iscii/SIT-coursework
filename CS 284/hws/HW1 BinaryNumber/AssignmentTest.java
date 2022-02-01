import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.jh61b.junit.JUnitUtilities;

import java.util.*; 

public class AssignmentTest {

    @Test
    @GradedTest(name = "Test Constructor", max_score = 10)
    public void testConstructor() {

        try{
            BinaryNumber bn1 = new BinaryNumber(4);

            if (bn1.toString().equals("0000") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "",
                    "length=4", 
                    "0000", 
                    bn1.toString()));
            }
            assertEquals("0000", bn1.toString());

            BinaryNumber bn2 = new BinaryNumber("1001");

            if (bn2.toString().equals("1001") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "",
                    "str='1001'", 
                    "1001", 
                    bn2.toString()));
            }
            assertEquals("1001", bn2.toString());

            BinaryNumber bn3 = new BinaryNumber("101010");

            if (bn3.toString().equals("101010") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "",
                    "str='101010'", 
                    "101010", 
                    bn3.toString()));
            }
            assertEquals("101010", bn3.toString());

            try {
                BinaryNumber bn4 = new BinaryNumber("9101010");

                System.out.println(JUnitUtilities.get_no_throw_message(
                    "",
                    "str='9101010'"));

                fail("Should have thrown an Exception");
            } catch (Exception e) {
                assertEquals(1, 1);
            }
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test getLength()", max_score = 10)
    public void testGetLength() {

        try{
            BinaryNumber bn1 = new BinaryNumber(4);

            if (bn1.getLength() != 4){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [0,0,0,0]",
                    "", 
                    4, 
                    bn1.getLength()));
            }

            assertEquals(4, bn1.getLength());

            BinaryNumber bn2 = new BinaryNumber("10011");

            if (bn2.getLength() != 5){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1,0,0,1,1]",
                    "", 
                    5, 
                    bn2.getLength()));
            }

            assertEquals(5, bn2.getLength());
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }


    @Test
    @GradedTest(name = "Test #1 getDigit(int index)", max_score = 5)
    public void testGetDigit1() {

        try{
            BinaryNumber bn2 = new BinaryNumber("1001");

            if (bn2.getDigit(2) != 0){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1,0,0,1]",
                    "index=2", 
                    0, 
                    bn2.getDigit(2)));
            }
            assertEquals(0, bn2.getDigit(2));
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }
        
    @Test
    @GradedTest(name = "Test #2 getDigit(int index)", max_score = 5)
    public void testGetDigit2() {

        try {
            BinaryNumber bn3 = new BinaryNumber("101010");
            bn3.getDigit(12);

            System.out.println(JUnitUtilities.get_no_throw_message(
                "this.bin = [1, 0, 1, 0, 1, 0]",
                "index=12"));

            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }
    }

    @Test
    @GradedTest(name = "Test #1 toDecimal()", max_score = 5)
    public void testToDecimal1() {
        try{
            BinaryNumber bn2 = new BinaryNumber("1001");

            if (bn2.toDecimal() != 9){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1, 0, 0, 1]",
                    "",
                    9, 
                    bn2.toDecimal()));
            }
            assertEquals(9, bn2.toDecimal());

            BinaryNumber bn3 = new BinaryNumber("101010");

            if (bn3.toDecimal() != 42){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1, 0, 1, 0, 1, 0]",
                    "",
                    42, 
                    bn3.toDecimal()));
            }
            assertEquals(42, bn3.toDecimal());
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test #2 toDecimal()", max_score = 5)
    public void testToDecimal2() {

            try{
            BinaryNumber bn6 = new BinaryNumber("1111111111111111111111111");

            if (bn6.toDecimal() != 33554431){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                    "",
                    33554431, 
                    bn6.toDecimal()));
            }
            assertEquals(33554431, bn6.toDecimal());

            BinaryNumber bn7 = new BinaryNumber("00000000000000000000000");

            if (bn7.toDecimal() != 0){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                    "",
                    0, 
                    bn7.toDecimal()));
            }
            assertEquals(0, bn7.toDecimal());

            BinaryNumber bn8 = new BinaryNumber(4);

            if (bn8.toDecimal() != 0){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [0, 0, 0, 0]",
                    "",
                    0, 
                    bn8.toDecimal()));
            }
            assertEquals(0, bn8.toDecimal());
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test #1 bitShift(int direction, int amount)", max_score = 5)
    public void testBitShift1() {

        try{
            BinaryNumber bn1 = new BinaryNumber(4);

            try {
                bn1.bitShift(-2, 2);

                System.out.println(JUnitUtilities.get_no_throw_message(
                    "this.bin = [0, 0, 0, 0]",
                    "direction=-1, amount=2"));

                fail("Should have thrown an Exception");
            } catch (Exception e) {
                assertEquals(1, 1);
            }

            try {
                bn1 = new BinaryNumber(4);
                bn1.bitShift(-1, -2);

                System.out.println(JUnitUtilities.get_no_throw_message(
                    "this.bin = [0, 0, 0, 0]",
                    "direction=-1, amount=-2"));

                fail("Should have thrown an Exception");
            } catch (Exception e) {
                assertEquals(1, 1);
            }

            try {
                bn1 = new BinaryNumber(4);
                bn1.bitShift(1, 5);

                System.out.println(JUnitUtilities.get_no_throw_message(
                    "this.bin = [0, 0, 0, 0]",
                    "direction=1, amount=5"));

                fail("Should have thrown an Exception");
            } catch (Exception e) {
                assertEquals(1, 1);
            }

        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test #2 bitShift(int direction, int amount)", max_score = 5)
    public void testBitShift2() {

        try{
            BinaryNumber bn2 = new BinaryNumber("1001");
            bn2.bitShift(-1, 2);

            if (bn2.toString().equals("100100") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1, 0, 0, 1]",
                    "direction=-1, amount=2",
                    "100100", 
                    bn2.toString()));
            }
            assertEquals("100100", bn2.toString());

            BinaryNumber bn3 = new BinaryNumber("101010");
            bn3.bitShift(1, 2);

            if (bn3.toString().equals("1010") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin = [1, 0, 1, 0, 1, 0]",
                    "direction=1, amount=2",
                    "1010", 
                    bn3.toString()));
            }
            assertEquals("1010", bn3.toString());
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test #1 bwor(BinaryNumber bn1, BinaryNumber bn2)", max_score = 5)
    public void testBwor1() {
        try{
            BinaryNumber bn1 = new BinaryNumber(4);
            BinaryNumber bn2 = new BinaryNumber("1001");
            BinaryNumber bn3 = new BinaryNumber("101010");

            BinaryNumber bn6 = new BinaryNumber("1111111111111111111111111");
            BinaryNumber bn7 = new BinaryNumber("00000000000000000000000");
            BinaryNumber bn8 = new BinaryNumber("1101110100101010101");
            BinaryNumber bn9 = new BinaryNumber("0000110001101010110");
        

            try {
                BinaryNumber.bwor(bn1, bn3);

                System.out.println(JUnitUtilities.get_no_throw_message(
                    "",
                    "bn1=0000, bn2=101010"));

                fail("Should have thrown an Exception");
            } catch (Exception e) {
                assertEquals(1, 1);
            }

            try {
                BinaryNumber.bwor(bn7, bn6);

                System.out.println(JUnitUtilities.get_no_throw_message(
                    "",
                    "bn1=1111111111111111111111111, bn2=00000000000000000000000"));

                fail("Should have thrown an Exception");
            } catch (Exception e) {
                assertEquals(1, 1);
            }

        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test #2 bwor(BinaryNumber bn1, BinaryNumber bn2)", max_score = 5)
    public void testBwor2() {

        try{

        BinaryNumber bn2 = new BinaryNumber("1001");
        BinaryNumber bn3 = new BinaryNumber("101010");

        BinaryNumber bn6 = new BinaryNumber("1111111111111111111111111");
        BinaryNumber bn7 = new BinaryNumber("00000000000000000000000");
        BinaryNumber bn8 = new BinaryNumber("1101110100101010101");
        BinaryNumber bn9 = new BinaryNumber("0000110001101010110");

        bn7 = new BinaryNumber("00000000000000000000000");
        bn6 = new BinaryNumber("11111111111111111111111");

        if (JUnitUtilities.list_to_str(BinaryNumber.bwor(bn7, bn6)).equals("11111111111111111111111") == false){
            System.out.println(JUnitUtilities.get_error_message(
                "",
                "bn1=00000000000000000000000, bn2=11111111111111111111111",
                "11111111111111111111111", 
                JUnitUtilities.list_to_str(BinaryNumber.bwor(bn7, bn6)))
            );
        }
        assertEquals("11111111111111111111111", 
            JUnitUtilities.list_to_str(BinaryNumber.bwor(bn7, bn6)));
        
        if (JUnitUtilities.list_to_str(BinaryNumber.bwor(bn8, bn9)).equals("1101110101101010111") == false){
            System.out.println(JUnitUtilities.get_error_message(
                "",
                "bn1=1101110100101010101, bn2=0000110001101010110",
                "1101110101101010111", 
                JUnitUtilities.list_to_str(BinaryNumber.bwor(bn8, bn9))));
        }
        assertEquals("1101110101101010111", JUnitUtilities.list_to_str(BinaryNumber.bwor(bn8, bn9)) );
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }

    }

    @Test
    @GradedTest(name = "Test #1 bwand(BinaryNumber bn1, BinaryNumber bn2)", max_score = 5)
    public void testBwand1() {
        try{
            BinaryNumber bn1 = new BinaryNumber(4);
            BinaryNumber bn2 = new BinaryNumber("1001");
            BinaryNumber bn3 = new BinaryNumber("101010");

            BinaryNumber bn6 = new BinaryNumber("1111111111111111111111111");
            BinaryNumber bn7 = new BinaryNumber("00000000000000000000000");
            BinaryNumber bn8 = new BinaryNumber("1101110100101010101");
            BinaryNumber bn9 = new BinaryNumber("0000110001101010110");

        try {
            BinaryNumber.bwand(bn1, bn3);

            System.out.println(JUnitUtilities.get_no_throw_message(
                "",
                "bn1=0000, bn2=101010"));

            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        try {
            BinaryNumber.bwand(bn7, bn6);

            System.out.println(JUnitUtilities.get_no_throw_message(
                "",
                "bn1=00000000000000000000000, bn2=1111111111111111111111111"));

            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

         }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test #2 bwand(BinaryNumber bn1, BinaryNumber bn2)", max_score = 5)
    public void testBwand2() {

        try{
            BinaryNumber bn1 = new BinaryNumber(4);
            BinaryNumber bn2 = new BinaryNumber("1001");
            BinaryNumber bn3 = new BinaryNumber("101010");

            BinaryNumber bn6 = new BinaryNumber("1111111111111111111111111");
            BinaryNumber bn7 = new BinaryNumber("00000000000000000000000");
            BinaryNumber bn8 = new BinaryNumber("1101110100101010101");
            BinaryNumber bn9 = new BinaryNumber("0000110001101010110");

            bn7 = new BinaryNumber("00000000000000000000000");
            bn6 = new BinaryNumber("11111111111111111111111");

            if (JUnitUtilities.list_to_str(BinaryNumber.bwand(bn7, bn6)).equals(
                "00000000000000000000000") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "",
                    "bn1=00000000000000000000000, bn2=11111111111111111111111",
                    "00000000000000000000000", 
                    JUnitUtilities.list_to_str(BinaryNumber.bwand(bn7, bn6))));
            }
            assertEquals("00000000000000000000000", 
                JUnitUtilities.list_to_str(BinaryNumber.bwand(bn7, bn6)) );
            
            if (JUnitUtilities.list_to_str(BinaryNumber.bwand(bn8, bn9)).equals(
                "0000110000101010100") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "",
                    "bn1=1101110100101010101, bn2=0000110001101010110",
                    "0000110000101010100", 
                    JUnitUtilities.list_to_str(BinaryNumber.bwand(bn8, bn9))));
            }
            assertEquals("0000110000101010100", 
                JUnitUtilities.list_to_str(BinaryNumber.bwand(bn8, bn9)) );
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }
    }

    @Test
    @GradedTest(name = "Test add(BinaryNumber aBinaryNumber)", max_score = 20)
    public void testAdd() {

        try
        {
            BinaryNumber bn1 = new BinaryNumber(4);
            BinaryNumber bn2 = new BinaryNumber("1001");
            BinaryNumber bn3 = new BinaryNumber("1010");

            BinaryNumber bn6 = new BinaryNumber("1111111111111111111111111");
            BinaryNumber bn7 = new BinaryNumber("00000000000000000000000");
            BinaryNumber bn8 = new BinaryNumber("1101110100101010101");
            BinaryNumber bn9 = new BinaryNumber("0000110001101010110");

        
            bn1.add(new BinaryNumber("11010"));

            if (bn1.toString().equals("11010") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin=[0,0,0,0]",
                    "aBinaryNumber=11010",
                    "11010", 
                    bn1.toString()));
            }

            assertEquals("11010", bn1.toString());

            bn1.add(bn3);

            if (bn1.toString().equals("100100") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin=[1, 1, 0, 1, 0]",
                    "aBinaryNumber=1010",
                    "100100", 
                    bn1.toString()));
            }
            assertEquals("100100", bn1.toString());

            bn1.add(bn6);

            if (bn1.toString().equals("10000000000000000000100011") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin=[1, 0, 0, 1, 0, 0]",
                    "aBinaryNumber=1111111111111111111111111",
                    "10000000000000000000100011", 
                    bn1.toString()));
            }
            assertEquals("10000000000000000000100011", bn1.toString());

            bn1.add(bn9);

            if (bn1.toString().equals("10000000000110001101111001") == false){
                System.out.println(JUnitUtilities.get_error_message(
                    "this.bin=[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1]",
                    "aBinaryNumber=0000110001101010110",
                    "10000000000110001101111001", 
                    bn1.toString()));
            }
            assertEquals("10000000000110001101111001", bn1.toString());
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }

    }

    @Test
    @GradedTest(name = "Test Hidden", max_score = 10, visibility = "hidden")
    public void testHiddenAdd() {
        try{
        BinaryNumber bn1 = new BinaryNumber("11010");
        BinaryNumber bn2 = new BinaryNumber("1010");

        bn1.add(new BinaryNumber("11101010"));
        assertEquals("100000100", bn1.toString());

        bn1.add(bn2);
        assertEquals("100001110", bn1.toString());

        assertEquals(270, bn1.toDecimal());

        try {
            BinaryNumber.bwand(bn1, new BinaryNumber("1"));
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        try {
            BinaryNumber.bwor(bn1, new BinaryNumber("1"));
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }

        try {
            bn1.getDigit(-1);
            fail("Should have thrown an Exception");
        } catch (Exception e) {
            assertEquals(1, 1);
        }
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            assertEquals(1, 0);
        }


    }

}