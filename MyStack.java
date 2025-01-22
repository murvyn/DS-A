import java.util.Arrays;

public class MyStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
    }

}

class Stack {
    private final int[] items = new int[5];
    private int count = 0;

    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        items[count++] = item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[count - 1];
    }

    @Override
    public String toString() {
        var copy = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(copy);
    }
}
