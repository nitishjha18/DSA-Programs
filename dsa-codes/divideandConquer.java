public class divideandConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;       // Mid Pos
        mergeSort(arr, si, mid);            // Left Part
        mergeSort(arr, mid + 1, ei);        // Right Part
        merge(arr, si, mid, ei);
    }

    // Method to merge the two sorted parts
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;       // iterator for 1st sorted part
        int j = mid + 1;  // iterator for 2nd sorted part
        int k = 0;        // iterator for temp arr

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // For leftover elements of 1st sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // For leftover elements of 2nd sorted part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp to original arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 8, 6};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
