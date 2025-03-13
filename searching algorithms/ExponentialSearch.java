public class ExponentialSearch{
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        System.out.println(search(numbers, 5));
    }

    public static int search(int[] array, int target) {
        int bound = 1;
        while (bound <array.length && array[bound] < target) {
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, array.length -1);
        return BinarySearch.searchRec(array, target, left, right);
    }
} 