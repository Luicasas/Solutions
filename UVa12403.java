import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa12403 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        int total = 0;

        while (t-- > 0) {
            String s = in.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String donation = st.nextToken();
            if (donation.equals("donate")) {
                total += Integer.parseInt(st.nextToken());
            } else {
                System.out.println(total);
            }

        }

    }
}
