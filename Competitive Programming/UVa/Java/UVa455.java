import java.io.*;
import java.util.Arrays;

public class UVa455 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            String s = in.readLine();
            if (s.equals("")) {
                s = in.readLine();
            }
            if (s.length() > 1) {
                String w = s + s;
                char[] S = s.toCharArray();
                char[] W = w.toCharArray();
                int[] borde = getBorderArray(W);
                W[0] = '#';
                int index = indexOf(S, W, borde);
                System.out.printf("%d\n", index);
            } else {
                System.out.println("1");
            }
            if (T - 1 >= 0) {
                System.out.println();
            }
        }
    }
    static int[] getBorderArray(char[] W) {
        int[] T = new int[W.length+1]; T[0]=-1; T[1]=0;
        for (int i = 2, j = 0; i <= W.length;) {
            if (W[i-1] == W[j]) {
                T[i++] = ++j;
            } else if (j>0) {
                j = T[j];
            } else T[i++]=0;
        }
        return T;
    }
    static int indexOf(char[] S, char[] W, int[] T) {
        if (S.length==0) return 0;
        for (int m=0,i=0; m+i<W.length; )
        { if (S[i]==W[m+i]) {if (++i==S.length) return m;} else {m+=i-T[i]; if (i>0) i=T[i]; } }
        return -1;
    }
}
