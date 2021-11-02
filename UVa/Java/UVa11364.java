import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVa11364 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int t2 = Integer.parseInt(in.readLine());
            String s = in.readLine();
            StringTokenizer st = new StringTokenizer(s);
            TreeSet<Integer> values = new TreeSet<>();
            while (st.hasMoreTokens()) {
                values.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(Math.abs(2 * (values.first() - values.last())));
        }

    }
}
