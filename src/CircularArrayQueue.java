/**
 * @author Kacper Martela
 */

import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue{

    private int[] queue;
    private int head, tail, elementCount;

    /**
     * Initialise the queue with an initial size of 10
     */
    public CircularArrayQueue() {
        queue = new int[10]; //Setting the initial size of the array to 10, reasonably sized queue
        head = tail = elementCount = 0; //Setting the head and tail to the start and resetting the element count
    }

    /**
     *
     * @return Whether the queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    } //If there are no elements returns true

    /**
     * Deques the next element from the queue
     * @return The next item in the queue
     * @throws NoSuchElementException If there are no elements to dequeue
     */
    @Override
    public int dequeue() throws NoSuchElementException {

        //If the queue is empty throw an exception, else remove the object
        if (isEmpty())
            throw new NoSuchElementException("No element");
        else {
            int next = queue[head]; //Getting the next int in the queue
            head++; //Incrementing the head by one
            if (head == queue.length) //If we get to the end of the circle, we have to set the head to 0 again.
                head = 0;
            elementCount--; //Decreased the element count by one
            return next;
        }
    }

    /**
     *
     * @return Number of items in the queue
     */
    @Override
    public int noItems() {
        return elementCount;
    }

    /**
     * Adds an element to the queue
     * @param in The element to add to the queue
     */
    @Override
    public void enqueue(int in) {
        //If there is no room in the array we have to double the size
        if (getCapacityLeft() == 0) {
            int[] oldArray = queue;
            queue = new int[queue.length * 2]; //Make a new queue with twice the size of the previous one
            System.arraycopy(oldArray, 0, queue, 0, oldArray.length); //Copy the old array back into the new one

        }
        if (tail == queue.length)
            tail = 0; //If the tail gets to the end of the circular array then we have to set the pointer to 0
        queue[tail] = in; //Setting the element to the tail pointer in the queue
        elementCount++; //Increasing the element count by one to account for the new item in the queue
        tail++; //Moving the tail forward by one
    }

    /**
     *
     * @return The number of spaces left in the queue
     */
    public int getCapacityLeft() {
        return queue.length - elementCount;
    }
}
