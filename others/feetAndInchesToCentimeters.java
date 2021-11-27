import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("8ft 10in are equal to " + calcFeetAndInchesToCentimeters(8, 10) + "cm");
        System.out.println("107in are equal to " + calcFeetAndInchesToCentimeters(107) + "cm");
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        double result;
        if (feet >= 0 && (inches >= 0 && inches <= 12)) {
            result = feet * 30.48;
            result += inches * 2.54;
            return result;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches >= 0) {
            int feet = (int) (inches / 12);
            double inch = Math.round(((inches / 12) % 1) * 12);
            System.out.println(inches + "in are equal to " + feet + "ft " + inch + "in");
            return calcFeetAndInchesToCentimeters(feet, inch);
        }
        return -1;
    }

}
