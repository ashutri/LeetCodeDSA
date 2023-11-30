class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private void bfs(int ro, int co, int[][] vis, char[][] grid, int[] delRow, int[] delCol) {
      vis[ro][co] = 1; 
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(ro, co)); 
      int n = grid.length; 
      int m = grid[0].length; 
      
      // until the queue becomes empty
      while(!q.isEmpty()) {
          int row = q.peek().first; 
          int col = q.peek().second; 
          q.remove(); 
          
          // traverse in the neighbours and mark them if its a land 
          for(int i = 0;i<4;i++) {
                  int nrow = row + delRow[i]; 
                  int ncol = col + delCol[i]; 
          // check if neighbour row and column is valid, and is an unvisited land
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                  && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1; 
                      q.add(new Pair(nrow, ncol)); 
                  }
              
          }
      }
  }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        int[][] vis = new int[n][m];
        int cnt = 0; 
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < m ;col++) {
                // if not visited and is a land
                if(vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++; 
                    bfs(row, col, vis, grid, delRow, delCol); 
                }
            }
        }
        return cnt; 
    }
}