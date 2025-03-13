
public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {7,1,3,6,5};
        System.out.println(search(numbers, 3));
    }

    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
    }
}
