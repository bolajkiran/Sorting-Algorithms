import java.util.Random;
import java.util.Scanner;

public class ModifiedRandomizedQuickSort {

    static int recursiveCalls = 0;

    public static void exchange(int[] array, int r, int i) {
        int temp = array[r];
        array[r] = array[i];
        array[i] = temp;
    }

    public static int[] modified_partition1(int[] array, int p, int r) {
        int x = array[r];
        exchange(array, r, p);
        int i = p - 1;
        int k = p;
        for (int j = p + 1; j <= r - 1; j++) {
            if (array[j] < x) {
                i = i + 1;
                k = i + 2;
                exchange(array, i, j);
                exchange(array, k, j);
            }
            else if (array[j] == x) {
                k = k + 1;
                exchange(array, k, j);
            }
        }
        exchange(array, i+1, r);
        return new int[] {i+1, k+1};
    }

    public static int[] modified_partition(int[] array, int p, int r) {
        int x = array[p];
        int q = p, t = r;
        for (int j = p + 1; j <= t;) {
            if (array[j] < x) {
                exchange(array, q, j);
                q = q + 1;
                j = j + 1;
            } else if (array[j] > x) {
                exchange(array, j, t);
                t = t - 1;
            } else {
                j = j + 1;
            }
        }
        return new int[] {q, t};
    }

    public static int[] modified_randomized_partition(int[] array, int p, int r) {
        Random random = new Random();
        int i = random.nextInt(r - p) + p;

        // exchange A[r] with A[i]
        exchange(array, r, i);
        return modified_partition(array, p, r);
    }

    public static void modified_randomized_quicksort(int[] array, int p, int r) {
        if(p < r) {
            int[] indices = modified_randomized_partition(array, p, r);
            int q = indices[0];
            int t = indices[1];

            recursiveCalls++;
            modified_randomized_quicksort(array, p, q-1);

            recursiveCalls++;
            modified_randomized_quicksort(array, t+1, r);
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
        // 5 6 8 10 11 13 8 8 3 5 2 11 8
        modified_randomized_quicksort(array, 1, array.length - 1);

        System.out.print("Sorted elements of the array:\n");
        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\nTotal recursive calls made for modified Randomized Quicksort = " + recursiveCalls);
    }
}
