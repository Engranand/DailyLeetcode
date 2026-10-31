class Solution {

    int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {

            if (equation.charAt(1) == '=') {

                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';

                union(a, b);
            }
        }

        for (String equation : equations) {

            if (equation.charAt(1) == '!') {

                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';

                if (find(a) == find(b)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}