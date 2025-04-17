class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dis = new int[V];
        Arrays.fill(dis,(int)(1e8));
        dis[src] = 0;
        for(int i=0; i<V-1; i++){
            for(int[] arr : edges){
                int u = arr[0];
                int v = arr[1];
                int wt = arr[2];
                if(dis[u] != 1e8 && dis[u] + wt < dis[v]){
                    dis[v] = dis[u] + wt;
                }
            }
        }
        // check negative cycle
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            if(dis[u] != 1e8 && dis[u] + wt < dis[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dis;
    }
}
