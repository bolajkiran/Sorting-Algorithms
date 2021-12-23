import java.util.Scanner;

public class InsertionSort {
    /* Space & Time Complexity :
     * Best case : O(n) time | O(1) space
     * Avg. case : O(n^2) time | O(1) space
     * Worst case : O(n^2) time | O(1) space
     * where n = length of the array
     */
    public static void insertionSort(int[] array) {

        int n = array.length - 1;
        for(int j = 2; j <= n; j++) {
            int key = array[j];
            // inserting array[j] into the sorted sequence array[1...j-1]
            int i = j - 1;
            while(i > 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of the array:\nn = ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements of the array:\n");
        int[] array = new int[n + 1];
        // list unsorted array
        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
        }

        long startTime = System.nanoTime();
        // perform insertion sort on unsorted array
        insertionSort(array);

        long endTime = System.nanoTime();

        System.out.print("Sorted elements of the array:\n");
        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.printf("%nExecution time (in nano seconds) for insertion sort on %d elements:\nT(n) = %d", n, endTime - startTime);
    }
}
