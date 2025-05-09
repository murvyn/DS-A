import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers= {7,3,1,5, 2};
        sort(numbers);
        System.out.print(Arrays.toString(numbers));
    }
    public static void sort(int[] array) {
         for (int i = 1; i < array.length; i++) {
             var current = array[i];
             var j = i -1;
             while(j >= 0 && array[j] > current ) {
                array[j + 1] = array[j];
                j--;
             }
             array[j + 1] = current;
         }
    }
}
