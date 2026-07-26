import java.util.*;

class Solution {
    public int findLucky(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int answer = -1;

        // Check lucky numbers
        for (int number : map.keySet()) {

            if (map.get(number) == number) {
                answer = Math.max(answer, number);
            }
        }

        return answer;
    }
}