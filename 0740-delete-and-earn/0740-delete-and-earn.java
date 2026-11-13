class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[max + 1];

        Arrays.fill(dp, -1);

        return solve(0, points, dp);
    }

    public int solve(int i, int[] points, int[] dp) {

        if (i >= points.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = points[i] + solve(i + 2, points, dp);

        int notPick = solve(i + 1, points, dp);

        dp[i] = Math.max(pick, notPick);

        return dp[i];
    }
}