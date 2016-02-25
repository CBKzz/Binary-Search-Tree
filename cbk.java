tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return sub(root,k);
    } 
    int count=0;
    public int sub(TreeNode root, int k) {
            
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
                    return temp.val;
                    
                }
                if(temp.right!=null) {
                    int a=sub(temp.right,k);
                    if(a!=null) return a;
                }
            }
            return null;//result[0]=0;
    }
}
