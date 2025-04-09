class Solution {
    public int countNodes(TreeNode root) {
       if(root == null){
        return 0;
       } 
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       int count = 1;
       while(!q.isEmpty()){
        TreeNode r = q.poll();
        if(r.left != null){
            q.add(r.left);
            count++;
        }
        if(r.right != null){
            q.add(r.right);
            count++;
        }
       }
       return count;
    }
}
