package binarySearchTree;

public class BinarySearchTree {
    private static TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public static TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // Метод за добавяне на елемент в BST
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val >= root.val)
            root.right = insertRec(root.right, val);
        else
            root.left = insertRec(root.left, val);

        return root;
    }

    // Метод за търсене на елемент в BST
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(TreeNode root, int val) {
        if (root == null)
            return false;

        if (root.val == val)
            return true;

        if (val < root.val)
            return searchRec(root.left, val);
        else
            return searchRec(root.right, val);
    }

    // Метод за намиране на път до елемент в BST
    public String findPath(int val) {
        return findPathRec(root, val);
    }

    private String findPathRec(TreeNode root, int val) {
        if (root == null)
            return "";

        if (root.val == val)
            return String.valueOf(root.val);

        if (val < root.val)
            return root.val + " -> " + findPathRec(root.left, val);
        else
            return root.val + " -> " + findPathRec(root.right, val);
    }

    // Метод за изтриване на елемент от BST
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private TreeNode deleteRec(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val < root.val)
            root.left = deleteRec(root.left, val);
        else if (val > root.val)
            root.right = deleteRec(root.right, val);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);

            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

}
