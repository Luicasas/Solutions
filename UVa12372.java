import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa12372 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine()), cases = 1;

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
                    c = Integer.parseInt(st.nextToken());
            if (a <= 20 && b <= 20 && c <= 20) {
                System.out.println("Case " + cases++ + ": " + "good");
            } else {
                System.out.println("Case " + cases++ + ": " + "bad");
            }

        }

    }
}
