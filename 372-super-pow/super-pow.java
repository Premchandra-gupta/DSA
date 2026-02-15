class Solution {
    
    static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        
        int result = 1;
        a %= MOD;
        
        for (int digit : b) {
            result = pow(result, 10) * pow(a, digit) % MOD;
        }
        
        return result;
    }
    
    private int pow(int x, int n) {
        int result = 1;
        
        x %= MOD;
        
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x % MOD;
            }
            x = x * x % MOD;
            n /= 2;
        }
        
        return result;
    }
}
