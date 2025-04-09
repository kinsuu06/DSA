// 0(N^2)

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int s = height(root.left)+height(root.right)+2;
        return Math.max(s,Math.max(left,right));
    }
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }
}


//O(N)

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).dia;
    }
    public diapair diameter(TreeNode root){
        if(root == null){
            return new diapair();
        }
        diapair left = diameter(root.left);
        diapair right = diameter(root.right);
        diapair self = new diapair();
        int d = left.ht + right.ht + 2;
        self.ht = Math.max(left.ht,right.ht)+1;
        self.dia = Math.max(d,Math.max(left.dia,right.dia));
        return self;
    }
    class diapair{
        int dia = 0;
        int ht = -1;
    }
}
