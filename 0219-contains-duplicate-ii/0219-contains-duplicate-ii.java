class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the element already exists in the set, duplicate found within distance k
            if (set.contains(nums[i])) {
                return true;
            }
            
            // Add current element to the sliding window
            set.add(nums[i]);
            
            // Maintain window size <= k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}     
    
