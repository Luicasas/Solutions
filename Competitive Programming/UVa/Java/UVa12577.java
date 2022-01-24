import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa12577 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int cases = 1;
        while ((s = in.readLine()) != null && !s.equals("*")) {
            if (s.equals("Hajj")) {
                System.out.println("Case " + cases++ + ": " + "Hajj-e-Akbar");
            } else {
                System.out.println("Case " + cases++ + ": " + "Hajj-e-Asghar");
            }
        }
    }
}
