import java.util.Map;

public class BinaryNumber {
	private int[] bin;

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
	}

	// creates a binary number using a string
	public BinaryNumber(String str) {
		int[] temp = new int[str.length()];
		for (int i = 0; i < str.length() - 1; i++) {
			String c = str.substring(i, i + 1);
			switch (c) {
				case ("1"):
					temp[i] = 1;
					break;
				case ("0"):
					temp[i] = 0;
					break;
				default:
					System.out.println("not a valid binary number");
					return;
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
		for (int i = bin.length - 1; i >= 0; i--) {
			dec += bin[i] * Math.pow(2, i);
		}
		return dec;
	}

	// returns a binary number with all the digits shifted any number of places to
	// the left or right.
	// The direction parameter indicates:
	// a left shift when the value is -1, right shift when the value is 1
	public int[] bitShift(int direction, int amount) {
		if ((direction != 1 && direction != 0) || amount < 0) {
			System.out.println("not a valid direction");
			return new int[] {};
		}
		if (direction == 1) {
			int[] temp = new int[bin.length - amount];
			int bl = bin.length;
			for (int i = temp.length - 1; i >= 0; i--) {
				temp[i] = bin[bl];
				bl--;
			}
			return temp;
		}
		// dir == -1
		int[] temp = new int[bin.length + amount];
		int bl = bin.length;
		for (int i = temp.length; i > bin.length; i--) {
			temp[i] = bin[bl];
			bl--;
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

	public void add(BinaryNumber aBinaryNumber) {
		int[] temp = bin.clone();
		int[] other = aBinaryNumber.getInnerArray();
		int c = 0; // carry
		for (int i = 0; i < other.length; i++) {
			if (i == other.length - 1 && c == 1) {
				int[] temp2 = new int[temp.length + 1];
				temp2[0] = 1;
				for (int j = 0; j < temp.length; j++) {
					temp2[j + 1] = temp[j];
				}
				temp = temp2;
				break;
			}
			temp[i] = temp[i] + other[i] + c > 1 ? temp[i] + other[i] + c % 2 : temp[i] + other[i] + c;
			c = 0;
			if (temp[i] + other[i] > 1) {
				c = 1;
			}
		}
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
