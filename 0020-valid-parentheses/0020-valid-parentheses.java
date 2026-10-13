import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push matching closing brackets onto the stack for every opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If the stack is empty or the popped character doesn't match, string is invalid
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // Valid only if all opened brackets were matched and closed
        return stack.isEmpty();
    }
}