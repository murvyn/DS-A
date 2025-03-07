
import java.util.Arrays;

public class BubbleSort {
    public static void main (String[] args) {
        int[] items = {1,5,3,6,7,9,2};
        sort(items);
        System.out.println(Arrays.toString(items));
    }
    public static void sort (int[] items) {
        boolean isSorted;
        for(var i = 0; i < items.length; i++) {
            isSorted = true;
            for(var j = 0; j < items.length - i; j++) {
                if(items[j] < items[i]) {
                    swap(items, j, j-1);
                    isSorted = false;
                }
                if(isSorted) return;
            }
        }
    }
    
    private static void swap(int[] items, int index1, int index2) {
        var temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
