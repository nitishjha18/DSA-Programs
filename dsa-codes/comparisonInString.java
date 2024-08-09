import org.w3c.dom.ls.LSOutput;

public class comparisonInString {
    public static void main(String[] args){
        String s1 = "1";
        String s2 = "12";
        String s3 = new String("12");
        if (s1.equals(s3)){ // agar normal loop use kiya hota toh s1 aur s3 eqaual nahu hue hote
            System.out.println("True");
        }else{
            System.out.println("false");
        }

    }
}
