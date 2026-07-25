
 
 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int CurrentCount = 0;
        int MaxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                CurrentCount++;
            } else {
                MaxCount = Math.max(CurrentCount, MaxCount);
                CurrentCount = 0;
            }
        }

        return Math.max(MaxCount, CurrentCount);
    }
}