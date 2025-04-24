class Solution {
    public boolean isBalanced(TreeNode root) {
        return func(root).isbal;
    }
    public bal func(TreeNode root){
        if(root == null){
            return new bal();
        }
        bal left = func(root.left);
        bal right = func(root.right);
        boolean con = Math.abs(left.height-right.height) <= 1;
        bal self = new bal();
        self.isbal = con && left.isbal && right.isbal;
        self.height = Math.max(left.height,right.height)+1;
        return self;
    }
    
    class bal{
        boolean isbal = true;
        int height = -1;
    }
}
