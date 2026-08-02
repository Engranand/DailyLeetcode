class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = totalHours(piles, mid);

            if (hours <= h) {
                // Current speed works, try smaller speed
                high = mid - 1;
            } else {
                // Current speed is too slow
                low = mid + 1;
            }
        }

        return low;
    }

    // Find maximum pile
    public int findMax(int[] piles) {

        int max = piles[0];

        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        return max;
    }

    // Calculate total hours needed at given speed
    public long totalHours(int[] piles, int speed) {

        long hours = 0;

        for (int pile : piles) {
            hours += (long) Math.ceil((double) pile / speed);
        }

        return hours;
    }
}