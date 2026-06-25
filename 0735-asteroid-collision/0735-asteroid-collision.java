import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Top asteroid is smaller, so it explodes
                    stack.pop();
                }
                else if (stack.peek() == -asteroid) {
                    // Both are equal, both explode
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else {
                    // Current asteroid is smaller, so it explodes
                    destroyed = true;
                    break;
                }
            }

            // If current asteroid survives, push it
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] ans = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }
} 