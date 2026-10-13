class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store frequencies in a bucket array
        // freqCount[f] stores the count of numbers that appear 'f' times
        int n = arr.length;
        int[] freqCount = new int[n + 1];
        for (int count : map.values()) {
            freqCount[count]++;
        }

        int uniqueCount = map.size();

        // Step 3: Remove elements starting from the smallest frequency
        for (int freq = 1; freq <= n; freq++) {
            if (freqCount[freq] > 0) {
                // Determine how many unique numbers with this frequency we can completely eliminate
                int removeables = Math.min(uniqueCount, Math.min(freqCount[freq], k / freq));
                
                uniqueCount -= removeables;
                k -= removeables * freq;

                // If k is insufficient to fully remove the next element of this frequency, stop
                if (k < freq) {
                    break;
                }
            }
        }

        return uniqueCount;
    }
}      
    
