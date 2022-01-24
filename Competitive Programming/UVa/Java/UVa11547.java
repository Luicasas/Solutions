import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa11547 {
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            double n = Double.parseDouble(in.readLine());
            n *= 567d;
            n /= 9d;
            n += 7492d;
            n *= 235d;
            n /= 47d;
            n -= 498d;
            System.out.println(Math.abs(((int)n % 100) / 10));
        }
    }
}
