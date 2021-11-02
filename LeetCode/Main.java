import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int target = 6;
        int[] arr = {3, 2, 3};
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum;
                sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }
}