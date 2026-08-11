class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);

            if (distA != distB) {
                return distB - distA; 
            }

            return b - a;
        });

        for (int num : arr) { // pehle loop chelga do elemt add hoga fir compare hoga isme a,b 
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.sort(ans);

        return ans;
    }
}