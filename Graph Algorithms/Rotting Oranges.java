class Solution {
  class Pair {
    int x;
    int y;

    Pair(int _x, int _y) {
      x = _x;
      y = _y;
    }
  }

  public boolean isValid(int x, int y, int grid[][]) {
    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1)
      return true;
    return false;
  }

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    boolean isFreshOrange = false;
    
    Queue<Pair> q = new LinkedList<>();
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1)
          isFreshOrange = true;

        if (grid[i][j] == 2) {
          q.add(new Pair(i, j));
        }
      }
    }

    if (!isFreshOrange)// [[0,2]]
      return 0;

    int minTime = 0;
    while (!q.isEmpty()) {
      int qsize = q.size();
      while (qsize-- > 0) {
        Pair top = q.poll();
        int topX = top.x;
        int topY = top.y;

        int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int d[] : dir) {
          if (isValid(topX + d[0], topY + d[1], grid)) {
            q.add(new Pair(topX + d[0], topY + d[1]));
            grid[topX + d[0]][topY + d[1]] = 2;
          }
        }

      }
      minTime++;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1)
          return -1;
      }
    }

    return minTime - 1;

  }
}
