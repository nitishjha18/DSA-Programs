import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class arrList {
/*
    public static void main(String args[]){
    ArrayList<Integer>list = new ArrayList<>();
    list.add(1);
    list.add(9);
    list.add(7);
    list.add(0);
    list.add(6);
    System.out.println("ArrList : " + list);
//   1 --> Find the max in ArrList

    int max = Integer.MIN_VALUE;
   for (int i=0; i < list.size(); i++){
//        if (max < list.get(i)){
//            max = list.get(i);  }
       max = Math.max(max,list.get(i));       // --> shot and simple oneliner
    }
   System.out.println("The max element is = " + max);
}*/


//    2--> Swap 2 numbers in ArrList
    /*public static void swap(ArrayList<Integer> list , int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
}
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int idx1 = 1 , idx2 = 2;
        System.out.println(list);
            swap(list,idx1,idx2);
        System.out.println(list);
    }*/

    /*public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            list1.add(i * 1);   // 1,2,3,4,5
            list2.add(i * 2);   // 2,4,6,8,10
            list3.add(i * 3);   // 3,6,9,12,15
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);

//  Nested Loop --> to create Multi-Dimensional Array
        for (int i = 0; i< mainList.size(); i++){
            ArrayList<Integer>Currlist = mainList.get(i);
            for (int j = 0; j< Currlist.size(); j++){
                System.out.print(Currlist.get(j) + " ");
            }
            System.out.println();
        }*/

//  3 ----> Find out the maximum no. of water that can be stored between two lines

    /*public static int storeWater(ArrayList<Integer>height) {

        int maxWater = 0;
//        Bruteforce
        for (int i=0; i<height.size(); i++){
            for (int j=i+1; j<height.size(); j++){
                int ht = Math.min(height.get(i) , height.get(j));
                int width = j-i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;*/

        /*int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;
        while(lp < rp){
//            Calculate water area
            int ht = Math.min(height.get(lp) , height.get(rp));
            int width = rp-lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater,currWater);
//            update pointer
            if (height.get(lp) < height.get(rp)){
                lp++;
            }else {
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String args[]) {
        ArrayList<Integer>height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("The maximum no. of water that can be stored between two lines : " + storeWater(height));
}}*/
//  4----> Pair Sum -1 :) Find if any pair in the given sorted arraylist has a target sum.
   /* public static boolean pairSum(ArrayList<Integer>list, int target) {
        *//*for (int i=0; i<list.size(); i++){
            for (int j=i+1; j<list.size(); j++){
                if (list.get(i)+list.get(j) == target){
                    return true;
                }
            }
        }
        return false;*//*
//        ---> Optimization
        int lp = 0;
        int rp = list.size()-1;
        while (lp != rp){
//            Case 1
            if (list.get(lp)+list.get(rp) == target){
             return true;
            }
//            Case 2
            if (list.get(lp)+list.get(rp) < target){
                lp++;
            }
//            Case 3
            else {
                rp--;
            }
        }
        return false;
    }*/


    public static boolean pairSum2(ArrayList<Integer>list, int target){
        int bp = -1;
        int n = list.size();
        for (int i=0; i<n; i++){
            if (list.get(i) > list.get(i+1)){     // breaking point
                bp = i;
                break;
            }
        }
        int lp = bp+1;     //  smallest
        int rp = bp;       //  largest
        while (lp != rp){
//            Case 1
            if (list.get(lp)+list.get(rp) == target){
                return true;
            }
//            Case 2
            if (list.get(lp)+list.get(rp) < target){
                lp = (lp+1)%n;
            }
//            Case 3
            else {
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum2(list,target));
    }
    }


