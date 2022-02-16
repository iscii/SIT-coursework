
public class CompressingLinkedList {
    private static class CompressedNode {
        private Integer data;
        private Integer repetitions;
        private CompressedNode next;

        /**
         * Creates a new compressed node with a null next field
         * 
         * @param dataItem The data stored
         */
        private CompressedNode(Integer dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * set the number of copies as copy
         * 
         * @param copy
         */
        private void set_repetitions(Integer rep) {
            repetitions = rep;
        }
        private Integer get_repetitions() {
            return repetitions;
        }
    }

    //! modify the head once the next data is not equal to current data
    CompressedNode head;

    /**
     * compresses a list by skipping even numbers
     * 
     * @param node_head
     */
    public void compress(Node node_head) {
        // go through each node_head (while)
        // if the data == next, add to prev compressednode
        // if data != next, create new prev, set rep to 1, and set the previous compressednode's pointer to this new one
        // keep going

        CompressedNode prev = new CompressedNode(node_head.getData());
        head = prev;
        prev.set_repetitions(1);
        
        while(node_head.getNext() != null){
            if(node_head.getData() == node_head.getNext().getData()){
                prev.set_repetitions(prev.get_repetitions()+1);
            }
            else{
                CompressedNode current = new CompressedNode(node_head.getNext().getData());
                current.set_repetitions(1);
                prev.next = current;
                prev = current;
            }
            node_head = node_head.getNext();
        }
    }

    /**
     * return the string of the linked list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        CompressedNode cn = head;
        if (cn != null) {
            while (cn.next != null) {
                sb.append("(");
                sb.append(cn.data.toString());
                sb.append(",");
                sb.append(cn.repetitions);
                sb.append(")");
                sb.append(",");
                cn = cn.next;
            }
            sb.append("(");
            sb.append(cn.data.toString());
            sb.append(",");
            sb.append(cn.repetitions);
            sb.append(")");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Node a1 = new Node(4);
        Node a2 = new Node(4);
        Node a3 = new Node(4);
        Node a4 = new Node(1);
        Node a5 = new Node(1);
        a1.setNext(a2);
        a2.setNext(a3);
        a3.setNext(a4);
        a4.setNext(a5);

        Node b1 = new Node(3);
        Node b2 = new Node(3);
        Node b3 = new Node(2);
        Node b4 = new Node(3);
        b1.setNext(b2);
        b2.setNext(b3);
        b3.setNext(b4);


        CompressingLinkedList a = new CompressingLinkedList();
        a.compress(a1);
        System.out.println(a);
        a.compress(b1);
        System.out.println(a);
    }
}