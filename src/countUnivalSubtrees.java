// Node class for Binary Tree
class TreeNode {
    int val;
    TreeNode left, right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }
}

public class countUnivalSubtrees {

    // Global count variable to track unival subtrees
    private int count = 0;

    // Public function to count unival subtrees
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);   // Run post-order DFS
        return count;
    }

    // Helper DFS: returns true if subtree rooted at "node" is univalue
    private boolean dfs(TreeNode node) {
        if (node == null) return true;

        boolean leftUni = dfs(node.left);
        boolean rightUni = dfs(node.right);

        if (!leftUni || !rightUni) return false;

        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count++;  // This node is root of a univalue subtree
        return true;
    }

    // ---------- Testing ----------
    public static void main(String[] args) {
        // Build example tree
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);

        countUnivalSubtrees sol = new countUnivalSubtrees();
        int ans = sol.countUnivalSubtrees(root);

        System.out.println("Number of univalue subtrees: " + ans);
    }
}
