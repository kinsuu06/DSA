class Solution {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if(root == null){
            return ans;
        }
        q.add(new Tuple(root,0));
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            Node node = curr.node;
            int c = curr.col;
            if(!map.containsKey(c)){
                map.put(c,node.data);
            }
            if(node.left != null){
                q.add(new Tuple(node.left,c-1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right,c+1));
            }
        }
        for(int i : map.values()){
            ans.add(i);
        }
        return ans;
    }
}
class Tuple{
    Node node;
    int col;
    public Tuple(Node _node, int _col){
        node = _node;
        col = _col;
    }
}
