package Tree;

public class ConvertBSTToSortedDoublyLinkedList {
    private static TreeNode sentinel = new TreeNode(0);
    private static TreeNode pred = sentinel;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(5);

        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        treeToDoublyList(root);
    }

    private static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        makeListDfs(root);

        pred.right = sentinel.right;
        sentinel.right.left = pred;
        return sentinel.right;
    }

    private static void makeListDfs(TreeNode root) {
            if (root.left != null) makeListDfs(root.left);

        pred.right = root;
        root.left = pred;
        pred = root;

        if (root.right != null) makeListDfs(root.right);
    }
}
