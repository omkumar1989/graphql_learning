package recurcive.program;

public class CountDigit {
    public static void main(String[] args) {
        System.out.println(countDigit(3456789));
    }
    public static int countDigit(int num){
        return num/10==0 ? 1 : 1 + countDigit(num/10);
    }
}
