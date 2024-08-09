public class stringQuestions {

// Question1 --> Check if the given String is palindrome or not.
    public static boolean isPalindrome(String pwd){
        int n = pwd.length();
        for (int i=0; i<n/2; i++){
            if (pwd.charAt(i) != pwd.charAt(n-1-i)){
//                NOT A PALINDROME
                return false;
            }
        }
        return true;
    }

// Question2 --> Given a route containing 4 directions (E,W,N,S),find shortest path to reach destination.

    public static float getShortestPath(String path){
        int x=0 , y=0;
        for (int i=0; i<path.length(); i++){
            char dir = path.charAt(i);
            //      East
            if (dir == 'E') {
                x++;
            }
            //      West
            else if (dir == 'W') {
                x--;
            }
            //      North
            else if (dir == 'N') {
                y++;
                }
            //      South
            else if (dir == 'S') {
                y--;
            }

        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2+Y2);
    }

    public static void main(String[] args){
        String path = "WN";
        System.out.println(getShortestPath(path));
    }













}
