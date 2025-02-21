
public class HeapExercise {
    public static void main(String[] args) {
        //find kth largest item
    }

    public static void heapify(int[] array) {
        var  lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            answer(array, i);
        }
    }

    public static void answer(int[] array, int index) {
        var largestIndex = index;

        var leftIndex = 2 * index + 1;
        if(leftIndex < array.length && array[leftIndex] > array[largestIndex]) {
            largestIndex = leftIndex;
        }

        var rightIndex = 2 * index + 2;
        if(rightIndex < array.length && array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }

        if(index == largestIndex) {
            return;
        }
        swap(array, index, largestIndex);
        answer(array, largestIndex);
    }

    public static void swap(int[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class Heap {
    private final int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }
        items[size++] = value;
        bubbleUp();
    }

    public boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        var root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while (index < items.length && !isValidParent(index)) {
            var largestChildIndex = largerChildIndex(index);
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        var isValid = items[index] >= leftChild(index);
        if (hasRightChild(index)) {
            isValid &= items[index] >= rightChild(index);
        }
        return isValid;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}