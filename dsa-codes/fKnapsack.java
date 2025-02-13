import java.util.Arrays;
import java.util.Comparator;

public class fKnapsack {
    public static void main(String[] args){
        int val[] = {60,100,120};
        int weigth[] = {10,20,30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
//        0th cpl = -> idx; 1st col -> ratio

        for (int i=0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weigth[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalValue = 0;
        for (int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if (capacity >= weigth[idx]){  // include full item
                finalValue += val[idx];
                capacity -= weigth[idx];
            }else {
//                include fractional item
                finalValue += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("final value =" + finalValue);

    }
}
