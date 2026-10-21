class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                color[i] = 0;

                if (!dfs(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int i, int[][] graph, int[] color) {

        for (int neighbor : graph[i]) {

            if (color[neighbor] == -1) {

                color[neighbor] = 1 - color[i];

                if (!dfs(neighbor, graph, color)) {
                    return false;
                }

            } else if (color[neighbor] == color[i]) {

                return false;
            }
        }

        return true;
    }
}