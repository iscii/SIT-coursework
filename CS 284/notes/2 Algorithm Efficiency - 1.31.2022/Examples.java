import java.util.concurrent.ForkJoinTask;

public class Examples {
    /*  Linear Growth Rate
        n
        Time complexity in worse case is n/2
    */
    public static int f(int[] x, int target){
        for(int i=0;i<x.length;i++){
            if(x[i]==target)
                return i;
        }
        return -1;
    }

    /*  n*m Growth Rate
        O(n*m)
    */
    public static boolean g(int[] x, int[] y){
        for(int i=0;i<x.length;i++){
            if(f(y, x[i]) !=-1)
                return false;
        }
        return true;
    }

    /*  Quadratic Growth Rate
        O(n^2)
        Processing time proportional to square of number of inputs n
    */
    public static boolean h(int [] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if(i != j && x[i] == x[j])
                    return false;
            }
        }
        return true;
    }
    /*
        Can use a hashmap/set to store values -> makes the algorithm Linear
            - Better w/ time complexity, worse w/ space complexity (more memory cost)
    */

    /*
        Logarithmic Growth Rate (fastest)
        O(log_2(n))

        We also examine the number of times a loop is executed
        Logarithmic gets faster as the sample size increases
    */
    public static void logex(int[] x){
        for (int i = 0; i < x.length; i*=2) {
            System.out.println(x[i]);
        }
    }

    /** Two Sum (quadratic runtime)
     *  given a sorte array of ints, return indices of the two numbers such that they add up to a specific target value 
     */
    public static int[] twoSum_quadratic(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
