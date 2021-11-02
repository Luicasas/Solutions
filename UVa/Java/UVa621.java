import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa621 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String s = in.readLine();
            if (s.equals("1") || s.equals("4") || s.equals("78")) {
                System.out.println("+");
            } else if (s.endsWith("35")) {
                System.out.println("-");
            } else if (s.startsWith("190")) {
                System.out.println("?");
            } else {
                System.out.println("*");
            }
        }

    }
}
