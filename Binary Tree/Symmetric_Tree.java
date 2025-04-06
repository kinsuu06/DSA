class Solution {
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
        
    }
    public boolean solve(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        
        if(p.val != q.val ){
            return false;
        }
        boolean b1 = solve(p.left,q.right);
        boolean b2 = solve(p.right,q.left);
        return b1&&b2;

    }
}
