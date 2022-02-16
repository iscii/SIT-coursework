
public class Node<E> {
	private E data;
	private Node<E> next;

	/**
	 * Creates a new node with a null next field
	 * @param dataItem The data stored
	 */
	public Node(E dataItem) {
		data = dataItem;
		next = null;
	}

	/**
	 * Creates a new node with a nodeRef next field
	 * @param dataItem The data stored
	 */
	public Node(E dataItem, Node nodeRef) {
		data = dataItem;
		next = nodeRef;
	}
	
	/**
	 * Get Node next
	 * @return next
	 */
	public Node getNext() {
        return this.next;
    }

	/**
	 * Set Node next
	 * @param next The next node reference
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}
