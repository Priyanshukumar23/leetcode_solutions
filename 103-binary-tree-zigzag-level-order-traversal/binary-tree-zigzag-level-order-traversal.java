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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> at = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        if(root==null)return at;
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int t = q.size();
            ArrayList<Integer>lv = new ArrayList<>();
            for(int i=1;i<=t;i++){
                TreeNode node = q.poll();
                lv.add(node.val);
                
                    if(node.left!=null)q.add(node.left);
                    if(node.right!=null)q.add(node.right);
                
            }
            if(level%2!=0){
                Collections.reverse(lv);
            }
                at.add(lv);
                level++;
        }
        return at;
    }
}