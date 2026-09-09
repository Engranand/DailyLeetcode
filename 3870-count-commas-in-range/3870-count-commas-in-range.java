class Solution {
    public int countCommas(int n) {
    
        int ans = 0;

        for (long threshold = 1000; threshold <= n; threshold *= 1000) {
            ans += n - threshold + 1;
        }

        return ans;
    }
}
    