import java.io.*;

public class Area {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double a, b, c, x, y, f, perimeter, rectangleM, rectangleN, area, priceOne, priceTwo, priceThree, m1, m2, result;

        System.out.println("enter value of a: ");
        a = Double.parseDouble(in.readLine());

        System.out.println("enter value of b: ");
        b = Double.parseDouble(in.readLine());

        System.out.println("enter value of c: ");
        c = Double.parseDouble(in.readLine());

        System.out.println("enter value of f: ");
        f = Double.parseDouble(in.readLine());

        x = b - f;

        y = a - c;

        perimeter = a + b + c + x + y + f;

        rectangleM = f * a;
        rectangleN = x * c;

        area = rectangleM + rectangleN;

        System.out.println("enter value of ceramic floor box: ");
        priceOne = Double.parseDouble(in.readLine());

        System.out.println("broom guard: ");
        priceTwo = Double.parseDouble(in.readLine());

        System.out.println("enter value of installation labor: ");
        priceThree = Double.parseDouble(in.readLine());

        m1 = priceOne * area;
        m2 = priceTwo * perimeter;

        result = m1 + m2 + priceThree;

        System.out.println(result);
    }
}
