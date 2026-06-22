class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        // Traverse string
        for (int i = 0; i < s.length(); i++) {

            // If stack is empty
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }

            // If top element is same
            if (st.peek() == s.charAt(i)) {
                st.pop();
                continue;
            }

            else{
            st.push(s.charAt(i));
        }}

        // Build result string
        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Reverse because stack pops in reverse order
        return res.reverse().toString();
    }
    }