package Tree;

public class IsBST {
    private static TreeNode prev;
    public static void main(String[] args) {
        prev = null;
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(5);

        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;
        System.out.println(helper(root));
    }

    private static boolean helper(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        if (!helper(root.left)) return false;

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;

        return helper(root.right);
    }
}
