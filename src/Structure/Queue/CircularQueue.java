package Structure.Queue;

public class CircularQueue<T> {

    private int front, rear, capacity;
    private T[] array;

    public CircularQueue(int size) {
        capacity = size;
        front = -1;
        rear = -1;
        array = (T[]) new Object[size];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return ((rear + 1) % capacity == front);
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Structure.Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            array[rear] = item;
            System.out.println("Inserted " + item);
        }
    }

    public T dequeue() {
        T item = null;
        if (isEmpty()) {
            System.out.println("Structure.Queue is empty");
        } else {
            item = array[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            System.out.println("Deleted " + item);
        }
        return item;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<Integer>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

}
