//Approach - Simple observation and maths factorial
// Ensure first element is smallest
// Count permutations of all others → factorial
//T.C : O(n)
//S.C : O(1)
class Solution {
    static final long mod = 1000000007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        long ans = 1;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        for (int i = 1; i < n; i++) {
            ans = (ans * i) % mod;
        }
        return (int) ans;
    }
}