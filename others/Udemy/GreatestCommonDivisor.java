public class GreatestCommonDivisor {
     public static int getGreatestCommonDivisor(int first, int second) {
        if (first >= 10 && second >= 10) {
            int max = 0;
            for (int i = 1; i < Math.max(first, second); i++) {
                if (first % i == 0 && second % i == 0) {
                    max = i;
                }
            }
            return max;
        }
        return -1;
    }
}
