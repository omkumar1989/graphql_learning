package recurcive.program;

public class ReverseString {
    public static void main(String[] args) {
        mirror("madam");
    }

    public static void mirror(String text){
        if(text.length()==1){
            System.out.print(text);
        }else {
            System.out.print(text.charAt(text.length()-1));
            mirror(text.substring(0,text.length()-1));
        }
    }
}
