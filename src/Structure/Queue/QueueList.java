package Structure.Queue;

public class QueueList<T> {

    private Node<T> front, rear;
    public class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public QueueList() {
        front = null;
        rear = null;
    }
    public boolean isEmpty() {
        return (front == null);
    }
    public void enqueue(T item) {
        Node<T> newNode = new Node<T>(item);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
        System.out.println("Inserted " + item);
    }
    public T dequeue() {
        T item = null;
        if (isEmpty()) {
            System.out.println("Structure.Queue is empty");
        } else {
            item = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            System.out.println("Deleted " + item);
        }
        return item;
    }

    public static void main(String[] args) {
        QueueList<Integer> queue = new QueueList<Integer>();

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
        queue.dequeue();
    }

}
