import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findGreatestSwitch {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        switch (a > b && a > c ? 1 : b > a && b > c ? 2 : 3) {
            case 1 -> System.out.println("A is greater");
            case 2 -> System.out.println("B is greater");
            case 3 -> System.out.println("C is greater");
        }
    }
}
