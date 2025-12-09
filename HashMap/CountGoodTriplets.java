/*Count how many times each number appears on the right.

Move from left to right treating each element as nums[j].

For each nums[j]:

    Remove it from right

    Count how many left numbers equal to 2*nums[j]

    Count how many right numbers equal to 2*nums[j]

    Multiply to get number of valid triplets

Add result to answer.

This avoids O(n³) / O(n²) brute force and runs in O(n) time using HashMaps.*/

//Approach-1 (Using map : 2 Pass Solution)
//T.C : O(2*n)
//S.C : O(n)
class Solution {
    static final int MOD = (int) 1000000007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> right_map = new HashMap<>();
        Map<Integer, Integer> left_map = new HashMap<>();

        int ans = 0;
        for (int num : nums) {
            right_map.put(num, right_map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            right_map.put(num, right_map.get(num) - 1);

            int left = left_map.getOrDefault(num * 2, 0);
            int right = right_map.getOrDefault(num * 2, 0);
            long add = (1L * left * right) % MOD;
            ans = (int) (ans + add) % MOD;
            left_map.put(num, left_map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}