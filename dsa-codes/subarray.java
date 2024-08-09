public class subarray {
    /*public static void reverse(int numbers[]){
        int start = 0 , end = numbers.length-1;
        while(start<end){
//      1..    Swapping & Reversing
            int temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;
            start++;
            end--;
        }

    }

     */
    /*
//  2... Pairs in array

    public static void printPairs(int numbers[]){

        int tp = 0;
        for( int i=0; i<numbers.length; i++){
            int current = numbers[i];
            for (int j=i+1; j<numbers.length; j++){
                System.out.print("(" + current + "," + numbers[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total no. of pairs is = " + tp);
    }

 */
    /*
   // 3... Print Subarray
    public static void printSubarray(int numbers[]){
        int ts = 0;
        int n = numbers.length;
        for(int i = 0; i<n; i++) {
            int start = i;
            for (int j = i; j < n; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " " );
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
       System.out.println("total no. of pairs is = " + ts);
    }

 */

//                             MAX SUM OF SUBARRAY

    //     1.... Brute Force Algorithm
  /*
    public static void  maxSubarray(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = numbers.length;
        ;
        for (int i = 0; i < n; i++) {
            int start = i;
            for (int j = i; j < n; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    // Print
                    //subarray sum
                    currSum += numbers[k];
                }
                System.out.println(currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum is :" + maxSum);
    }

   */

    /*
    //  2.... Prefix Sum
      public static void maxPfSubarray(int numbers[]){
          int currSum = 0;
          int maxSum = Integer.MIN_VALUE;
          int prefix[] = new int[numbers.length];
          prefix[0] = numbers[0];
          //calculate prefix array
          for (int i=1; i< prefix.length; i++){
              prefix[i] = prefix[i-1] + numbers[i];
          }
          for (int i=0; i<numbers.length; i++){
              int start = i;
              for(int j=i; j<numbers.length; j++){
                  int end = j;
                  currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                  if (maxSum<currSum){
                      maxSum = currSum;
                  }
              }
          }
          System.out.println("Max sum is :" + maxSum);
      }

       */



   // 3....Kadanes's Algorithm
    /*public static void maxkASubarray(int numbers[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0; i< numbers.length; i++){
            cs+=numbers[i];
            if (cs<0){
                cs=0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println("Max sum is :" + ms);

    }

     */



    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
    }
}
