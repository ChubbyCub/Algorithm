package Tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsOfATree {
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

        System.out.println(printAllPaths(root));
    }

    private static List<List<Integer>> printAllPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, new ArrayList<>());
        return result;
    }

    private static void helper(TreeNode root, List<List<Integer>> result, List<Integer> soFar) {
        if (root.left == null && root.right == null) {
            soFar.add(root.val);
            result.add(new ArrayList<>(soFar));
            soFar.remove(soFar.size() - 1);
            return;
        }

        soFar.add(root.val);
        helper(root.left, result, soFar);
        helper(root.right, result, soFar);
        soFar.remove(soFar.size() - 1);
    }
}
