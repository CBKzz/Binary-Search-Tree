Actually, what if we have node with equal values? 
Let's say 1234456, and the successor of 4 could be 4 or 5?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null) return findSmallest(p.right);
        TreeNode temp=root;
        Stack<TreeNode> stack=new Stack<>();
        while(temp!=p){
            stack.push(temp);
            temp=p.val<temp.val?temp.left:temp.right;
        }
        while(!stack.isEmpty()){
            TreeNode result=stack.pop();
            if(result.val>p.val) return result;
        }
        return null;
    }
    public TreeNode findSmallest(TreeNode root){
        if(root.left!=null) return findSmallest(root.left);
        return root;
    }
}
