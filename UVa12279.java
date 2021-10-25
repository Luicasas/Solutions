import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVa12279 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int cases = 0;
        String s;

        while ((s = in.readLine()) != null && !s.equals("0")) {
            int treats = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            ArrayList<Integer> values = new ArrayList<>();

            while (st.hasMoreTokens()) {
                values.add(Integer.parseInt(st.nextToken()));
            }

            for (int element : values) {
                if (element > 0) {
                    treats++;
                } else {
                    treats--;
                }
            }
            cases++;
            System.out.printf("Case %d: " + treats + "\n", cases);
        }
    }
}
