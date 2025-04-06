class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        int m = 0;
        while(!q.isEmpty()){
            List<Integer> ll = new ArrayList<>();
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode curr = q.poll();
                ll.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                
                
            }
            if(m % 2 == 0){
                ans.add(ll);
            }else{
                Collections.reverse(ll);
                ans.add(ll);
            }
            m++; 
        }
        return ans;
    }
}
