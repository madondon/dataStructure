package Structure.List;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }


    public void insertAtPos(T data, int pos) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (pos == 0) {
            insertAtStart(data);
        } else if (pos == size) {
            insertAtEnd(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // 删除链表头部节点
    public void deleteAtStart() {
        if (head == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        head = head.next;
        size--;
    }

    // 删除链表尾部节点
    public T deleteAtEnd() {
        Node<T> deleteData=head;
        if (head == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            deleteData=p.next;
            p.next = null;
        }
        size--;
        return deleteData.data;
    }

    public void deleteAtPos(int pos) {
        if (isEmpty() || pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            deleteAtStart();
        } else if (pos == size) {
            deleteAtEnd();
        } else {
            Node<T> current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public T get(int pos) {
        if (isEmpty() || pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insertAtStart(3);
        list.insertAtStart(2);
        list.insertAtStart(1);
        list.insertAtEnd(4);
        list.insertAtPos(5, 2);
        list.deleteAtPos(3);
        list.deleteAtStart();
        list.deleteAtEnd();
        System.out.println("Structure.List contents:");
        list.display();
        System.out.println("Structure.List size: " + list.getSize());
        System.out.println("Element at index 2: " + list.get(1));
    }

}
