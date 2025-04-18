import java.util.*;

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int wt = rv.dis;
            int node = rv.node;

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for (int[] nbrs : adj.get(node)) {
                int nn = nbrs[0];  // Neighbor node
                int ew = nbrs[1];  // Edge weight
                if (!visited[nn]) {
                    pq.add(new Pair(ew, nn));
                }
            }
        }
        return sum;
    }

    static class Pair {
        int dis;
        int node;

        public Pair(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }
    }
}
