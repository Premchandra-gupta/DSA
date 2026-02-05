class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int n : nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int subarrays = 1;
            int currSum = 0;

            for (int n : nums) {
                if (currSum + n > mid) {
                    subarrays++;
                    currSum = 0;
                }
                currSum += n;
            }

            if (subarrays <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
