import java.util.StringTokenizer;
class Solution {
    public boolean isPalindrome(String s) {
        StringTokenizer st = new StringTokenizer(s.toLowerCase(), " `|\\\".,/';[]-=~<>?:{}_+)(&^%$#@!");
        StringBuilder reverse = new StringBuilder();
        StringBuilder string = new StringBuilder();
        while (st.hasMoreTokens()) {
            reverse.append(st.nextToken());
        }
        st = new StringTokenizer(s.toLowerCase(), " `|\\\".,/';[]-=~<>?:{}_+)(&^%$#@!");
        while (st.hasMoreTokens()) {
            string.append(st.nextToken());
        }
        reverse.reverse();
        String resultReverse = reverse.toString(), result = string.toString();
        return resultReverse.equals(result);
    }
}
