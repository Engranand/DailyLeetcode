class Solution {
    int n;
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {

        n = grid.length;

        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
        }

        int[][] distance = new int[n][n];

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int i = current[0];
            int j = current[1];

            for (int k = 0; k < 4; k++) {

                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni >= 0 && ni < n &&
                    nj >= 0 && nj < n) {

                    if (grid[ni][nj] == 1) {
                        return distance[i][j];
                    }

                    if (grid[ni][nj] == 0) {

                        grid[ni][nj] = 2;

                        distance[ni][nj] =
                            distance[i][j] + 1;

                        queue.add(new int[]{ni, nj});
                    }
                }
            }
        }

        return -1;
    }

    private void dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= n ||
            j < 0 || j >= n ||
            grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        queue.add(new int[]{i, j});

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}