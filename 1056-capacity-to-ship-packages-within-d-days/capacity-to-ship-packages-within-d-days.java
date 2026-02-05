class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int requiredDays = 1;
            int currLoad = 0;

            for (int w : weights) {
                if (currLoad + w > mid) {
                    requiredDays++;
                    currLoad = 0;
                }
                currLoad += w;
            }

            if (requiredDays <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
