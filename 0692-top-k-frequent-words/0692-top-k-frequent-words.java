class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Frequency count kroa
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: PriorityQueue bnao
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {

            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b); //same freq k liye
            }

            return map.get(b) - map.get(a); //diff freq k liye
        });

        // Step 3: Add all words
        for (String word : map.keySet()) {
            pq.offer(word);
        }

        // Step 4: Get top k words
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(pq.poll());
        }

        return ans;
    }
}