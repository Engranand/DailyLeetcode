
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1; //chadhai peak milega aaaaaage orr
            } else {
                res = mid;       // store possible peak
                high = mid - 1;  // search left for peak
            }
        }

        return res;
    }
}