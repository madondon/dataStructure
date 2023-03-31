package Structure.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTreeList {
    TreeNode root;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTreeList() {
        this.root = null;
    }

    public void insert(int val) {
        TreeNode newNode = new TreeNode(val);
        if (this.root == null) {
            this.root = newNode;
        } else {
            TreeNode currentNode = this.root;
            while (true) {
                if (val < currentNode.val) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public void preOrderTraversalStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                System.out.print(currentNode.val + " ");
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            currentNode = currentNode.right;
        }
    }

    public void inOrderTraversalStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
    }

    public void postOrderTraversalStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty()) {
            TreeNode currentNode = stack1.pop();
            stack2.push(currentNode);

            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }

            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }

    public void LevelOrderTraversal(TreeNode node) {
        if (node != null) {
            Queue<TreeNode> queue=new LinkedList<>();
            TreeNode currentNode=node;
            queue.offer(node);

            while (!queue.isEmpty()) {
                currentNode=queue.poll();
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                System.out.print(currentNode.val+" ");
            }
        }
    }
    public static void main(String[] args) {
        BinaryTreeList tree = new BinaryTreeList();
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.preOrderTraversal(tree.root);
        System.out.println();
        tree.preOrderTraversalStack(tree.root);
        System.out.println();
        tree.inOrderTraversal(tree.root);
        System.out.println();
        tree.inOrderTraversalStack(tree.root);
        System.out.println();
        tree.postOrderTraversal(tree.root);
        System.out.println();
        tree.postOrderTraversalStack(tree.root);
        System.out.println();
        tree.LevelOrderTraversal(tree.root);

    }
}
