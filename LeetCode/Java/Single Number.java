// Brute Force Solution (slow af)
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

// Sorted Array
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            } else if (i == nums.length - 2) {
                return nums[nums.length - 1];
            } else {
                i += 1;
            }
        }
        return 0;
    }
}

// Elimination process (slow af)
class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    nums[j] = Integer.MAX_VALUE;
                    nums[i] = Integer.MAX_VALUE;
                }
            }
        }
        for (int number : nums) {
            if (number != Integer.MAX_VALUE) {
                return number;
            }
        }
        return -1;
    }
}
