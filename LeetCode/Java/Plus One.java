import java.math.*;
import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        String nums = Arrays.toString(digits);

        StringTokenizer stringTokenizer = new StringTokenizer(nums, " [],");
        StringBuilder stringBuilder = new StringBuilder();

        while (stringTokenizer.hasMoreTokens()) {
            stringBuilder.append(stringTokenizer.nextToken());
        }
        BigInteger sum = new BigInteger(String.valueOf(stringBuilder));
        sum = sum.add(BigInteger.valueOf(1));

        nums = String.valueOf(sum);
        int[] result = new int[nums.length()];
        char[] chars = new char[nums.length()];

        System.arraycopy(nums.toCharArray(), 0, chars, 0, chars.length);

        for (int i = 0; i < chars.length; i++) {
            result[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return result;
    }
}
