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

        if (isEmpty())
            throw new NoSuchElementException("No element");
        else {
            int next = queue[head];
            head++;
            if (head == queue.length)
                head = 0;
            elementCount--;
            return next;
        }
    }

    @Override
    public int noItems() {
        return elementCount;
    }

    @Override
    public void enqueue(int in) {
        if (getCapacityLeft() == 0) {
            int[] oldArray = new int[queue.length];
            System.arraycopy(queue, 0, oldArray, 0, queue.length);
            queue = new int[queue.length * 2];
            System.arraycopy(oldArray, 0, queue, 0, oldArray.length);

        }
        if (tail == queue.length)
            tail = 0;
        queue[tail] = in;
        elementCount++;
        tail++;
    }

    public int getCapacityLeft() {
        return queue.length - elementCount;
    }
}
