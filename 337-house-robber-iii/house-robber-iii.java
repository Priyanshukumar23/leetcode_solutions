class Solution {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // returns {rob, notRob}
    public int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we rob current node, cannot rob children
        int rob = node.val + left[1] + right[1];

        // If we don't rob current, take best of children
        int notRob = Math.max(left[0], left[1]) + 
                     Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}