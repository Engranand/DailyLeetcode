import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 1: freq count kro sabki 
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: set banao uniqueness chek k loye 
        
        //(unique ko apne aap hata deta hai set)
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int freq : map.values()) {
            // agar frequency already set me hai → duplicate
            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }
        
        return true;
    }
} 