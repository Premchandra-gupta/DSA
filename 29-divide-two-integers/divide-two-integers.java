class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long a = dividend;
        long b = divisor;

        int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;

        long result = 0;

        while (a >= b) {
            long temp = b;
            long multiple = 1;

            while ((temp << 1) <= a) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        result = sign == -1 ? -result : result;

        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }
}