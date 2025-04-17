class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1,Pair o2){
                return o1.dis-o2.dis;
            }
        });
        boolean[][] visited = new boolean[n][n];
        
        int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

        pq.add(new Pair(1, 0, 0)); 

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int cr = rv.r;
            int cc = rv.c;
            int dist = rv.dis;

            if (cr == n - 1 && cc == n - 1) return dist;

            if (visited[cr][cc]) {
                continue;
            }
            visited[cr][cc] = true;

            for (int i = 0; i < 8; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 0) {
                    pq.add(new Pair(dist + 1, nr, nc));
                }
            }
        }

        return -1; 
    }

    class Pair {
        int dis, r, c;
        public Pair(int dis, int r, int c) {
            this.dis = dis;
            this.r = r;
            this.c = c;
        }
    }
}
