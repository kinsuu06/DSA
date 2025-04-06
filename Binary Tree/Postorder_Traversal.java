class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        postorder(root,ll);
        return ll;
    }
    public void postorder(TreeNode root, List<Integer> ll){
        if(root == null) return;
        postorder(root.left,ll);
        postorder(root.right,ll);
        ll.add(root.val);
    }
}
