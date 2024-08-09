import java.util.Arrays;
import java.util.Collections;

public class BasicSorting {
//                               Basic Sorting Techniques
   /*
      1....Bubble Sort
      2....Selecton Sort
      3....Inseertion Sort
      4....Inbuilt Sort
      5....Counting Sort

    */




//   1....Bubble Sort
    public static void bubbleSort(int arr[]){
       int n = arr.length;
       for (int turns=0; turns<n-1; turns++){
          for (int j=0; j<n-1-turns; j++) {
             if (arr[j] > arr[j + 1]) {
//               Swapping
                 int temp = arr[j];
                 arr[j] = arr[j + 1];
                 arr[j + 1] = temp;
             }
          }
       }
    }

//    2....Selecton Sort
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            int minPos = i;
            for (Integer j=i+1; j < n; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
//            Here we have Swapped in the outer loop so that we can swap in the smallest element and
//            put it in the starting
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
//    To get output in the Ascending order switch symbols of the if condition.


//    3....Inseertion Sort
public static void insertionSort(int arr[]){
    int n = arr.length;
    for (int i=1; i<n; i++){
        int curr = arr[i];
        int prev = i-1;
//      Find out the correct position to insert
        while (prev>=0 && arr[prev]>curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
//      Insertion
        arr[prev+1] = curr;
    }
    }
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }




//   4....Inbuilt Sort

    public static void main(String args[]){
        int arr[] = {5,4,1,3,2};
        bubbleSort(arr);
        printArr(arr);
//        Arrays.sort(arr,0,5);
//        Arrays.sort(arr,0,5, Collections.reverseOrder());
//        printArr(arr);
        // reverse karne ke liye poore me int ko Integer me change karna hoga

    }
}
