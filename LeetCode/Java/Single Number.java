// Brute Force Solution:
class Solution {
    public int singleNumber(int[] nums) {
        int result;
        ArrayList<Integer> repetition = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result = nums[i];
            if (!repetition.contains(result)) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == result) {
                        repetition.add(nums[i]);
                        result = Integer.MAX_VALUE;
                        break;
                    }
                }
            } else {
                result = Integer.MAX_VALUE;
            }
            if (result != Integer.MAX_VALUE) return result;
        }
        return Integer.MAX_VALUE;
    }
}
