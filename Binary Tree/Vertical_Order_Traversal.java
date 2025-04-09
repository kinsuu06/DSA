class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col){
        node = _node;
        row = _row;
        col = _col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int r = curr.row;
            int c = curr.col;
            if(!map.containsKey(c)){
                map.put(c,new TreeMap<>());
            }
            if(!map.get(c).containsKey(r)){
                map.get(c).put(r, new PriorityQueue<Integer>());
            }
            map.get(c).get(r).add(node.val);
            if(node.left != null){
                q.add(new Tuple(node.left, r+1, c-1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right, r+1, c+1));
            }
        } 
        List<List<Integer>> ll = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> m : map.values()){
            List<Integer> ans = new ArrayList<>();
            for(PriorityQueue<Integer> pq : m.values()){
                while(!pq.isEmpty()){
                    ans.add(pq.poll());
                }
            }
            ll.add(ans);
        }
        return ll;
    }
}
