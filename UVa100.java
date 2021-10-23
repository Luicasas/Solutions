import java.io.*;
import java.util.*;

public class UVa100 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
            int max = Math.max(i, j), count = 0, min = Math.min(i, j), cycle = 0;

            for (int k = max; k >= min; k--) {
                count = calculation(k);
                if (count > cycle) {
                    cycle = count;
                }
            }
            System.out.printf("%d " + "%d " + cycle + "\n", i, j);
        }
    }
    public static int calculation(int k) {
        int count = 1;
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            count++;
        }
        return count;
    }
}
