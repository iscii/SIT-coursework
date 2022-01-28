public class Calculator{
    int base;

    public Calculator(int base){
        this.base = base;
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static float divide(int a, int b){
        if(b == 0){
            return -1;
        }
        return a/b;
    }

    public static void main(String[] args){
        Calculator a = new Calculator(2);
        System.out.println(Calculator.add(1,2));
    }
}