import java.util.Scanner;

public class OptimizedTailRecursiveQuickSort {

    static int stackDepth = 1;

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

    public static void optimized_tail_recursive_quicksort(int[] array, int p, int r) {
        System.out.printf("Current Stack Depth for p = %d is %d\n", p, stackDepth);
        while(p < r) {
            int q = partition(array, p, r);
            if (q < ((r - p) / 2)) {
                stackDepth++;
                optimized_tail_recursive_quicksort(array, p, q - 1);
                p = q + 1;
            } else {
                stackDepth++;
                optimized_tail_recursive_quicksort(array, q+1, r);
                r = q - 1;
            }
        }
        stackDepth--;
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

        // perform optimized tail recursive quicksort on unsorted array
        System.out.println("\nStack Depth of optimized tail recursive quick sort (depth of recursion) is - ");
        optimized_tail_recursive_quicksort(array, 1, array.length - 1);

        System.out.print("Sorted elements of the array:\n");
        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
