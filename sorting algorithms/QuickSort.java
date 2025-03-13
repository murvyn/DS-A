import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers= {7,3,1,5, 2};
        sort(numbers, 0, 4);
        System.out.print(Arrays.toString(numbers));
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        var boundary = partition(array, start, end);

        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, ++boundary);
            }
        }
        return boundary;
    }

    private static void swap(int[] items, int index1, int index2) {
        var temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
