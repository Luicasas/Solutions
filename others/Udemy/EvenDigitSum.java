public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        if (number >= 0) {
            String s = String.valueOf(number);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int num = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (num % 2 == 0) {
                    sum += num;
                }
            }
            return sum;
        }
        return -1;
    }
}
