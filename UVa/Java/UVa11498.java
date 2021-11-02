import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa11498 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int t = Integer.parseInt(in.readLine());
            if (t == 0) break;
            String s = in.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int xN = Integer.parseInt(st.nextToken());
            int yM = Integer.parseInt(st.nextToken());

            while (t-- > 0) {
                s = in.readLine();
                st = new StringTokenizer(s);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x == xN || y == yM) {
                    System.out.println("divisa");
                } else if (x > xN && y > yM) {
                    System.out.println("NE");
                } else if (x < xN && y > yM) {
                    System.out.println("NO");
                } else if (x < xN) {
                    System.out.println("SO");
                } else {
                    System.out.println("SE");
                }
            }
        }
    }
}
