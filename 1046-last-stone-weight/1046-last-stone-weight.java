import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder()); //max heap banaya 

        for (int stone : stones) {
            pq.add(stone); //add stone to pq acc to max heap 
        }

        while (pq.size() > 1) {

            int y = pq.poll();
            int x = pq.poll();

            if (x != y) { //diff weight 
                pq.add(y - x);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        }

        return pq.poll();
    }
}