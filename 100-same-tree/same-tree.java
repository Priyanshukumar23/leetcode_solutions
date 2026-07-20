/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode>q1 = new LinkedList<>();
        Queue<TreeNode>q2 = new LinkedList<>();
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        q1.offer(p);
        q2.offer(q);
        if(q1.size()!=q2.size())return false;
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode cur = q1.poll();
            TreeNode pr = q2.poll();
            if(cur.val!=pr.val)return false;
            if ((cur.left == null) != (pr.left == null))
    return false;

if ((cur.right == null) != (pr.right == null))
    return false;
            if(cur.left!=null){
                q1.offer(cur.left);
            }
            if(cur.right!=null){
                q1.offer(cur.right);
            }
            if(pr.left!=null){
                q2.offer(pr.left);
            }
            if(pr.right!=null){
                q2.offer(pr.right);
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}