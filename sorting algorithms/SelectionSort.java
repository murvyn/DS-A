
import java.util.Arrays;

public class SelectionSort{
    public static void main (String[] args){
        int[] numbers= {7,3,1,5, 2};
        sort(numbers);
        System.out.print(Arrays.toString(numbers));
    }
    public static  void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var minIndex = i;
            for (int j = i; j < array.length; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }
    private static void swap(int[] items, int index1, int index2) {
        var temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}