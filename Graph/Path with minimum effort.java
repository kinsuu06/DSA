class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2){
                return o1.dis-o2.dis;
            }
        });

        int[][] dis = new int[n][m];
        for(int[] i : dis){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        pq.add(new Pair(0, 0,0));
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            int diff = rv.dis;
            int cr = rv.row;
            int cc = rv.col;
            if(cr == n-1 && cc == m-1) return diff;
            for(int i=0; i<4; i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                int newEffort = Math.max(Math.abs(heights[cr][cc] - heights[nr][nc]),diff);
                if(newEffort < dis[nr][nc]){
                    dis[nr][nc] = newEffort;
                    pq.add(new Pair(newEffort, nr, nc));
                }
                }
            }
        }
        return -1;
    }
    class Pair{
        int dis;
        int row;
        int col;
        public Pair(int dis, int row, int col){
            this.dis = dis;
            this.row = row;
            this.col = col; 
        }
    }
}
