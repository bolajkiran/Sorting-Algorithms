import java.util.Random;
import java.util.Scanner;

public class RandomizedQuickSort {

    static int recursiveCalls = 0;

    public static void exchange(int[] array, int r, int i) {
        int temp = array[r];
        array[r] = array[i];
        array[i] = temp;
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (array[j] <= x) {
                i = i + 1;
                exchange(array, i, j);
            }
        }
        exchange(array, i+1, r);
        return i+1;
    }

    public static int randomized_partition(int[] array, int p, int r) {
        Random random = new Random();
        int i = random.nextInt(r - p) + p;

        // exchange A[r] with A[i]
        exchange(array, r, i);
        return partition(array, p, r);
    }

    public static void randomized_quicksort(int[] array, int p, int r) {
        if(p < r) {
            int q = randomized_partition(array, p, r);
            recursiveCalls++;
            randomized_quicksort(array, p, q-1);
            recursiveCalls++;
            randomized_quicksort(array, q+1, r);
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

        // perform randomized  quicksort on unsorted array
        randomized_quicksort(array, 1, array.length - 1);

        System.out.print("Sorted elements of the array:\n");
        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\nTotal recursive calls made for Randomized Quicksort = " + recursiveCalls);
    }
}
