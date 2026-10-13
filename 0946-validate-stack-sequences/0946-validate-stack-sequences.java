import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // Pointer for popped array

        for (int num : pushed) {
            stack.push(num); // Push current element onto the stack
            
            // Pop elements from stack as long as top matches popped[i]
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        // If stack is empty, all elements were matched and popped correctly
        return stack.isEmpty();
    }
}
        
    
