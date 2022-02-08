import java.util.ArrayList;
import java.util.List;

public class Main {
    //Generics allow us to create classes, interfaces, and methods that work with different data types (generic entities)
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
    }
    //generic method; declares a method that takes in an array of generic data type T (stands for Type; E also works) [type parameters]
    //and returns a list of generic data type T.
    //type '?' [type argument] is a wildcard used to refer a list as some type we don't exactly know.
    public static <T> List<T> methoda(T[] a){
        return new ArrayList<T>(5);
    }
}
