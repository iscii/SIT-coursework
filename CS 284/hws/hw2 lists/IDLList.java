import java.util.ArrayList;

public class IDLList<E> {
	//Properties of IDLList<E>:
	private ArrayList<Node<E>> indices;
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	//Inner class Node<E>
	private class Node<E> {
		//Properties of Node<E>:
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		//Constructor of Node<E>, given 'E' elem
		public Node(E elem) {
			this.data = elem;
			this.prev = null;
			this.next = null;
		}
		
		//Constructor of Node<E>, given 'E' elem, a link to the previous node, and
		//a link to the next node
		public Node(E elem, Node<E> prev, Node<E> next) {
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//Constructor of IDLList
	public IDLList() {
		this.indices = new ArrayList<Node<E>>();
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	
	//Constructor of IDLList
	public IDLList(E[] newIndices) {

		this.indices = new ArrayList<Node<E>>();
        if(newIndices.length>0){
            for(int i = 0; i<newIndices.length; i++){
                this.indices.add(new Node<E>(newIndices[i]));  
            }
            this.size = this.indices.size();
		    this.head = this.indices.get(0);
		    this.tail = this.indices.get(this.size - 1);

            for(int i = 0; i<newIndices.length;i++){
                if(i == 0){
                    this.indices.get(i).prev = null;
                    this.indices.get(i).next = this.indices.get(i+1);
                }
                else if(i == newIndices.length-1){
                    this.indices.get(i).prev = this.indices.get(i-1);
                    this.indices.get(i).next = null;
                }
                else{
                    this.indices.get(i).prev = this.indices.get(i-1);
                    this.indices.get(i).next = this.indices.get(i+1);
                }
            }
        }
        else{
            this.size = 0;
		    this.head = null;
		    this.tail = null;
        }
	}
	
	
	//Given an index, the .add() method adds a new node at the given index 
	public boolean add(int index, E elem) {
		if(index<0 || index>this.size) throw new IllegalStateException("index out of bounds");
		this.indices.add(index, new Node<E>(elem));
		this.size++;

		//refresh prev/nexts
		for(int i = 0; i<this.size;i++){
			if(i == 0){
				this.indices.get(i).prev = null;
				if(this.size>=2)
					this.indices.get(i).next = this.indices.get(i+1);
			}
			else if(i == this.size-1){
				this.indices.get(i).prev = this.indices.get(i-1);
				this.indices.get(i).next = null;
			}
			else{
				this.indices.get(i).prev = this.indices.get(i-1);
				this.indices.get(i).next = this.indices.get(i+1);
			}
		}

		return true;
	}
	
	//The .add() method adds a new node at the head
	public boolean add(E elem) {
		return this.add(0, elem);		
	}
	
	//The .append() method adds a new node at the tail
	public boolean append(E elem) {
		return this.add(this.size, elem);
	}

	//The .get() method returns the data of a node at the given index
	public E get(int index) {
		if(index<0 || index>=this.size) throw new IllegalStateException("index out of bounds");
		return this.indices.get(index).data;
	}
	
	//The .getHead() method returns the data of the node at the head
	public E getHead() {
		return this.size==0 ? null : this.get(0);
	}
		
	//The .getLast() method returns the data of the node at the tail
	public E getLast() {
		return this.size==0 ? null : this.get(this.size-1);
	}

	//The .remove() method removes the node at the head and returns the node's data
	public E remove() {
		if(this.size==0) throw new IllegalStateException("there's nothing to remove");
		E a = this.indices.remove(0).data;
		this.size--;
		return a;
	}	
	
	//The .removeLast() method removes the node at the tail and returns the node's data
	public E removeLast() {
		if(this.size==0) throw new IllegalStateException("there's nothing to remove");
		E a = this.indices.remove(this.size-1).data;
		this.size--;
		return a;
	}
		
	//Given an index, the .removeAt() method removes the node at the index and returns its data
	public E removeAt(int index) {
		if(index<0 || index>=this.size) throw new IllegalStateException("index out of bounds");
		E a = this.indices.remove(index).data;
		this.size--;

		//refresh prev/nexts
		for(int i = 0; i<this.size;i++){
			if(i == 0){
				this.indices.get(i).prev = null;
				if(this.size>=2)
					this.indices.get(i).next = this.indices.get(i+1);
			}
			else if(i == this.size-1){
				this.indices.get(i).prev = this.indices.get(i-1);
				this.indices.get(i).next = null;
			}
			else{
				this.indices.get(i).prev = this.indices.get(i-1);
				this.indices.get(i).next = this.indices.get(i+1);
			}
		}

		return a;
	}
	
	//Given an element to remove, the .remove() method removes the node that is the first instance
	//in which the data is found to be the same
	public boolean remove(E elem) {
		for (int i = 0; i < this.size; i++) {
			if(this.indices.get(i).data.equals(elem)){
				this.removeAt(i);
				return true;
			}
		}
		return false;
	}

	//The .size() method returns the size of the ArrayList
	public int size() {
		return this.size;
	}

	//Converts the ArrayList into a readible string of each Node's data
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		if (this.size > 0) {
			for (int i = 0; i < this.size; i++) {
				result.append(this.indices.get(i).data + ", ");
			}
			result.delete(result.length() - 2, result.length());
		}
		result.append("]");
		return result.toString();
	}
	
	public static void main(String[] args) {
		//get		
		System.out.println("GET");
		String al1[] = new String[4];
		al1[0] = "X";
        al1[1] = "Y";
        al1[2] = "Z";
        al1[3] = "W";
        		
		IDLList<String> L1 = new IDLList<String>(al1);
        System.out.println(L1.get(0) + ": true");
        System.out.println(L1.get(1) + ": true");
        System.out.println(L1.get(2) + ": true");
        System.out.println(L1.get(3) + ": true");

        try {
            L1.get(-1);
			System.out.println("exception test fail: " + L1);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }

        try {
			L1.get(10);
			System.out.println("exception test fail: " + L1);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }
		
		//gethead
		System.out.println("GETHEAD");
		IDLList<String> L21 = new IDLList<String>();
		System.out.println(L21.getHead() + ": null"); 
		
        String al2[] = new String[4];
		al2[0] = "X";
        al2[1] = "Y";
        al2[2] = "Z";
        al2[3] = "W";       		
		IDLList<String> L22 = new IDLList<String>(al2);
		System.out.println(L22.getHead() + ": X");
		
		//getlast
		System.out.println("GETLAST");
		IDLList<String> L31 = new IDLList<String>();
		System.out.println(L31.getLast() + ": null"); 

        String al3[] = new String[4];
		al3[0] = "X";
        al3[1] = "Y";
        al3[2] = "Z";
        al3[3] = "W";       		
		IDLList<String> L32 = new IDLList<String>(al3);
		System.out.println(L32.getLast() + ": W");

		//add (unshift)
		System.out.println("ADD");
		IDLList<String> L4 = new IDLList<String>();
		System.out.println(L4.add("A") + ": true");
		System.out.println(L4 + ": [A]");
		System.out.println(L4.add("B") + ": true");
		System.out.println(L4 + ": [B, A]");
		
		
		//add index
		System.out.println("ADD INDEX");
		IDLList<String> L5 = new IDLList<String>();
        L5.add(0, "A");
        L5.add(1, "B");

        try {
            L5.add(-1, "C");
			System.out.println("exception test fail: " + L5);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }
		
        try {
			L5.add(3, "D");
			System.out.println("exception test fail: " + L5);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }
		
		System.out.println(L5.add(0, "X") + ": true");
		System.out.println(L5.add(2, "Y") + ": true");
		System.out.println(L5.add(4, "Z") + ": true");
		
        try {
			L5.add(6, "W");
			System.out.println("exception test fail: " + L5);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }
		
		System.out.println(L5 + ": [X, A, Y, B, Z]");
		
		//append
		System.out.println("APPEND");
		IDLList<String> L6 = new IDLList<String>();
		
		System.out.println(L6.append("X") + ": true");
		System.out.println(L6.append("Y") + ": true");
		System.out.println(L6 + ": [X, Y]");
		
		System.out.println(L6.append("Z") + ": true");
		System.out.println(L6 + ": [X, Y, Z]");
		
		//remove
		System.out.println("REMOVE");
		IDLList<String> L71 = new IDLList<String>();        
        try {
            L71.remove();
			System.out.println("exception test fail: " + L71);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
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
		
		System.out.println(L72.remove() + ": A");
		System.out.println(L72.remove() + ": B");
		System.out.println(L72 + ": [C, D, E, F, G]");
		
		//remove last
		System.out.println("REMOVE LAST");
		IDLList<String> L81 = new IDLList<String>();
		
        try {
            L81.removeLast();
			System.out.println("exception test fail: " + L81);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
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
		
		System.out.println(L82.removeLast() + ": G");
		System.out.println(L82.removeLast() + ": F");
		System.out.println(L82 + ": [A, B, C, D, E]");
		
		//remove at
		System.out.println("REMOVE AT");
		IDLList<String> L91 = new IDLList<String>();
		
        try {
            L91.removeAt(1);
			System.out.println("exception test fail: " + L91);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
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
			System.out.println("exception test fail: " + L91);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }
		
        try {
			L92.removeAt(10);
			System.out.println("exception test fail: " + L91);
        } catch (Exception e) {
			System.out.println("exception test pass: " + e);
        }


		System.out.println(L92.removeAt(2) + ": C");
		System.out.println(L92.removeAt(5) + ": G");
		System.out.println(L92 + ": [A, B, D, E, F]");

		//remove elem
		System.out.println("REMOVE ELEM");
		IDLList<String> L101 = new IDLList<String>();
		System.out.println(L101.remove("X") + ": false");

        String al10[] = new String[7];
		al10[0] = "A";
        al10[1] = "B";
        al10[2] = "C";
        al10[3] = "D";
        al10[4] = "E";
        al10[5] = "F";
        al10[6] = "G";
		IDLList<String> L102 = new IDLList<String>(al10);

		System.out.println(L102.remove("D") + ": true");
		System.out.println(L102.remove("A") + ": true");
		System.out.println(L102.remove("Y") + ": false");

		System.out.println(L102 + ": [B, C, E, F, G]");
	}
}
