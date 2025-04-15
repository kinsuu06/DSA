class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src] = 0;

        while (!q.isEmpty()) {
            int rv = q.poll();
            for (int nbrs : adj.get(rv)) {
                if (dis[nbrs] > dis[rv] + 1) {
                    dis[nbrs] = dis[rv] + 1;
                    q.add(nbrs);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = -1;
            }
        }

        return dis;
    }
}
