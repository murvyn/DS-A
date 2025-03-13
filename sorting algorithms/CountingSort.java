import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] numbers= {7,3,1,5, 2};
        sort(numbers, 7);
        System.out.print(Arrays.toString(numbers));
    }

    public static void sort(int[] array, int max) {
        int[] counts = new int[max + 1];
        for(var item : array) {
            counts[item]++;
        }

        var k = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
