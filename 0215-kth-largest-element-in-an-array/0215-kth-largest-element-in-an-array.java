import java.util.*;

class Solution {
    public int findKthLargest(int[] a, int k) {

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // First k elements
        for (int i = 0; i < k; i++) {
            pq.offer(a[i]);
        }

        // Remaining elements
        for (int i = k; i < a.length; i++) {

            if (a[i] <= pq.peek())
                continue;

            pq.poll();
            pq.offer(a[i]);
        }

        return pq.peek();
    }
}