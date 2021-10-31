import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa11332 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            int number = Integer.parseInt(s);
            if (number == 0) break;
            System.out.println(sum(number));
        }
    }
    public static int sum(int value) {
        while (value > 9) {
            value = value % 10 + sum(value / 10);
        }
        return value;
    }
}
