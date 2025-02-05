package stringBulilderBuffer;

public class ReverseString {

    public static String reverse(String input){

        //Initilizing stringbuilder to create object
        StringBuilder sb = new StringBuilder(input);

        //using reverse method to reverse sting
        sb.reverse();

        //converting stringbuilder to string again
        return sb.toString();

    }
    public static void main(String[] args) {
        //taking hello as string
        String input= "hello";
        String reverse = reverse(input);

        System.out.println("Actual  string is :  " + input);
        System.out.println("Reversed string is : " + reverse);
    }

}
