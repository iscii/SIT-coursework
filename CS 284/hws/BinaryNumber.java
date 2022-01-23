import java.util.Arrays;

public class BinaryNumber {
	private int[] bin;
	private int length;

	// creates a binary number of length "length" and consisting only of zeros
	public BinaryNumber(int length) {
		if (length < 0) {
			System.out.println("not a valid length");
			return;
		}

		int[] temp = new int[length];
		for (int i = 0; i < length; i++) {
			temp[i] = 0;
		}

		bin = temp;
		length = bin.length;
	}

	// creates a binary number using a string
	public BinaryNumber(String str) {
		int[] temp = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
				case ('1'):
					temp[i] = 1;
					break;
				case ('0'):
					temp[i] = 0;
					break;
				default:
					System.out.println("not a valid binary number");
					return;
			}
		}

		bin = temp;
		length = bin.length;
	}

	// returns the length of a binary
	public int getLength() {
		return length;
	}

	// returns the integer array representing a binary number
	public int[] getInnerArray() {
		return bin;
	}

	// returns a digit of a binary number given an index.
	public int getDigit(int index) {
		return bin[index];
	}

	// returns a binary number in its decimal notation
	public int toDecimal() {
		int dec = 0;
		int j = 0;
		for (int i = bin.length - 1; i >= 0; i--) {
			dec += bin[j] * Math.pow(2, i);
			j++;
		}
		return dec;
	}

	// returns a binary number with all the digits shifted any number of places to
	// the left or right.
	// The direction parameter indicates:
	// a left shift when the value is -1, right shift when the value is 1
	public int[] bitShift(int direction, int amount) {
		if (!(direction == -1 || direction == 1) || amount < 0 || (direction == 1 && amount > bin.length)) {
			System.out.println("invalid parameters");
			return new int[] {};
		}
		if (direction == 1) {
			int[] temp = new int[bin.length - amount];
			int bl = bin.length - 1;
			for (int i = temp.length - 1; i >= 0; i--) {
				temp[i] = bin[bl];
				bl--;
			}
			return temp;
		}
		// dir == -1
		int[] temp = new int[bin.length + amount];
		int bl = bin.length - 1;
		for (int i = 0; i < bin.length; i++) {
			temp[i] = bin[bl];
			bl--;
		}
		return temp;
	}

	public static int[] prepend(int[] arr, int l) {
		int[] temp = new int[arr.length + l];
		int al = arr.length - 1;
		for (int i = temp.length - 1; i >= temp.length - arr.length; i--) {
			temp[i] = arr[al];
			al--;
		}
		return temp;
	}

	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			System.out.println("not the same lengths");
			return new int[] {};
		}
		int[] temp = new int[bn1.getLength()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = bn1.getInnerArray()[i] == 1 || bn2.getInnerArray()[i] == 1 ? 1 : 0;
		}
		return temp;
	}

	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			System.out.println("not the same lengths");
			return new int[] {};
		}
		int[] temp = new int[bn1.getLength()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = bn1.getInnerArray()[i] == 1 && bn2.getInnerArray()[i] == 1 ? 1 : 0;
		}
		return temp;
	}

	// needs work
	public void add(BinaryNumber aBinaryNumber) {
		// get larger binary number
		int[] big;
		int[] smol;
		// prepend zeros to smaller number to match larger number length
		if (bin.length > aBinaryNumber.getLength()) {
			System.out.println(Arrays.toString(aBinaryNumber.getInnerArray()));
			System.out.println(bin.length - aBinaryNumber.getLength());
			smol = BinaryNumber.prepend(aBinaryNumber.getInnerArray(), bin.length - aBinaryNumber.getLength());
			System.out.println(Arrays.toString(smol));
			big = bin.clone();
		} else if (bin.length < aBinaryNumber.getLength()) {
			smol = BinaryNumber.prepend(bin, aBinaryNumber.getLength() - bin.length);
			// System.out.println(aBinaryNumber.getLength() - bin.length);
			big = aBinaryNumber.getInnerArray().clone();
		} else {
			smol = bin.clone();
			big = aBinaryNumber.getInnerArray().clone();
		}
		System.out.println(Arrays.toString(smol));
		System.out.println(Arrays.toString(big));
		// create temp with +1 length (carry potential)
		int[] temp = new int[big.length + 1];
		int c = 0;
		// add and dump result into temp from right to left
		for (int i = temp.length - 2; i >= 0; i--) {
			temp[i + 1] = smol[i] + big[i] + c > 1 ? (smol[i] + big[i] + c) % 2 : smol[i] + big[i] + c;
			System.out.println(smol[i] + big[i]);
			System.out.println(c);
			System.out.println(smol[i] + big[i] + c);
			System.out.println();
			if (smol[i] + big[i] + c <= 1){
				System.out.println("no carry");
				c = 0;
			}
			else{
				c=1;
			}
		}
		if (c == 1) {
			temp[0] = c;
		}
		// purge leading 0s?
		// set bin = temp
		bin = temp;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < bin.length; i++) {
			temp += String.valueOf(bin[i]);
		}
		return temp;
	}
}