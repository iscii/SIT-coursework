class BalancedParenTree {
    public Node root;

    private class Node {
        private String terminal;
        private Node[] children; 

        
        public Node(){
            terminal = null;
            children = null;
        }

        public Node(String t, Node[] c){
            terminal = t;
            children = c;
        }

        public void setChildren(Node[] c){
            children = c;
        }
    }


    /**
     * Creates a tree of nodes from a String of parentheses.
     * @param paren_str String of parentheses
    */
    public void parse(String paren_str) {

    
    }

    
    /**
     * Creates string representation of BalancedParenTree
     * @return string form of terminal symbols
    */
    public String toString() {
        return toStringHelper(this.root);
    }

    /**
     * Creates string representation of BalancedParenTree
     * @param root_node Node that represents top of tree
     * @return string form of terminal symbols
    */
    private String toStringHelper(Node root_node) {
        if (root_node.terminal != null) {
            if (!root_node.terminal.equals("N"))
                return root_node.terminal;
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (Node c : root_node.children)
            sb.append(toStringHelper(c));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        //Example 1
    	String testString1  = "()";
    	BalancedParenTree bpt = new BalancedParenTree();
        bpt.parse(testString1);
        if("()".equals(bpt.toString())) {
        	System.out.println("Example 1 - Success");
        } else {
        	System.out.println("Example 1 - Failed");
        }
        
        //Example 2
        String testString2  = "()()";
    	BalancedParenTree bpt2 = new BalancedParenTree();
    	bpt2.parse(testString2);
        if("()()".equals(bpt2.toString())) {
        	System.out.println("Example 2 - Success");
        } else {
        	System.out.println("Example 2 - Failed");
        }
        
        //Example 3
        String testString3  = "(())";
    	BalancedParenTree bpt3 = new BalancedParenTree();
    	bpt3.parse(testString3);
        if("(())".equals(bpt3.toString())) {
        	System.out.println("Example 3 - Success");
        } else {
        	System.out.println("Example 3 - Failed");
        }
    }
}
