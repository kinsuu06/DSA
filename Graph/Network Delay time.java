class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int t = time[2];
            map.get(u).put(v, t);
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;

       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(0, k - 1));

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int node = rv.node;
            int time = rv.time;

            if (!map.containsKey(node)) continue;

            for (int nbrs : map.get(node).keySet()) {
                int weight = map.get(node).get(nbrs);
                if (dis[nbrs] > time + weight) {
                    dis[nbrs] = time + weight;
                    pq.add(new Pair(dis[nbrs], nbrs));
                }
            }
        }

        int ans = 0;
        for (int i : dis) {
            if (i == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, i);
        }
        return ans;
    }

    class Pair {
        int time;
        int node;

        public Pair(int time, int node) {
            this.time = time;
            this.node = node;
        }
    }
}
