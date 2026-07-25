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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int[] inorder, int prestart, int instart, int inEnd){
        if(prestart>preorder.length-1 || instart>inEnd)return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int idx = 0;
        for(int i=instart;i<=inEnd;i++){
            if(inorder[i]==root.val){
                idx = i;
                break;
            }
        }
        root.left = build(preorder,inorder,prestart+1,instart,idx-1);
        root.right = build(preorder,inorder,prestart+idx-instart+1,idx+1,inEnd);
        return root;
    }
}