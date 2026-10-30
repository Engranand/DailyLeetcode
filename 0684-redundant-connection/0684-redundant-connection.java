//by using dsu(union find) not optimised dsu (rank,compression)

class Solution {

    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[] answer = new int[2];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                answer = edge;
            } else {
                parent[rootV] = rootU;
            }
        }

        return answer;
    }

    private int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}