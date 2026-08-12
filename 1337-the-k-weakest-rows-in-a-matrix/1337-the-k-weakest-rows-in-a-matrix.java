class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {     //min heap banaya 
                return a[0] - b[0];   // fewer soldiers first
            }
            return a[1] - b[1];       // smaller index first
        });

        for (int i = 0; i < mat.length; i++) { //for i row

            int soldiers = 0;

            for (int j = 0; j < mat[i].length; j++) { //for j column 
                if (mat[i][j] == 1) {
                    soldiers++;
                }
            }

            pq.offer(new int[]{soldiers, i});   // num of sold or row add kr rhe hai pq me 
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}