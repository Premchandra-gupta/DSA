class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int p : piles) {
            if (p > high) high = p;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int hours = 0;
            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }

            if (hours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
