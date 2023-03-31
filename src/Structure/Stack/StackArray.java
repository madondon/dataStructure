package Structure.Stack;

import java.util.NoSuchElementException;

public class StackArray<T> {

        private Object[] elements;
        private int top = -1;
        private int size;

        public StackArray(int size) {
            this.size = size;
            elements = new Object[size];
        }

        public void push(T item) {
            if (top == size - 1) {
                throw new StackOverflowError();
            }
            elements[++top] = item;
        }

        public T pop() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            T item = (T) elements[top];
            elements[top--] = null;
            return item;
        }

        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return (T) elements[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
        public static void main(String[] args) {
            StackArray<Integer> stack = new StackArray<>(4);

            // Pushing elements onto the stack
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println(stack .peek());
            // Popping elements from the stack
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }
}
