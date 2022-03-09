import java.util.List;
import java.util.LinkedList;

class Permutations{
    public static <E>List<List<E>> allPermutations(List<E> l){
        //call alinsertions on each sublist
        
    }

    public static <E>List<List<E>> allInsertions(E el, List<E> l){

    }

    public static void main(String[] args){
        List<String> l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");

        for (var lIns : allInsertions("!", 1)) {
            System.out.println(lIns);
        }

        for (var perm: allPermutations(l)){
            StringBuffer sb = new StringBuffer();
            for (var s : perm) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
} 
