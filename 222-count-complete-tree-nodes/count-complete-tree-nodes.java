class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = leftHeight(root);
        int right = rightHeight(root);

        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    private int rightHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.right;
        }

        return h;
    }
}