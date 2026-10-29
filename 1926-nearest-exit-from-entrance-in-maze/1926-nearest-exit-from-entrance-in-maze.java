class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] distance = new int[rows][cols];

        int startRow = entrance[0];
        int startCol = entrance[1];

        queue.add(new int[]{startRow, startCol});
        maze[startRow][startCol] = '+';

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int i = current[0];
            int j = current[1];

            if ((i == 0 || i == rows - 1 ||
                 j == 0 || j == cols - 1) &&
                !(i == startRow && j == startCol)) {

                return distance[i][j];
            }

            for (int k = 0; k < 4; k++) {

                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni >= 0 && ni < rows &&
                    nj >= 0 && nj < cols &&
                    maze[ni][nj] == '.') {

                    maze[ni][nj] = '+';

                    distance[ni][nj] =
                        distance[i][j] + 1;

                    queue.add(new int[]{ni, nj});
                }
            }
        }

        return -1;
    }}
