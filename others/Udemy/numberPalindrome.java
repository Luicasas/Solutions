public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        String o = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        sb.append(o).reverse();
        String reversed = String.valueOf(sb);
        if (reversed.contains("-")) {
            sb.deleteCharAt(sb.length() - 1);
            reversed = String.valueOf(sb.insert(0, "-"));
        }
        System.out.println(reversed);
        System.out.println(o);
        return reversed.equals(o);
    }
}
