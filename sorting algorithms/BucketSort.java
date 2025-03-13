
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
         int[] numbers= {7,3,1,5, 2};
        sort(numbers, 3);
        System.out.print(Arrays.toString(numbers));
    }

    public static void sort(int[] array, int numberOfBuckets) {
        var i = 0;
        for(var bucket :  createBuckets(array, numberOfBuckets)){
            Collections.sort(bucket);
            for(var item: bucket) {
                array[i++] = item;
            }
        }
    }

    private static List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0;i < numberOfBuckets; i++ ) {
            buckets.add(new ArrayList<>());
        }

        for(var item : array) {
            buckets.get(item / numberOfBuckets).add(item);
        }
        return buckets;
    }
}
