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
