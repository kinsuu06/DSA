class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int col = image[sr][sc];
        if(col == color) return image;
        image[sr][sc] = color;
        Queue<Tuple> q = new LinkedList<>();
         
        q.add(new Tuple(sr,sc));
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!q.isEmpty()){
            Tuple rv = q.poll();
            int r = rv.row;
            int c = rv.col;
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == col){
                    image[nr][nc] = color;
                    q.add(new Tuple(nr,nc));
                }
            }
        }
        return image;
    }
    class Tuple {
        int row, col;
        Tuple(int r, int c) {
            row = r;
            col = c;
        }
    } 
}
