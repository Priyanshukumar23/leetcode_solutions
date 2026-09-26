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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> at = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        if(root==null)return at;
        q.add(root);
        while(!q.isEmpty()){
            int t = q.size();
            ArrayList<Integer>lv = new ArrayList<>();

            for(int i=0;i<t;i++){
                TreeNode nd = q.poll();

                lv.add(nd.val);
                if(nd.left!=null)q.add(nd.left);
                if(nd.right!=null)q.add(nd.right);
                
            }

            at.add(lv);
        }
        return at;
    }
}