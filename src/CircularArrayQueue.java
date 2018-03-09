import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue{

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int dequeue() throws NoSuchElementException {
        return 0;
    }

    @Override
    public int noItems() {
        return 0;
    }

    @Override
    public void enqueue(int in) {

    }

    public int getCapacityLeft() {
        return 0;
    }
}
