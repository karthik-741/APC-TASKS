class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate total sum of array elements initially treated as rightSum
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            // Remove current element from rightSum
            rightSum -= nums[i];
            
            // Calculate total difference using left and right elements
            int leftCount = i;
            int rightCount = n - 1 - i;
            
            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            
            result[i] = leftTotal + rightTotal;
            
            // Add current element to leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return result;
    }
}     
    
