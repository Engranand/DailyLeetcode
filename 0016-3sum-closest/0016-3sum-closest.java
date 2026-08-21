import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;
        int diff = Integer.MAX_VALUE;  // stores minimum difference
        int resSum = 0;                // stores closest sum

        // Step 2: Fix one element and use two pointers
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int total = nums[i] + nums[left] + nums[right];
                int d = Math.abs(target - total);

                // Step 3: Update closest sum if better found
                if (d < diff) {
                    diff = d;
                    resSum = total;
                }

                // Step 4: Exact match → best possible answer
                if (total == target) {
                    return resSum;
                }
                // Step 5: Move pointers
                else if (total < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resSum;
    }
}
