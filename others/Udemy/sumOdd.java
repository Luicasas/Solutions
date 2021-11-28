public class SumOddRange {
    public static boolean isOdd(int number) {
        if (number > 0) {
            return number % 2 != 0;
        }
        return false;
    }

    public static int sumOdd(int start, int end) {
        if (start > 0 && end > 0) {
            if (start <= end) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    if (isOdd(i)) sum += i;
                }
                return sum;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
