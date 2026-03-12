class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // case 1: both nodes are null
        if(p == null && q == null){
            return true;
        }
        
        // case 2: one is null
        if(p == null || q == null){
            return false;
        }
        
        // case 3: values not equal
        if(p.val != q.val){
            return false;
        }
        
        // case 4: check left and right subtree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}