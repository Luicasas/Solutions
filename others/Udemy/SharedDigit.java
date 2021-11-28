public class SharedDigit {
    public static boolean hasSharedDigit(int firstNum, int secondNum) {
        if (firstNum >= 10 && firstNum <= 99 && secondNum >= 10 && secondNum <= 99) {
            String s = String.valueOf(firstNum);
            String s2 = String.valueOf(secondNum);
            int max = Math.max(s.length(), s2.length());
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    if (s.charAt(i) == s2.charAt(j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
