class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (pow(5, even) * pow(4, odd)) % MOD;

        return (int) ans;
    }

    private long pow(long x, long n) {
        if (n == 0) return 1;

        long half = pow(x, n / 2);

        long res = (half * half) % MOD;

        if (n % 2 == 1)
            res = (res * x) % MOD;

        return res;
    }
}