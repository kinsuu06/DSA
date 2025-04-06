class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ll;
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode curr = q.poll();
                ans.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            ll.add(new ArrayList<>(ans));
            
        }
        return ll;
    }
}
