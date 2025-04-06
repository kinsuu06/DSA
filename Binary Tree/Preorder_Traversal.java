class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        preorder(root,ll);
        return ll;
    }
    public void preorder(TreeNode root,List<Integer> ll){
        if(root == null) return;
        ll.add(root.val);
        preorder(root.left,ll);
        preorder(root.right,ll);
    }
}
