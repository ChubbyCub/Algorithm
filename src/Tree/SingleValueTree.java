package Tree;

public class SingleValueTree {
    private static int count;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(3);

        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        count = 0;
        helper(root);
        System.out.println(count);

    }

    private static boolean helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        boolean left;
        boolean right;
        boolean self = true;

        if (root.left != null) {
            left = helper(root.left);
            self = root.left.val == root.val && left;
        }

        if (root.right != null) {
            right = helper(root.right);
            self = self && root.right.val == root.val && right;
        }

        if (self) count++;

        return self;
    }
}
