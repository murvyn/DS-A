public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        System.out.println(searchRec(numbers, 5, 0, numbers.length - 1));
    }

    public static int searchRec(int[] array, int target, int left, int right) {
        if (right < left) {
            return -1;
        }

        var middle = (left + right) / 2;

        if (array[middle] == target) {
            return middle;
        }

        if (target < array[middle]) {
            return searchRec(array, target, left, middle - 1);
        }

        return searchRec(array, target, middle + 1, right);
    }

    public static int searchItr(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (right <= left) {
            var middle = (left + right) / 2;
            if (array[middle] == target) {
                return middle;
            }

            if (target < array[middle]) {
                right = middle - 1;
            }

            left = middle + 1;

        }
        return -1;
    }
}
