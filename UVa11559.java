import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa11559 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int participants = Integer.parseInt(st.nextToken()),
                    budget = Integer.parseInt(st.nextToken()),
                    hotels = Integer.parseInt(st.nextToken()),
                    weeks = Integer.parseInt(st.nextToken()),
                    result,
                    min = Integer.MAX_VALUE;
            boolean bedCheck = false;

            while (hotels-- > 0) {
                int price = Integer.parseInt(in.readLine());
                int[] beds = new int[weeks];
                st = new StringTokenizer(in.readLine());
                while (st.hasMoreTokens()) {
                    for (int i = 0; i < weeks; i++) {
                        beds[i] = Integer.parseInt(st.nextToken());
                    }
                }
                for (int bed : beds) {
                    if (bed >= participants) {
                        bedCheck = true;
                        break;
                    }
                }
                if (bedCheck && price * participants <= budget) {
                    result = participants * price;
                    if (result < min) {
                        min = result;
                    }
                }
            }
            System.out.println(min == Integer.MAX_VALUE ? "stay home" : min);
        }
    }
}
