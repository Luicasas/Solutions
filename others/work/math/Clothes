import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Clothes {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter value of the first clothe: ");
        double a = Double.parseDouble(in.readLine());
        System.out.println("enter value of the second clothe: ");
        double b = Double.parseDouble(in.readLine());
        System.out.println("enter value of the third clothe: ");
        double c = Double.parseDouble(in.readLine());
        System.out.println("middle discount: ");
        double middleDiscount = Double.parseDouble(in.readLine());
        System.out.println("biggest discount: ");
        double biggestDiscount = Double.parseDouble(in.readLine());

        ArrayList<Double> values = new ArrayList<>();
        Collections.sort(values);
        values.add(a); values.add(b); values.add(c);

        double smallest = values.get(0), middle = values.get(1);

        double calculation14 = smallest - (smallest * biggestDiscount),
                calculation29 = middle - (middle * middleDiscount),
                result = calculation14 + calculation29 + values.get(2);

        System.out.println(result);

    }
}
