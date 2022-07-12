package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {
    public static void main(String[] args) {

    }

    private static List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.peek();
            if (currNode.left != null) {
                stack.push(currNode.left);
                currNode.left = null;
            } else if (currNode.right != null) {
                stack.push(currNode.right);
                currNode.right = null;
            } else {
                result.add(currNode.val);
                stack.pop();
            }
        }

        return result;
    }
}
