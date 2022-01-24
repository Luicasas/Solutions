import java.io.*;
import java.math.*;
import java.util.*;

public class UVa11115 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while ((s = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            } else {
                BigInteger valueA = new BigInteger(String.valueOf(a));
                System.out.println(valueA.pow(b));
            }
        }
    }
}
