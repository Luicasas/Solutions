import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa12289 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String s = in.readLine();
            if (s.startsWith("o") && s.endsWith("e") || s.startsWith("o") && s.contains("n") ||
                    s.endsWith("e") && s.contains("n")) {
                System.out.println("1");
            } else if (s.length() == 3) {
                System.out.println("2");
            } else {
                System.out.println("3");
            }
        }
    }
}
