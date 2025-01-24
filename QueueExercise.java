
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueExercise {
    public static void main(String[] args) {
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // reverse(queue);
        // System.out.println(queue);
        PriorityQueue queue = new PriorityQueue();
        queue.add(10);
        queue.add(5);
        queue.add(15);
        queue.add(25);
        queue.add(25);
        queue.add(25);
        queue.add(25);
        System.out.println(queue.toString());
    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}

class ArrayQueue {
    private final int[] items;
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        var item = items[head];
        items[head] = 0;
        head = (head + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[head];
    }
}

class StackQueue {
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        moveStackOneToTwo();
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        moveStackOneToTwo();
        return stack2.peek();
    }

    private void moveStackOneToTwo() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[--count];
    }

    public void add(int item) {
        if (isFull()) {
            int newLength = items.length * 2;
            int[] newItems = Arrays.copyOf(items, newLength);
            items = newItems;
        }
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
