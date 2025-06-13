class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] arr = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !(arr[i][j])){
                    cnt++;
                    bfs(i, j, arr, grid);
                }
            }
        }
        return cnt;
    }
    public void bfs(int i, int j, boolean[][] arr, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{i,j});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            for(int k=0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !(arr[nr][nc]) && grid[nr][nc] == '1'){
                    arr[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
