class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int current = i;

            while (nums[current] != -1) {
                int next = nums[current];
                nums[current] = -1;
                current = next;
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
