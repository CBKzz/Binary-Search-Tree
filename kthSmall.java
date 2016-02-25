/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //I use an array to record whether a subtree contains the value we are looking for. 
 //The first value denotes whether we find this value (0 means no and 1 means yes),and 
 //the second element is the value we return. Only when the first one is 1, do we use the second value.
 
 
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[]a =sub(root,k);
        return a[1];
    } 
    int count=0;
    public int[] sub(TreeNode root, int k) {
            int[] result=new int[2];
            TreeNode p=root;
            Stack<TreeNode> stack=new Stack<>();
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            while(!stack.isEmpty()){
                TreeNode temp=stack.pop();
                count++;
                if(k==count) {
                    result[0]=1;
                    result[1]=temp.val;
                    return result;
                    
                }
                if(temp.right!=null) {
                    int[] a=sub(temp.right,k);
                    if(a[0]==1) return a;
                }
            }
            return result;//result[0]=0;
    }
}
