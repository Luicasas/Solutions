import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVa11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine()), cases = 0;

        while (t-- > 0) {
            String s = in.readLine();
            StringTokenizer st = new StringTokenizer(s);
            ArrayList<Integer> values = new ArrayList<>();

            while (st.hasMoreTokens()) {
                values.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(values);
            cases++;

            System.out.printf("Case %d:" + " " + values.get(1) + "\n", cases);

        }

    }
}
