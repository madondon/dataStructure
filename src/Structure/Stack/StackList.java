package Structure.Stack;
import java.util.NoSuchElementException;

public class StackList<T> {
    private Node<T> top; // 栈顶元素
    private int size; // 栈的大小


    // 定义一个内部类，代表栈中的一个节点
    private static class Node<T> {
        private final T data; // 节点数据
        private Node<T> next; // 指向下一个节点

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 压栈操作
     * @param data 待压入栈的元素
     */
    public void push(T data) {
        Node<T> newNode = new Node<>(data, top);
        top = newNode;
        size++;
    }

    /**
     * 弹栈操作
     * @return 返回栈顶元素
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T result = top.data;
        top = top.next;
        size--;
        return result;
    }

    /**
     * 查看栈顶元素
     * @return 返回栈顶元素
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return top.data;
    }

    /**
     * 判断栈是否为空
     * @return 如果栈为空，返回true；否则返回false
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 返回栈的大小
     * @return 返回栈的大小
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackList<Integer> stack = new StackList<Integer>();
        // 压入元素
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());

        // 弹出元素
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
