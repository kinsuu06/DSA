class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i=1; i<=isConnected.length; i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected.length; j++)
            if(isConnected[i][j] == 1){
                adj.get(i+1).add(j+1);
            }
        }
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int src : adj.keySet()){
            if(visited.contains(src)){
                count++;
                continue;
            }
            q.add(src);
            while(!q.isEmpty()){
                int rv = q.poll();
                visited.add(rv);
                for(int nbrs : adj.get(rv)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
        }
        return isConnected.length-count;
    }
}
