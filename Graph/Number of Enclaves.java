class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m 
                   && grid[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
}
