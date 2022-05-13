import java.util.LinkedList;

/** the bar consists of 3 data fields:
* 1. bar type, which is either stone or salt;
* 2. height , which is a positive integer of the bar, you may assume all stone bars have unique heights; 
* 3. next, which points to the next bar;
*/
class Bar { 
		
	String type;
	Integer height; 
	Bar next;

	public Bar(String barType , Integer barHeight) {
	    type = barType; 
		height = barHeight;
	} 
	public String toString(){
		return "(" + this.type + ", " + this.height + ")";
	}
}

public class LinkedListofBar {
	
	Bar head; // the head of the linked list
	public LinkedListofBar(Bar newHead) {
		this.head = newHead;
	}
	
	/**
	* get the water mass and concentration of the pool
	* @return an array {waterMass, concentration}, where waterMass is
	* the mass of water in the pool, and concentration = saltMass / waterMass */
	public double[] fillInWater() {
		
		if (this.head == null) 
			return new double [] {};	
		findTallest(this.head);	
		findSecondTallest(this.head);
		return computeMassAndConcentration();
	}
	
	
	/** step 1: finding the height and the pointer 
	 *  to the tallest bar
	 */
	Bar tallestNode = null; // the reference to the tallest node;
	int tallestIdx = -1; // the index of the tallest node in the linked list; 
	int topHeight = -1; // the height of the tallest node;
	
	public void findTallest(Bar node) {
	
		/** You can use the while loop to compute:
		 * 1. topHeight: an integer variable declared above which is the height of the tallest node , e.g., 5;
		 * 2. tallestNode: a Bar object declared above referencing the tallest node;
		 * 3. tallestIdx: an integer variable declared above which is the index of the tallest node , e.g., 1;
		 */
		//find tallest stone bar
		Bar currn = node;
		int idx = 0;
		tallestNode = currn;
		topHeight = tallestNode.height;
		//doesn't account for all edge cases (ie when tallest & second tallest r equal height)
		while(currn.next != null){
			idx++;
			if(currn.next.type.equals("stone") && currn.next.height > tallestNode.height){
				tallestNode = currn.next;
				topHeight = tallestNode.height;
				tallestIdx = idx;
			}
			currn = currn.next;
		}
	}
	
	
	/** step 2: finding the height and the pointer to the 2nd tallest bar
	 */
	Bar secondTallestNode = null; // the reference to the 2nd tallest node;
	int secondTallestIdx = -1; // the index of the 2nd tallest node in the linked list; 
	int secondHeight = -1; // the height of the second tallest node;
	
	public void findSecondTallest(Bar node) {
		/**  You can use the while loop to compute:
		* 1. secondheight: an integer variable declared above which is the height of the 2nd tallest node , e.g., 4;
		* 2. secondTallestNode: the Bar object declared above referencing the 2nd tallest node;
		* 3. secondTallestIdx: an integer variable declared above which is the index of the 2nd tallest node , e.g., 5;
		*/
		Bar currn = node;
		int idx = 0;
		secondTallestNode = currn;
		secondTallestIdx = 0;
		secondHeight = tallestNode.height;
		//doesn't account for all edge cases (ie when tallest & second tallest r equal height)
		while(currn.next != null){
			idx++;
			if(currn.next != tallestNode && currn.next.type.equals("stone") && currn.next.height > secondTallestNode.height){
				secondTallestNode = currn.next;
				secondHeight = secondTallestNode.height;
				secondTallestIdx=idx;
			}
			currn=currn.next;
		}
	}


	/** step 3: compute the water mass and the concentration of the salt water pool
	 * @return the water mass and the concentration in the form of list
	 */
	public double[] computeMassAndConcentration() { 
		//mass
		int idxdiff = Math.abs(this.tallestIdx-this.secondTallestIdx)-1;
		int cstone = 0, csalt = 0, idx = 0;
		Bar currn = this.tallestIdx < this.secondTallestIdx ? this.tallestNode : this.secondTallestNode;
		while(idx < idxdiff){
			cstone += currn.next.type.equals("stone") ? currn.next.height : 0;
			csalt += currn.next.type.equals("salt") ? currn.next.height : 0;
			currn = currn.next;
			idx++;
		}
		int m = this.secondHeight * idxdiff - cstone;

		return new double[]{m, (float)csalt/m};
	}

	public String toString(){
		Bar b = head;
		String s = b.toString();
		while(b.next != null){
			b = b.next;
			s += " -> " + b.toString();
		}
		return s;
	}

	public static void test(){
		Bar a = new Bar("stone", 2);
		Bar b = new Bar("stone", 5);
		Bar c = new Bar("stone", 1);
		Bar d = new Bar("salt", 2);
		Bar e = new Bar("salt", 1);
		Bar f = new Bar("stone", 4);
		Bar g = new Bar("stone", 3);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		e.next=f;
		f.next=g;
		LinkedListofBar l = new LinkedListofBar(a);
		
		Bar a1 = new Bar("stone", 2);
		Bar b1 = new Bar("stone", 3);
		Bar c1 = new Bar("stone", 1);
		Bar d1 = new Bar("salt", 2);
		Bar e1 = new Bar("salt", 1);
		Bar f1 = new Bar("stone", 4);
		a1.next=b1;
		b1.next=c1;
		c1.next=d1;
		d1.next=e1;
		e1.next=f1;
		LinkedListofBar l2 = new LinkedListofBar(a1);

		//test find tallest
		System.out.println(l);
		l.findTallest(a);
		System.out.println("tallest1: " + l.tallestNode + " " + l.tallestIdx);
		l.findSecondTallest(a);
		System.out.println("scndtallest1: " + l.secondTallestNode + " " + l.secondTallestIdx);

		System.out.println(l2);
		l2.findTallest(a1);
		System.out.println("tallest2: " + l2.tallestNode + " " + l2.tallestIdx);
		l2.findSecondTallest(a1);
		System.out.println("scndtallest2: " + l2.secondTallestNode + " " + l2.secondTallestIdx);

		//test compute
		System.out.println("mass: " + l.computeMassAndConcentration()[0] + ", concentration: " + l.computeMassAndConcentration()[1]);
		System.out.println("mass: " + l2.computeMassAndConcentration()[0] + ", concentration: " + l2.computeMassAndConcentration()[1]);
	}

	public static void main(String[] args){
		test();
	}
}