public class LastDigitChecker {
    public static boolean hasSameLastDigit(int firstNum, int secondNum, int thirdNum) {
        if (firstNum >= 10 && firstNum <= 1000 &&
                secondNum >= 10 && secondNum <= 1000 &&
                thirdNum >= 10 && thirdNum <= 1000) {
            String first = String.valueOf(firstNum);
            String second = String.valueOf(secondNum);
            String third = String.valueOf(thirdNum);
            if (first.endsWith(String.valueOf(second.charAt(second.length() - 1)))) {
                return true;
            } else if (first.endsWith(String.valueOf(third.charAt(third.length() - 1)))) {
                return true;
            } else return second.endsWith(String.valueOf(third.charAt(third.length() - 1)));
        }
        return false;
    }
    
    public static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }
}
