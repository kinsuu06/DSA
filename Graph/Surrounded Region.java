class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Stack<int[]> st = new Stack<>();
        boolean[][] visited = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for(int i=0; i<n; i++){
            if(grid[i][0] == 'O'){
                st.push(new int[]{i,0});
            }
            if(grid[i][m-1] == 'O') st.push(new int[] {i,m-1});
            
        }
        for(int i=0; i<m; i++){
            if(grid[0][i] == 'O'){
                st.push(new int[] {0,i});
            }
            if(grid[n-1][i] == 'O'){
                st.push(new int[]{n-1,i});
            }
        }
       
        while(!st.isEmpty()){
            int[] rv = st.pop();
            int r = rv[0];
            int c = rv[1];
            visited[r][c] = true;
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr > 0 && nr < n && nc > 0 && nc < m && grid[nr][nc] == 'O'){
                    if(!visited[nr][nc]) st.push(new int[]{nr,nc});
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]){
                    grid[i][j] = 'O';
                }else{
                    grid[i][j] = 'X';
                }
            }
        }
    }
}
