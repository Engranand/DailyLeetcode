class Solution {
    public int maxValidPairSum(int[] nums, int k) {

        // Left side ka maximum eligible element
        int maxLeft = nums[0];

        // Maximum pair sum store karega
        int ans = Integer.MIN_VALUE;

        // j ko k se start karenge kyuki usse pehle valid pair possible nahi hai
        for (int j = k; j < nums.length; j++) {

            // Naya eligible left index (j-k) ko consider karo
            maxLeft = Math.max(maxLeft, nums[j - k]);

            // Current j ke saath best left element ka sum nikalo
            ans = Math.max(ans, maxLeft + nums[j]);
        }

        return ans;
    }
}  
        
        
