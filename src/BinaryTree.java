class TreeNode {
    int data; //
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

@SuppressWarnings("ALL")
public class BinaryTree {
    private TreeNode root;

    public int countNodes(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        return (node.data == x && node.leftChild != null && node.rightChild != null ? 1 : 0)
                + countNodes(node.leftChild, x)
                + countNodes(node.rightChild, x);
    }

    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.data + " ");
            inorder(node.rightChild);
        }
    }

    public void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    public void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode mergedNode = new TreeNode(t1.data + t2.data);
        mergedNode.leftChild = mergeTrees(t1.leftChild, t2.leftChild);
        mergedNode.rightChild = mergeTrees(t1.rightChild, t2.rightChild);

        return mergedNode;
    }

    public void printMergedTree(TreeNode t1, TreeNode t2) {
        TreeNode mergedRoot = mergeTrees(t1, t2);
        System.out.println("Merged tree (Inorder traversal):");
        inorder(mergedRoot);
        System.out.println();
    }

    public void printInorder() {
        inorder(root);
    }

    public void printPreorder() {
        preorder(root);
    }

    public void printPostorder() {
        postorder(root);
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new TreeNode(1);
        tree1.root.leftChild = new TreeNode(3);
        tree1.root.rightChild = new TreeNode(2);
        tree1.root.leftChild.leftChild = new TreeNode(5);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new TreeNode(2);
        tree2.root.leftChild = new TreeNode(1);
        tree2.root.rightChild = new TreeNode(3);
        tree2.root.leftChild.rightChild = new TreeNode(4);
        tree2.root.rightChild.rightChild = new TreeNode(7);

        int x = 2;
        int count = tree1.countNodes(tree1.root, x);
        System.out.println("Number of nodes with value " + x + " and degree 2: " + count);

        System.out.println("\nInorder traversal:");
        tree1.printInorder();

        System.out.println("\nPreorder traversal:");
        tree1.printPreorder();

        System.out.println("\nPostorder traversal:");
        tree1.printPostorder();

        BinaryTree mergedTree = new BinaryTree();
        mergedTree.printMergedTree(tree1.root, tree2.root);
    }
}
