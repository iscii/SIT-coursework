


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* Class AVLNode */
class HeapNode<S extends Comparable<S>, T extends Comparable<T>>{
	S value1;
	T value2;
	
	public HeapNode(S value1, T value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	/**
     * TODO: implement this function to compare two heap node
     * @param new_node
     * @return 1 if this node is larger than new_node
     * 		   0 if this node is equal to new_node
     * 		   -1 if this node is smaller than new_node
     */
    public int compareHeapNode(S new_value1, T new_value2) {
		if(this.value2.compareTo(new_value2) == 0) return 0;
		if(this.value2.compareTo(new_value2) < 0) return -1;
		return 1;
    }
    
    public int compareHeapNode(HeapNode<S, T> other_node) {
    	return compareHeapNode(other_node.value1, other_node.value2);
    }
    
    @Override
    public String toString() {
    	return value1.toString() + "_" + value2.toString();
    }
}

class AVLNode<S extends Comparable<S>, T extends Comparable<T>> extends HeapNode
{    
    AVLNode l_child, r_child;
    int height;

    /* Constructor */
    public AVLNode(S value1, T value2)
    {
    	super(value1, value2);
        l_child = null;
        r_child = null;
        height = 0;
    }   
   
    /**
     * TODO: implement this function to compare two AVL node
     * @param new_node
     * @return 1 if this node is larger than new_node
     * 		   0 if this node is equal to new_node
     * 		   -1 if this node is smaller than new_node
     */
    public int compareAVLNode(S new_value1, T new_value2) {
		if(this.value1.compareTo(new_value1) == 0) return 0;
		if(this.value1.compareTo(new_value1) < 0) return -1;
		return 1;
    }

}

/* Class AVLTree */
class AVLTree<S extends Comparable<S>, T extends Comparable<T>>
{
    private AVLNode root;     

    /* Constructor */
    public AVLTree()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root = null;
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    
    /* Function to insert data */
    public void insert(S value1, T value2)
    {
        root = insertNode(value1, value2, root);
    }
    
    /* Function to insert data recursively */
    public AVLNode insertNode(S value1, T value2, AVLNode root)
    {
        if (root == null)
            root = new AVLNode(value1, value2);
        
        else if (root.compareAVLNode(value1, value2) > 0) 
        {
            root.l_child = insertNode( value1, value2, root.l_child ); 
            int balance = getBalance(root);
            
            if( balance == -2 )  {
           	 
                if( root.l_child.compareAVLNode(value1, value2) > 0 ) {  
                    root = rotateRight( root );    
                    
                }
                else
                    root = doubleRotation_left_right( root );
            }
        }
 
        else if( root.compareAVLNode(value1, value2) < 0 )                 
        {   
            root.r_child = insertNode( value1, value2, root.r_child );     
            int balance = getBalance(root);

            if( balance == 2 )   
           	 
                if( root.r_child.compareAVLNode(value1, value2) < 0) {
                    root = rotateLeft( root );  
                }
                else
                    root = doubleRotation_right_left( root );          
        }
        else;  
        root.height = max( height( root.l_child ), height( root.r_child ) ) + 1;   // update the height of the current node t
        return root;
    }
    /* Rotate binary tree node with left child */     
    private AVLNode rotateRight(AVLNode root)
    {
        AVLNode tmp = root.l_child;
        root.l_child = tmp.r_child;
        tmp.r_child = root;
        
        root.height = max( height( root.l_child ), height( root.r_child ) ) + 1;
        tmp.height = max( height( tmp.l_child ), root.height ) + 1;
        return tmp;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateLeft(AVLNode root)
    {
        AVLNode tmp = root.r_child;
        root.r_child = tmp.l_child;
        tmp.l_child = root;
        root.height = max( height( root.l_child ), height( root.r_child ) ) + 1;
        tmp.height = max( height( tmp.r_child ), root.height ) + 1;
        return tmp;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleRotation_left_right(AVLNode root)
    {
        root.l_child = rotateLeft( root.l_child );
        return rotateRight( root );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private AVLNode doubleRotation_right_left(AVLNode root)
    {
        root.r_child = rotateRight( root.r_child );
        return rotateLeft( root );
    }    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.l_child);
            l += countNodes(r.r_child);
            return l;
        }
    }
    
    public AVLNode search(S value1, T value2)
    {
    	AVLNode new_root = root;
        while ((root != null))
        {
            if (root.compareAVLNode(value1, value2) > 0)
                root = root.l_child;
            else if (root.compareAVLNode(value1, value2) < 0)
                root = root.r_child;
            else
            {
                return root;
            }
        }
        return null;
    }
    
    public int getBalance(AVLNode root) {
   	 if (root == null)
   		 return 0;
   	 return height(root.r_child) - height(root.l_child);
    }
    
    public AVLNode deleteNode(S value1, T value2) {
    	return this.deleteNode(value1, value2, root);
    }
    
    public AVLNode deleteNode(S value1, T value2, AVLNode root)  
    {  
        if (root == null)  
            return root;  
  
        if (root.compareAVLNode(value1, value2) > 0)  
            root.l_child = deleteNode(value1, value2, root.l_child);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (root.compareAVLNode(value1, value2) < 0)  
            root.r_child = deleteNode(value1, value2, root.r_child);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else
        {  
  
            // node with only one child or no child  
            if ((root.l_child == null) || (root.r_child == null))  
            {  
                if (root.l_child == null)  
                    root = root.r_child;  
                else
                    root = root.l_child;  
            }  
            else
            {  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
           	 	AVLNode right = minValueNode(root.r_child);  
  
                // Copy the inorder successor's data to this node  
                root.value1 = right.value1;
                root.value2 = right.value2;
  
                // Delete the inorder successor  
                root.r_child = deleteNode(value1, value2, root.r_child);  
            }  
        }  
        
        if (root == null)  
            return root;  
  
        root.height = max(height(root.l_child), height(root.r_child)) + 1;  
  
        int balance = getBalance(root);  
        
     // if after the deletion, the tree becomes unbalanced
        if (balance == 2) {
       	 int rchild_balance = getBalance(root.r_child);
       	 // right-right tree
       	 if (rchild_balance >= 0)
       		 return rotateLeft(root);
       	 // right-left tree
       	 else
       		 return doubleRotation_right_left(root);
        }
  
     // if after the deletion, the tree becomes unbalanced
        if (balance == -2) {
       	 int lchild_balance = getBalance(root.l_child);
       	 // left-left tree
       	 if (lchild_balance <= 0)  
       		 return rotateRight(root);
       	 // left-right tree
       	 else
       		 return doubleRotation_left_right(root); 
        }      
  
        return root;  
    }  
    
    AVLNode minValueNode(AVLNode node)  
    {  
   	 AVLNode current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.l_child != null)  
        current = current.l_child;  
  
        return current;  
    }    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    public void preOrderTraverse(AVLNode node, int depth,
            StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.value1 + "_" + node.value2);
            sb.append("\n");
            preOrderTraverse(node.l_child, depth + 1, sb);
            preOrderTraverse(node.r_child, depth + 1, sb);
        }
    }
}

class MaxHeap<S extends Comparable<S>, T extends Comparable<T>> {
	  private int capacity;
	  private int size = 0;
	  private HeapNode<S, T>[] heap;
	  
	  public void set_array(HeapNode<S, T>[] new_array) {
	    this.heap = new_array;
	    this.capacity = heap.length;
	    this.size = heap.length;
	  }

	  public MaxHeap(int capacity) {
	    this.capacity = capacity;
	    this.heap = new HeapNode[capacity];
	  }

	  private int getLeftChildIndex(int parentIndex) {
	    return 2 * parentIndex + 1;
	  }

	  private int getRightChildIndex(int parentIndex) {
	    return 2 * parentIndex + 2;
	  }

	  private int getParentIndex(int childIndex) {
	    return (childIndex - 1) / 2;
	  }

	  private boolean hasLeftChild(int index) {
	    return getLeftChildIndex(index) < size;
	  }

	  private boolean hasRightChild(int index) {
	    return getRightChildIndex(index) < size;
	  }

	  private boolean hasParent(int index) {
	    return getParentIndex(index) >= 0;
	  }

	  private HeapNode<S, T> leftChild(int parentIndex) {
	    return heap[getLeftChildIndex(parentIndex)];
	  }

	  private HeapNode<S, T> rightChild(int parentIndex) {
	    return heap[getRightChildIndex(parentIndex)];
	  }

	  private HeapNode<S, T> parent(int childIndex) {
	    return heap[getParentIndex(childIndex)];
	  }

	  private void swap(int index1, int index2) {
	    HeapNode<S, T> element = heap[index1];
	    heap[index1] = heap[index2];
	    heap[index2] = element;
	  }

	  /**
	   * Insertion an item in the heap
	   * (1) Attach the item to the last node
	   * (2) Heapify it up, so it meets the 
	   * requirement of a heap
	   * Time complexity: O(log n)
	   */
	  public void add(HeapNode<S, T> item) {
	    ensureCapacity();
	    heap[size] = item;
	    size++;
	    heapifyUp();
	  }

	  private void ensureCapacity() {
	    if (size == capacity) {
	      heap = Arrays.copyOf(heap, capacity * 2);
	      capacity = capacity * 2;
	    }
	  }

	  /** get the root element
	   * Time Complexity : O(1)
	   * @return
	   */
	  public HeapNode<S, T> peek() {
	    if (size == 0) {
	      throw new NoSuchElementException();
	    }
	    return heap[0];
	  }

	  /**
	   * Removal of the root node at the heap
	   * (1) Remove and place last element at root
	   * (2) Heapify down the root element, so it
	   * meets the requirement of a heap
	   * Time complexity: O(log n)
	   */
	  public HeapNode poll() {
	    if (size == 0) {
	      throw new NoSuchElementException();
	    }
	    
	    HeapNode element = heap[0];

	    heap[0] = heap[size - 1];
	    size--;
	    heapifyDown(0);
	    
	    return element;
	  }

	  /** heapify down: "trickle" elements down, 
	   * every time, swap it with the larger child, 
	   * until the tree is heapified
	   *  
	   */
	  private void heapifyDown(int index) {

	    while (hasLeftChild(index)) {
	      int largerChildIndex = getLeftChildIndex(index);

	      if (hasRightChild(index) && rightChild(index).compareHeapNode(leftChild(index)) > 0) {
	        largerChildIndex = getRightChildIndex(index);
	      }

	      if (heap[index].compareHeapNode(heap[largerChildIndex]) < 0) {
	        swap(index, largerChildIndex);
	      } else {
	        break;
	      }
	      index = largerChildIndex;
	    }
	  }

	  /** heapify up: swap a leaf element up
	   *  if it is larger than parent, until 
	   *  the tree is heapified
	   */
	  private void heapifyUp() {
	    int index = size - 1;

	    while (hasParent(index) && parent(index).compareHeapNode(heap[index]) < 0) {
	      swap(getParentIndex(index), index);
	      index = getParentIndex(index);
	    }
	  }
	  
	  /** heapify all: heapify the entire
	   * tree (not just one path) backward
	   * by finding all tuples (parent, left
	   * child, right child), swap parent
	   * with its larger child, and heapify
	   * down the swapped element
	   */
	  private void heapifyAll() {
	    
	    int[] visited = new int[this.heap.length];
	    
	    for (int i = this.heap.length - 1; i >= 0; i --) {
	      
	      int parentIdx = this.getParentIndex(i);
	      
	      if (parentIdx == i)
	        continue;
	      
	      if (visited[i] == 1) continue;
	      
	      int leftChildIdx = this.getLeftChildIndex(parentIdx);
	      int rightChildIdx = this.getRightChildIndex(parentIdx);
	      
	      if (this.heap[leftChildIdx].compareHeapNode(this.heap[rightChildIdx]) > 0) {
	        swap(leftChildIdx, parentIdx);
	        heapifyDown(leftChildIdx);
	      }
	      else {
	        swap(rightChildIdx, parentIdx);
	        heapifyDown(rightChildIdx);
	      }
	      
	      visited[leftChildIdx] = 1;
	      visited[rightChildIdx] = 1;
	    }   
	  }
	  
	  /** heap sort: (1) heapify the input array
	   * (2) for i= length...0
	   * remove the i-th smallest element, and
	   * append it to the length - i-th position
	   * @param array
	   */
	  private void heapSort(HeapNode<S, T>[] array) {
	    
	    this.set_array(array);
	    
	    this.heapifyAll();
	    
	    for (int i = this.heap.length - 1; i >= 0; i --) {
	      
	      HeapNode<S, T> next_element = this.peek();
	      this.poll();
	      this.heap[i] = next_element;
	    }
	    
	    this.size = this.heap.length;
	  }

	  private void printHeap() {
	    for (int i = 0; i < size; i++) {
	      System.out.print(heap[i].toString() + " ");
	    }
	  }
	  
	  @Override
	  public String toString() {
	      StringBuilder sb = new StringBuilder();
	      preOrderTraverse(0, 1, sb);
	      return sb.toString();
	  }


	  /**
	   * Perform a preorder traversal.
	   * @param node The local root
	   * @param depth The depth
	   * @param sb The string buffer to save the output
	   */
	  private void preOrderTraverse(int node_idx, int depth,
	          StringBuilder sb) {
	      for (int i = 1; i < depth; i++) {
	          sb.append("  ");
	      }
	      int left_child_idx = getLeftChildIndex(node_idx);
	      int right_child_idx = getRightChildIndex(node_idx);
	      
	      if (node_idx >= this.size) {
	          sb.append("null\n");
	      } else {
	          sb.append(this.heap[node_idx].toString());
	          sb.append("\n");
	          preOrderTraverse(left_child_idx, depth + 1, sb);
	          preOrderTraverse(right_child_idx, depth + 1, sb);
	      }
	  }
	}

public class GPADatabase {
	MaxHeap this_heap;
	AVLTree this_avltree;
	

	/**
	 * TODO: implement the constructor to initialize this_heap and this_avltree;
	 * @param size: the size of this_heap;
	 */
	public GPADatabase(int size) {
		this.this_heap = new MaxHeap(size);
		this.this_avltree = new AVLTree();
	}	
	
	
	/**
	 * TODO: implement this function to insert the student with student_name and gpa in the database
	 * @param student_name
	 * @param gpa
	 * 
	 */
	public void insertStudent(String student_name, Double gpa) {
		this.this_avltree.insert(student_name, gpa);
		this.this_heap.add(new HeapNode(student_name, gpa));
	}
	
	/**
	 * TODO: implement this function to remove the top k students from this database (from both the avl tree and the heap)
	 * @param k
	 * @return the names of the top k students, sorted by the descending order of their GPAs;
	 		   If k is larger than the database size, return all students names, sorted by the descending order of their GPAs;
	 */
	public ArrayList<String> removeTopkStudent(int k) {
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < k; i++) {
			try{
				HeapNode el = this.this_heap.poll();
				this.this_avltree.deleteNode(el.value1, el.value2);
				a.add(el.value1.toString());
			}
			catch(Exception e){
				System.out.println(e);
				break;
			}
		}
		return a;
	}
	
	/**
	 * TODO: search the GPA of student whose name is student_name
	 * @param student_name
	 * @return a Double variable which is the GPA of student with student_name
	 * 		   if the student_name does not exist in the database, return null;
	 */
	public Double searchStudentGPA(String student_name) {
		return this.this_avltree.search(student_name, 0.0) == null ? null : (Double)this.this_avltree.search(student_name, 0.0).value2;
	}
	
	public static void main(String[] args) {
		String[] students = new String[]{"C", "B", "D", "A"};
   	
		Double[] gpas = new Double[]{0.0, 1.0, 2.0, 3.0};

		GPADatabase gpa = new GPADatabase(12);
   	
   	for (int i = 0; i < students.length; i ++) {
   		gpa.insertStudent(students[i], gpas[i]);
   	}
   	
   	System.out.println(gpa.this_avltree.toString());
   	System.out.println(gpa.this_heap.toString());
   	System.out.println(gpa.removeTopkStudent(2));
   	System.out.println(gpa.searchStudentGPA("A"));
		 
	}

}
