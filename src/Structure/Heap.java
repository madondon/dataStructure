package Structure;

public class Heap {

    private int[] heap;
    private int size;
    private int maxSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize];
    }

    public int parent(int pos) {
        return (pos - 1) / 2;
    }

    public int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    public int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    public boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    public void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }

        heap[size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

        size++;
    }

    public void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }

        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public int remove() {
        int popped = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return popped;
    }

    public void buildMaxHeap(int[] array) {
        heap=array;
        size=array.length;
        // 从最后一个非叶子节点开始，逐个向下调整节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + heap[i] + " Left Child: " + heap[2 * i + 1] + " Right Child: " + heap[2 * i + 2]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Heap heap = new Heap(10);
//
//        heap.insert(5);
//        heap.insert(3);
//        heap.insert(17);
//        heap.insert(10);
//        heap.insert(84);
//        heap.insert(19);
//        heap.insert(6);
//        heap.insert(22);
//        heap.insert(9);

        int[] array = new int[]{4, 10, 3, 5, 1};
        Heap heap = new Heap(array.length);
        heap.buildMaxHeap(array);

        heap.print();

        System.out.println("The max val is " + heap.remove());
    }
}