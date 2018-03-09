import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue{

    private int[] queue;
    private int head, tail, elementCount;

    public CircularArrayQueue() {
        queue = new int[1];
        head = tail = elementCount = 0;
    }
    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public int dequeue() throws NoSuchElementException {
        int next = queue[head];
//        System.out.println("Front of queue: " + next);
        head++;
        if (head == queue.length)
            head = 0;
        elementCount--;
        return next;
    }

    @Override
    public int noItems() {
//        System.out.println("No. of elements: " + elementCount);
        return elementCount;
    }

    @Override
    public void enqueue(int in) {
        if (getCapacityLeft() == 0) {
//            System.out.println("No room in array");
            int[] oldArray = new int[queue.length];
            System.arraycopy(queue, 0, oldArray, 0, queue.length);
//            System.out.println("Previous array size: " + queue.length);
            queue = new int[queue.length * 2];
            System.arraycopy(oldArray, 0, queue, 0, oldArray.length);
//            System.out.println("New array size: " + queue.length);

        }
//           System.out.println("Adding " + in + " to queue");
        queue[tail] = in;
        elementCount++;
        tail++;
        if (tail == queue.length)
            tail = 0;
//        System.out.println(Arrays.toString(queue));
    }

    public int getCapacityLeft() {
        return queue.length - elementCount;
    }
}
