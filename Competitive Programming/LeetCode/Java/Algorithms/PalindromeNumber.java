// 8ms iterative solution
class Solution {
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (arr[(arr.length - i) - 1])) {
                return false;
            }
        }
        return true;
    }
}

/* First solution.
class Solution {
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        String reverse = new StringBuilder(new String(arr)).reverse().toString();
        char[] arrReversed = reverse.toCharArray();
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arrReversed[i]) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }
}
*/

/* Stringbuilder solution 16ms
class Solution {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(number);
        stringBuilder.reverse();
        return (stringBuilder.toString().equals(number));
    }
}
*/

/* Stringbuilder optimized solution 15ms
class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(x));
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(x));
        stringBuilder1.reverse();
        int check = (stringBuilder1.compareTo(stringBuilder2));
        return check == 0;
    }
}
*/
