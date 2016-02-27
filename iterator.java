Stack<TreeNode> stack=new Stack<>();
public BSTIterator(TreeNode root) {
    inorderTravel(root);
}

/** @return whether we have a next smallest number */
public boolean hasNext() {
    return !stack.isEmpty();
}

/** @return the next smallest number */
public int next() {
    return stack.pop().val;   
}
public void inorderTravel(TreeNode root){
    if(root==null) return;
    inorderTravel(root.right);
    stack.push(root);
    inorderTravel(root.left);
}




Stack<TreeNode> stack=new Stack<>();
public BSTIterator(TreeNode root) {
    while(root!=null){
        stack.push(root);
        root=root.left;
    }
}

/** @return whether we have a next smallest number */
public boolean hasNext() {
    return !stack.isEmpty();
}

/** @return the next smallest number */
public int next() {
    TreeNode result=stack.pop();
    TreeNode temp=result.right;
    while(temp!=null){
        stack.push(temp);
        temp=temp.left;
    }
    return result.val;
}
