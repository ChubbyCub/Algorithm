package Tree;

public class LCA {
    public static void main(String[] args) {

    }

    private static Status lcaHelper(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return new Status(0, null);
        }

        Status leftResult = lcaHelper(root.left, a, b);
        if (leftResult.numTargetNodes == 2) return leftResult;
        Status rightResult = lcaHelper(root.right, a, b);
        if (rightResult.numTargetNodes == 2) return rightResult;

        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes + (root == a ? 1 : 0) + (root == b ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? root : null);
    }

    private static class Status {
        public int numTargetNodes;
        public TreeNode ancestor;
        public Status(int numTargetNodes, TreeNode node) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = node;
        }
    }
}
