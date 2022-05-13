import java.util.ArrayList;
import java.util.Arrays;

public class TupleSort {
	
   class Tuple implements Comparable<Tuple>{
	    int[] tuple;
		
		public Tuple(int[] this_tuple) {
			this.tuple = this_tuple;
		}

		/** you need to implement this function */
		@Override
		public int compareTo(Tuple other_tuple) {
			if(this.tuple.length==0 && other_tuple.tuple.length==0) return 0;

			for (int i = 0; i < this.tuple.length; i++) {
				if(other_tuple.tuple.length < i){ //other tuple length smaller; this bigger
					//System.out.println("1 here");
					return 1;
				}
				if(this.tuple[i] < other_tuple.tuple[i]){
					//System.out.println("3 here");
					return -1;
				}
				if(this.tuple[i] > other_tuple.tuple[i]){
					//System.out.println("4 here");
					return 1;
				}
				if(i == this.tuple.length-1 && i < other_tuple.tuple.length-1){
					//System.out.println("2 here" + i);
					//System.out.println(other_tuple.tuple.length);
					return -1;
				}
			}
			return 0;
		}
	}
   
    public TupleSort() {
		
    }
    
	public int test_compareTo_gs(int[] arr1, int[] arr2) {	
		Tuple t1 = new Tuple(arr1);
		Tuple t2 = new Tuple(arr2);		
		return t1.compareTo(t2);
	}
	
	public ArrayList<int[]> test_tuplesort_gs(ArrayList<int[]> list) {	
		int len = list.size();
			Tuple[] tuple = new Tuple[len];
			for (int i = 0; i < len; i++) {
				tuple[i] = new Tuple(list.get(i));
			}		   
			Tuple[] sorted_tuple = tuple_sort (tuple);
			
			ArrayList<int[]> sorted_list = new ArrayList<int[]>();	  
			for (int i = 0; i < len; i++) {
				if (sorted_tuple[i] != null)
					sorted_list.add(sorted_tuple[i].tuple);
				else
					sorted_list.add(new int[]{-1});
			}	
			
			return sorted_list;
	}
	
   
   /** you need to implement this function */
   
   public Tuple[] tuple_sort(Tuple[] array) {
		ArrayList<Tuple> a = new ArrayList<Tuple>(Arrays.asList(array));
		for (int i = 1; i < a.size(); i++) {
			for (int j = 0; j < i; j++) {
				if(a.get(i).compareTo(a.get(j)) < 1){ //current (after) is less than prev
					a.add(j, a.remove(i));
				}
			}
		}
		return a.toArray(new Tuple[a.size()]);
	}
   
   public void print_tuple_array(Tuple[] array) {
	   
	   String actual_output = "";
	   
	   for(int i = 0; i < array.length; i++) {
		   
		   String output = "(";
		   for(int x = 0; x < array[i].tuple.length; x++)
			   output += array[i].tuple[x] + ", ";
		   output = output.substring(0, output.length()-2);
		   
		   output += ")";
		   
		   actual_output += output + ", ";
		   
	   }
	   
	   System.out.println(actual_output.substring(0, actual_output.length()-2));
	   
   }
   
   public void test_tuple_sort () {
	   Tuple [] test_tuple = new Tuple [5];
	   test_tuple [0] = new Tuple (new int[] {1 , 2});
	   test_tuple [1] = new Tuple (new int[] {2});
	   test_tuple [2] = new Tuple (new int[] {1 , 1 , 1});
	   test_tuple [3] = new Tuple (new int[] {1 , 5 , 0 , 5});
	   test_tuple [4] = new Tuple (new int[] {1 , 5 , -1}); //bruh whys there a negative
	   System.out.println("Before sorting: ");
	   this.print_tuple_array(test_tuple);
	   Tuple [] sorted_tuple = this. tuple_sort ( test_tuple );
	   System.out.println("After sorting: ");
	   this.print_tuple_array(sorted_tuple);
   }

   public void test(){
		Tuple [] test_tuple = new Tuple [5];
		test_tuple [0] = new Tuple (new int[] {1 , 2});
		test_tuple [1] = new Tuple (new int[] {2});
		test_tuple [2] = new Tuple (new int[] {1 , 1 , 1});
		test_tuple [3] = new Tuple (new int[] {1 , 5 , 0 , 5});
		test_tuple [4] = new Tuple (new int[] {1 , 5 , -1});
		System.out.println(test_tuple[0].compareTo(test_tuple[0])); //0
		System.out.println(test_tuple[0].compareTo(test_tuple[1])); //-1
		System.out.println(test_tuple[1].compareTo(test_tuple[2])); //1
		System.out.println(test_tuple[2].compareTo(test_tuple[3])); //-1
		System.out.println(test_tuple[3].compareTo(test_tuple[4])); //1
   }	
   
   public static void main(String[] args) {
	   	TupleSort app = new TupleSort();
		//app.test();
		//app.test_tuple_sort();
		app.test();
   }

}