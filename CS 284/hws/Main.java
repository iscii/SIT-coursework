import java.util.Arrays;

class Main{
    public static void main(String args[]){
        BinaryNumber a = new BinaryNumber(5);
        BinaryNumber b = new BinaryNumber("1011");
        //BinaryNumber err = new BinaryNumber("1021");
        /* System.out.println(a.getLength());
        System.out.println(b.getLength());
        System.out.println(Arrays.toString(a.getInnerArray()));
        System.out.println(Arrays.toString(b.getInnerArray()));
        System.out.println(a.getDigit(2));
        System.out.println(b.getDigit(2));
        System.out.println(a.toDecimal());
        System.out.println(b.toDecimal());
        System.out.println(Arrays.toString(a.bitShift(1, 1)));
        System.out.println(Arrays.toString(b.bitShift(1, 2)));
        System.out.println(Arrays.toString(b.bitShift(1, 3)));
        System.out.println(Arrays.toString(b.bitShift(1, 4)));
        System.out.println(Arrays.toString(b.bitShift(-1, 4)));
        System.out.println(Arrays.toString(b.bitShift(-1, 3)));
        System.out.println(Arrays.toString(b.bitShift(-1, 2)));
        System.out.println(Arrays.toString(b.bitShift(-1, 1))); */
        //BinaryNumber c = new BinaryNumber("10101");
        BinaryNumber d = new BinaryNumber("1001");
        /* BinaryNumber e = new BinaryNumber("0101");
        BinaryNumber f = new BinaryNumber("10110");
        BinaryNumber g = new BinaryNumber("11101");
        BinaryNumber h = new BinaryNumber("01101");
        BinaryNumber i = new BinaryNumber("01001"); */
        
        /* System.out.println(Arrays.toString(BinaryNumber.bwor(b,c)));
        System.out.println(Arrays.toString(BinaryNumber.bwor(d,e)));
        System.out.println(Arrays.toString(BinaryNumber.bwand(b,c)));
        System.out.println(Arrays.toString(BinaryNumber.bwand(d,e)));
        System.out.println(Arrays.toString(BinaryNumber.prepend(b.getInnerArray(), 2))); */

        /* a.add(b);
        b.add(c);
        //System.out.println(Arrays.toString(a.getInnerArray()));
        //System.out.println(Arrays.toString(b.getInnerArray()));
        f.add(g);
        System.out.println(f);
        h.add(i);
        System.out.println(h);  */
        System.out.println(Arrays.toString(d.bitShift(-1 ,2)));
    }
}