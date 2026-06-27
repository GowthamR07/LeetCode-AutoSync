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
        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode>q=new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty()){
        int size=q.size();
        List<Integer>level=new ArrayList<>();
        for(int i=0;i<size;i++){
          TreeNode rootNode=q.poll();
          level.add(rootNode.val);
          if(rootNode.left!=null){
            q.offer(rootNode.left);
          }
          if(rootNode.right!=null){
            q.offer(rootNode.right);
          }
        }
         ans.add(level);
        }
        return ans;
    }
}