class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Tuple(i, j, 0));
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int maxTime = 0;

        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int time = curr.time;
            maxTime = Math.max(maxTime, time);

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;  
                    fresh--;
                    q.add(new Tuple(nr, nc, time + 1));
                }
            }
        }

        return fresh == 0 ? maxTime : -1;
    }

    class Tuple {
        int row, col, time;
        Tuple(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }
}
