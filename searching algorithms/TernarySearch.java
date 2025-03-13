public class TernarySearch {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        System.out.println(search(numbers, 3, 0, numbers.length - 1));
    }

    public static int search(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int partition = (right - left) / 3;
        int mid1 = left + partition;
        int mid2 = right - partition;

        if (target == array[mid1]) {
            return mid1;
        }
        if (target == array[mid2]) {
            return mid2;
        }
        if (target < array[mid1]) {
            return search(array, target, left, mid1 - 1);
        }
        if (target > array[mid2]) {
            return search(array, target, mid2 + 1, right);
        }

        return search(array, target, mid1 + 1, mid2 - 1);
    }
}
