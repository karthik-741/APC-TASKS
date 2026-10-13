import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;

            // Collision condition: Top of stack moving right (> 0) and current asteroid moving left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (stack.peek() < -ast) {
                    // Stack top is smaller, it explodes; continue checking collisions
                    stack.pop();
                    continue;
                } else if (stack.peek() == -ast) {
                    // Both asteroids are equal size, both explode
                    stack.pop();
                }
                // Current asteroid exploded (either smaller or equal)
                exploded = true;
                break;
            }

            // If current asteroid survived all collisions, add to stack
            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}