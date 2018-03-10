public class Main {

    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue();
        queue.enqueue(5);
        System.out.println(queue.getCapacityLeft());
        queue.enqueue(10);
        System.out.println(queue.getCapacityLeft());
        queue.enqueue(21);
        System.out.println(queue.getCapacityLeft());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
