import java.util.Arrays;

public class BinaryNumber {
	private int[] bin;
	//private int length;

	// creates a binary number of length "length" and consisting only of zeros
	public BinaryNumber(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("not a valid length");
		}

		int[] temp = new int[length];
		for (int i = 0; i < length; i++) {
			temp[i] = 0;
		}

		bin = temp;
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
					throw new IllegalArgumentException("not a valid binary number");
			}
		}

		bin = temp;
	}

	// returns the length of a binary
	public int getLength() {
		return bin.length;
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
	public void bitShift(int direction, int amount) {
		if (!(direction == -1 || direction == 1) || amount < 0) {
			throw new IllegalArgumentException("invalid parameters");
		}
		if (direction == 1) {
			int[] temp = new int[bin.length - amount];
			int bl = bin.length - 1;
			for (int i = temp.length - 1; i >= 0; i--) {
				temp[i] = bin[bl];
				bl--;
			}
			bin = temp;
		}
		// dir == -1
		int[] temp = new int[bin.length + amount];
		int bl = bin.length - 1;
		for (int i = 0; i < bin.length; i++) {
			temp[i] = bin[bl];
			bl--;
		}
		bin = temp;
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
			throw new IllegalArgumentException("not the same lengths");
		}
		int[] temp = new int[bn1.getLength()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = bn1.getInnerArray()[i] == 1 || bn2.getInnerArray()[i] == 1 ? 1 : 0;
		}
		return temp;
	}

	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			throw new IllegalArgumentException("not the same lengths");
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
			smol = BinaryNumber.prepend(aBinaryNumber.getInnerArray(), bin.length - aBinaryNumber.getLength());
			big = bin.clone();
		} else if (bin.length < aBinaryNumber.getLength()) {
			smol = BinaryNumber.prepend(bin, aBinaryNumber.getLength() - bin.length);
			big = aBinaryNumber.getInnerArray().clone();
		} else {
			smol = bin.clone();
			big = aBinaryNumber.getInnerArray().clone();
		}
		int[] temp = new int[big.length + 1];
		int c = 0;
		// add and dump result into temp from right to left
		for (int i = temp.length - 2; i >= 0; i--) {
			temp[i + 1] = smol[i] + big[i] + c > 1 ? (smol[i] + big[i] + c) % 2 : smol[i] + big[i] + c;
			if (smol[i] + big[i] + c <= 1) {
				c = 0;
			} else {
				c = 1;
			}
		}
		if (c == 1) {
			temp[0] = c;
		}
		// purge leading 0s
		// find index of first 1
		int idx = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1)
				break;
			idx++;
		}
		if (idx > 0) {
			int[] temp2 = new int[temp.length - idx];
			for (int i = 0; i < temp.length - idx; i++) {
				temp2[i] = temp[i + idx];
			}
			bin = temp2;
		} else {
			bin = temp;
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < bin.length; i++) {
			temp += String.valueOf(bin[i]);
		}
		return temp;
	}
}
