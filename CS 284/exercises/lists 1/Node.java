 
public class Node {
    private Integer data;
    private Node next;
    /** Creates a new node with a null next field
        @param dataItem  The data stored
    */
    public Node(int dataItem) {
        data = dataItem;
        next = null;
    }
    public Integer getData() {
        return this.data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return this.next;
    }
}