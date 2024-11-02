import java.util.*;

public class StackQues {
    /*public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                span[i] = i+1;
            }else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }}
        public static void main(String args[]){
            int stocks[] = {100,80,60,70,60,85,100};
            int span[]  = new int[stocks.length];
            stockSpan(stocks,span);
            for (int i=0; i<span.length; i++){
                System.out.println(span[i] + " ");
            }

    }*/
//    Q Valid paranthesis
    /*public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {   // opening
                s.push(ch);
            } else {
                // closing
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')       //  ()
                    ||(s.peek() == '{' && ch == '}')     //  {}
                    || (s.peek() == '[' && ch == ']')) { //  []
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if (s.isEmpty()){
            return true;
        }else {
            return false;
        }
    }*/


    /*public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //closing
            if (ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if (count < 1){
                    return true; // duplicate
                }else {
                    s.pop();     // opening bar
                }
            }else {
                // opening
                s.push(ch);
            }
        }
        return false;
    }*/

    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // Next Smaller Right
        Stack<Integer> s = new Stack<>();
        for (int i= arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i] = arr.length;
            }else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Next Smaller Left
        s = new Stack<>();

        for (int i= 0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsl[i] = -1;
            }else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // Current Area : width = j-i-1 = nsr[i]-nsl[i]-1
        for (int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea , maxArea);
        }
        System.out.println("max area in histogram = " + maxArea);
    }

    public static void main(String args[]){
        int arr[] = {2,1,5,6,2,3}; // heights in histogram
        maxArea(arr);
    }
}