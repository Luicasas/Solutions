import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa10300 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(in.readLine());

        while (t-- > 0) {

            int t2 = Integer.parseInt(in.readLine());

            double spaceAverage = 0;
            double premium = 0;
            double fin = 0;

            for (int i = 0; i < t2; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());

                double a = Double.parseDouble(st.nextToken());
                double b = Double.parseDouble(st.nextToken());
                double c = Double.parseDouble(st.nextToken());

                spaceAverage = a / b;

                premium = spaceAverage * c;

                fin += premium * b;

            }
            System.out.println((long)(fin));
        }

    }
}
