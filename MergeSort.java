import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers= {7,3,1,5, 2};
        sort(numbers);
        System.out.print(Arrays.toString(numbers));
    }

    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        // Divide array into 2
        var middle = array.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        // sort each half
        sort(left);
        sort(right);

        // Merge sorted halves into one array
        merge(left, right, array);

    }

    private static void merge(int[] left, int[] right, int[] results) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                results[k++] = left[i++];
            } else {
                results[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < left.length) {
            results[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < right.length) {
            results[k++] = right[j++];
        }
    }
}
