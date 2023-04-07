package Structure.Tree;

public class BinaryTreeArray {
    private int[] tree;

    public BinaryTreeArray(int[] array) {
        this.tree = array;
    }

    public void preOrderTraversal() {
        preOrderTraversal(1); // 从根节点开始遍历
    }

    private void preOrderTraversal(int index) {
        if (index >= tree.length || tree[index] == 0) { // 如果节点不存在，则返回
            return;
        }

        System.out.print(tree[index] + " "); // 访问节点
        preOrderTraversal(2 * index); // 遍历左子树
        preOrderTraversal(2 * index + 1); // 遍历右子树
    }

    public void inOrderTraversal() {
        inOrderTraversal(1); // 从根节点开始遍历
    }

    private void inOrderTraversal(int index) {
        if (index >= tree.length || tree[index] == 0) { // 如果节点不存在，则返回
            return;
        }

        inOrderTraversal(2 * index); // 遍历左子树
        System.out.print(tree[index] + " "); // 访问节点
        inOrderTraversal(2 * index + 1); // 遍历右子树
    }

    public void postOrderTraversal() {
        postOrderTraversal(1); // 从根节点开始遍历
    }

    private void postOrderTraversal(int index) {
        if (index >= tree.length || tree[index] == 0) { // 如果节点不存在，则返回
            return;
        }

        postOrderTraversal(2 * index); // 遍历左子树
        postOrderTraversal(2 * index + 1); // 遍历右子树
        System.out.print(tree[index] + " "); // 访问节点
    }

    public static void main(String[] args) {
        int[] array = {  0, 1, 2, 3, 0, 0, 6, 0, 0, 0, 0, 0, 0, 13}; // 数组下标从1开始
        BinaryTreeArray tree = new BinaryTreeArray(array);

        System.out.print("前序遍历：");
        tree.preOrderTraversal();

        System.out.print("\n中序遍历：");
        tree.inOrderTraversal();

        System.out.print("\n后序遍历：");
        tree.postOrderTraversal();
    }
}
