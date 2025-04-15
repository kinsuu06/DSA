class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < V; i++) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            map.get(u).put(v, w);
        }

        int[] indegree = new int[V];
        for (int key : map.keySet()) {
            for (int nbrs : map.get(key).keySet()) {
                indegree[nbrs]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int idx = 0;
        while (!q.isEmpty()) {
            int rv = q.poll();
            topo[idx++] = rv;
            for (int nbr : map.get(rv).keySet()) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        for (int j = 0; j < V; j++) {
            int rv = topo[j];
            if (dis[rv] != Integer.MAX_VALUE) {
                for (int nbrs : map.get(rv).keySet()) {
                    int wt = map.get(rv).get(nbrs);
                    if (dis[nbrs] > dis[rv] + wt) {
                        dis[nbrs] = dis[rv] + wt;
                    }
                }
            }
        }

        for (int j = 0; j < V; j++) {
            if (dis[j] == Integer.MAX_VALUE) {
                dis[j] = -1;
            }
        }

        return dis;
    }
}
