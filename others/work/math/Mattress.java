import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mattress {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter price: ");
        double colchon = Double.parseDouble(in.readLine());
        System.out.println("enter value for IVA: ");
        double IVA = Double.parseDouble(in.readLine());

        double calculation = colchon * (IVA / 100);

        System.out.println(calculation);

    }
}
