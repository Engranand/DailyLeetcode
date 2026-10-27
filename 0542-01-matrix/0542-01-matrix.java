class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int i = current[0];
            int j = current[1];

            for (int k = 0; k < 4; k++) {

                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni >= 0 && ni < rows &&
                    nj >= 0 && nj < cols &&
                    !visited[ni][nj]) {

                    distance[ni][nj] = distance[i][j] + 1;

                    visited[ni][nj] = true;

                    queue.add(new int[]{ni, nj});
                }
            }
        }

        return distance;
    }
}