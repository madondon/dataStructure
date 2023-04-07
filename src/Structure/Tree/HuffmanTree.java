package Structure.Tree;

import java.util.PriorityQueue;

public class HuffmanTree {
    public Node root;

    private static class Node implements Comparable<Node> {
        int value;
        char ch;
        Node left;
        Node right;

        public Node(int value, char ch) {
            this.value = value;
            this.ch = ch;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node other) {
            return Integer.compare(value, other.value);
        }
    }

    public HuffmanTree(int[] freq, char[] chars) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < freq.length; i++) {
            pq.offer(new Node(freq[i], chars[i]));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.value + right.value, '-');
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }
        root = pq.poll();
    }

    private static void printCodes(Node node, String code) {
        if (node.isLeaf()) {
            System.out.println(node.ch + ": " + code);
        } else {
            printCodes(node.left, code + "0");
            printCodes(node.right, code + "1");
        }
    }

    public static void main(String[] args) {
        int[] freq = {5, 9, 12, 13, 16, 45};
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        HuffmanTree tree = new HuffmanTree(freq, chars);
        System.out.println("Huffman codes:");
        printCodes(tree.root, "");
    }


}
