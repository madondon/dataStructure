package Structure.Tree;

class ChildSiblingTree {
    TreeNode root;

    private static class TreeNode {
        int val;
        TreeNode firstChild;
        TreeNode nextSibling;

        public  TreeNode(int val) {
            this.val = val;
            this.firstChild = null;
            this.nextSibling = null;
        }
    }

    public ChildSiblingTree() {
        this.root = null;
    }

    public void insert(int val) {
        TreeNode newNode = new TreeNode(val);
        if (this.root == null) {
            this.root = newNode;
        } else {
            TreeNode currentNode = this.root;
            while (currentNode.nextSibling != null) {
                currentNode = currentNode.nextSibling;
            }
            currentNode.nextSibling = newNode;
        }
    }

    public static void main(String[] args) {
        ChildSiblingTree tree = new ChildSiblingTree();
        tree.insert(1);
        TreeNode currentNode = tree.root;
        currentNode.firstChild=new TreeNode(2);
        tree.insert(3);
        System.out.println(tree.root.val);
        System.out.println(tree.root.nextSibling.val);
        System.out.println(tree.root.firstChild.val);
    }
}