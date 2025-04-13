class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<graph[i].length; j++){
                int to = graph[i][j];
                map.get(to).add(i);  
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int rv =q.poll();
            ans.add(rv);
            for(int nbr : map.get(rv)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        Collections.sort(ans);  
        return ans;

    }
}
