import java.util.Scanner;

public class twodarray {
   private static boolean search(int matrix[][], int key){
       int n = matrix.length , m = matrix[0].length;
       for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
               if (matrix[i][j] == key){
                   System.out.println("(" + i + "," + j + ")");
                   return true;
               }
           }
       }
       System.out.println("Key not found");
       return false;
   }

   public static void main(String[] arg){
        int[][] matrix = new int [3][3];
        int n = matrix.length , m = matrix[0].length;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
//        OUTPUT
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix,1);
    }
}
