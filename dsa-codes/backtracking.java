public class backtracking {

//------>     Change Array
    /*public static void changeArr(int arr[], int i, int val){
//        BASE CONDITION
        if (i == arr.length){
            printArr(arr);
            return;
        }
//        RECURSION
        arr[i] = val;
        changeArr(arr,i+1,val+1);
        arr[i] = arr[i] - 2;
    }
    public static void printArr(int arr[]){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = new int[5];
        changeArr(arr,0,1);
        printArr(arr);
    }
     */


    /*
//------>    Find Subsets
    public static void findSubsets(String str,String ans,int i){
//        BASE CONDITION
        if(i == str.length()){
            if (ans.length() == 0){
                System.out.println("null");
            }else {
                System.out.println(ans);
            }
            return;
        }
//        RECURSION CONDITION
//        Yes Condition
        findSubsets(str,ans+str.charAt(i),i+1);
//        No Condition
        findSubsets(str,ans,i+1);
    }

    public static void main(String args[]){
        String str = "abc";
        findSubsets(str,"",0);
    }
 */
    /*
//------> FIND PERMUTATION
    public static void findPermutation(String str,String ans){
//        BASE CONDITION
        if (str.length() == 0){
            System.out.println(ans);
            return;
        }
//        RECURSION CONDITION --> T.C = O(n *n!)

        for (int i=0; i<str.length(); i++){
            char current = str.charAt(i);
//            abcde => "ab" + "de"
            String NewStr = str.substring(0,i) + str.substring(i+1); // --> last me substr waale me agar end value nahi di toh uska matlab automatically i-1 hai
        findPermutation(NewStr, ans+current);
        }
    }
    public static void main(String args[]){
        String str = "abc";
        findPermutation(str," ");
    }*/



//------> 'n-Queens' in 'n' no. of ways

    /* public static boolean isSafe(char board[][], int row, int col){
//        Vertical Up
        for (int i=row-1; i>=0;i--){
            if (board[i][col] == 'Q'){
                return false;
            }
        }

//        Diagonal left Up
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
//        Diagonal right Up
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean nQueens(char board[][], int row) {
//        BASE CONDITION
        if (row == board.length) {
//            printBoard(board);
            count++;                 // to count the total no. of ways n-Queens problem can be solved
            return true;
        }
//        COULUMN LOOP
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) {
                    return true;
                }
                   // FUNCTION CALL
                board[row][j] = 'X';        //  BACKTRACKING
            }
        }
        return false;
    }
    public static void printBoard(char board[][]){
        System.out.println("--------Chess Board---------");
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board.length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
    static int count = 0;
    public static void main(String args[]){
        int n = 4;
        char board[][] = new char[n][n];
//        INITIALISE
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                board[i][j] = 'X';
            }
        }
        if(nQueens(board,0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }else {
            System.out.println("Solution is not possible");
        }
//        System.out.println("Total no. of ways = " + count);
    } */

//------>  Grid ways => Reach from source(0,0)  to destination(m-1,n-1)
    public static int gridWays(int i, int j, int m, int n){
//        BASE CODE
        if (i == m-1 && j == n-1){       // condition for last cell
            return 1;
        } else if (i ==m || j ==n) {     // boundary cross condition
            return 0;
        }
        int w1 = gridWays(i+1,j,n,m);
        int w2 = gridWays(i,j+1,n,m);
        return w1+w2;
        }

        public static void main(String args[]){
        int n = 3, m=3;
            System.out.println("The total no. of ways are --> " + gridWays(0,0,m,n));
        }
}
