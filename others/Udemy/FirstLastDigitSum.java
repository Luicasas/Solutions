public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        String s = String.valueOf(number);
        if (number >= 0) {
            if (s.length() == 1) return number * 2;
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i == 0 || i == s.length() - 1) {
                    sum += Integer.parseInt(String.valueOf(s.charAt(i)));
                }
            }
            return sum;
        }
        return -1;
    }
}
