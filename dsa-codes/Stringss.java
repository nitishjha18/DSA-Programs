import java.util.*;
public class Stringss {
    //    PART 5 -----> Printing all the elements present at the 'i'th using charAt() methord.
    public static void printLetters(String str){
        for (int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }




    //    PART 1 -----> Application of strings
    public static void main(String args[]) {
//        String str = "abcd";
//        String str1 = new String("xyz");
//        System.out.println(str1);


    /*
 Strings are IMMUTABLE -----> Meaning their values cant be changed you need to create new String to add
                              or change the value in a particular String.
    */

    /*
//    PART 2 -----> Taking input through scanner class
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();     // () -----> It is used in sc.next because String is a function.
        System.out.println(name);    // .nextLine to take full scentence as input and .next for a word only

    */

        /*
//    PART 3 -----> To check the length of a String
        String favSeries = "Succession";
        System.out.println(favSeries.length());

       */

        /*
//    PART 4 -----> CONCATENATION => Adding two or more string to get a single string.
        String firstName = "Peter";
        String lastName  = "Parker";
        String fullName  = firstName + " " + lastName;         // CONCATENATION
        System.out.println(fullName + " is the real name of spiderman");  // CONCATENATION
         */

        /*
//    PART 5 -----> CharAt() => To check which character is present on the given index.
        String firstName = "Peter";
        System.out.println(firstName.charAt(2));
         */
        String str = "Aurobindo Ghosh";
        printLetters(str);
    }
}
