public class array {
    public static int linearSearch(int numbers[], int key) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (key == numbers[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = {1};
//        int key = System.out.println(linearSearch(numbers, key));
    }
}

