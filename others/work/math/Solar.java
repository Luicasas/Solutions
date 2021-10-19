import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solar {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double radius, credit, roof, pi = 3.1416, areaOfCircle, threeQuartersArea, areaTriangleRectangle, area, r1, r2,
        result;

        System.out.println("enter the radius: ");
        radius = Double.parseDouble(in.readLine());

        System.out.println("enter the credit: ");
        credit = Double.parseDouble(in.readLine());

        System.out.println("enter roof value: ");
        roof = Double.parseDouble(in.readLine());

        areaOfCircle = pi * (Math.pow(radius, 2));
        threeQuartersArea = 0.75 * areaOfCircle;

        areaTriangleRectangle = (radius * radius) / 2;

        area = threeQuartersArea + areaTriangleRectangle;

        r1 = area * roof;
        r2 = area * credit;

        result = r1 + r2;
        System.out.println(result);
    }
}
