package recurcive.program;

public class Fibonaci {
    public static void main(String[] args) {
        System.out.println(fibbo(5));
    }
    //0 1 1 2 3
    public static int fibbo(int x){
        if(x==0 || x==1){
            return x;
        }else {
            return fibbo(x-1) + fibbo(x-2);
        }
    }
}
