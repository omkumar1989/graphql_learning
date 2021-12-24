package recurcive.program;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial(int num){
        return num==1 ? 1 : num * factorial(num-1);
    }
}
