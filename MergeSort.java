import java.util.Scanner;

public class MergeSort {

    /*
    * A[1...n] = array[1...n]
    * p = startIndex
    * r = endIndex
    * Space & Time Complexity:
    * Best case: O(nlogn) time | O(n) space
    * Avg. case: O(nlogn) time | O(n) space
    * Worst case: O(nlogn) time | O(n) space
    * where n = length of array A
    */
    public static void mergeSort(float[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(array, startIndex, middleIndex);
        mergeSort(array, middleIndex + 1, endIndex);

        // merge two sorted arrays
        merge(array, startIndex, middleIndex, endIndex);
    }

    public static void mergeSort(float[] array) {
        mergeSort(array, 1, array.length - 1);
    }

    /*
    * A[1...n] = array[1...n]
    * p = startIndex
    * q = middleIndex
    * r = endIndex
    * L[1...n1+1] = leftAuxiliaryArray[1...n1+1]
    * R[1...n2+1] = rightAuxiliaryArray[1...n2+1]
    */
    public static void merge(float[] array, int startIndex, int middleIndex, int endIndex) {
        int n1 = middleIndex - startIndex + 1;
        int n2 = endIndex - middleIndex;

        float[] leftAuxiliaryArray = new float[n1 + 2];
        float[] rightAuxiliaryArray = new float[n2 + 2];

        for (int i = 1; i <= n1; i++) {
            leftAuxiliaryArray[i] = array[startIndex + i - 1];
        }
        for (int j = 1; j <= n2; j++) {
            rightAuxiliaryArray[j] = array[middleIndex + j];
        }
        leftAuxiliaryArray[n1 + 1] = Integer.MAX_VALUE;
        rightAuxiliaryArray[n2 + 1] = Integer.MAX_VALUE;
        int i = 1;
        int j = 1;
        for (int k = startIndex; k <= endIndex; k++) {
            if (leftAuxiliaryArray[i] <= rightAuxiliaryArray[j]) {
                array[k] = leftAuxiliaryArray[i];
                i = i + 1;
            } else {
                array[k] = rightAuxiliaryArray[j];
                j = j + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of the array:\nn = ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements of the array:\n");
        float[] array = new float[n + 1];
        // list unsorted array
        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextFloat();
        }

        //long startTime = System.nanoTime();
        // perform merge sort on unsorted array
        mergeSort(array);

       // long endTime = System.nanoTime();

        System.out.print("Sorted elements of the array:\n");
        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + "\n");
        }
      //  System.out.printf("%nExecution time (in nano seconds) for merge sort on %d elements:\nT(n) = %d", n, endTime - startTime);
    }
}
