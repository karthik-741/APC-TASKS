import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // Copy initial prices
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Apply discount to all previous items where current price <= previous price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] -= prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}