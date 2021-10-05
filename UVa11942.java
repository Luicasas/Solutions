import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa11942 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        System.out.println("Lumberjacks:");

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int l3 = Integer.parseInt(st.nextToken());
            int l4 = Integer.parseInt(st.nextToken());
            int l5 = Integer.parseInt(st.nextToken());
            int l6 = Integer.parseInt(st.nextToken());
            int l7 = Integer.parseInt(st.nextToken());
            int l8 = Integer.parseInt(st.nextToken());
            int l9 = Integer.parseInt(st.nextToken());
            int l10 = Integer.parseInt(st.nextToken());

            if (l1 < l2 && l2 < l3 && l3 < l4 && l4 < l5 && l5 < l6 && l6 < l7 && l7 < l8 && l8 < l9 && l9 < l10
            || l1 > l2 && l2 > l3 && l3 > l4 && l4 > l5 && l5 > l6 && l6 > l7 && l7 > l8 && l8 > l9 && l9 > l10) {
                System.out.println("Ordered");
            } else {
                System.out.println("Unordered");
            }
        }

    }
}
