 import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLength = 0;
        int left = 0; // Left pointer of the window
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the set, remove characters from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the set
            set.add(currentChar);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }    
    }
