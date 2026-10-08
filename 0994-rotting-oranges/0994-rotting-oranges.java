class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Step 1: Find all rotten oranges
        // and count fresh oranges
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {

                    queue.add(new int[]{i, j});

                } else if (grid[i][j] == 1) {

                    fresh++;
                }
            }
        }

        int minutes = 0;

        // Step 2: Multi-source BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process all oranges from the current minute
            while (size > 0) {

                int[] current = queue.poll();

                int i = current[0];
                int j = current[1];

                // Up
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {

                    grid[i - 1][j] = 2;
                    fresh--;

                    queue.add(new int[]{i - 1, j});
                }

                // Down
                if (i + 1 < rows && grid[i + 1][j] == 1) {

                    grid[i + 1][j] = 2;
                    fresh--;

                    queue.add(new int[]{i + 1, j});
                }

                // Left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {

                    grid[i][j - 1] = 2;
                    fresh--;

                    queue.add(new int[]{i, j - 1});
                }

                // Right
                if (j + 1 < cols && grid[i][j + 1] == 1) {

                    grid[i][j + 1] = 2;
                    fresh--;

                    queue.add(new int[]{i, j + 1});
                }

                size--;
            }

            // One BFS level = one minute
            minutes++;
        }

        // Step 3: Check if all fresh oranges became rotten
        if (fresh == 0) {
            return minutes;
        }

        return -1;
    }
}