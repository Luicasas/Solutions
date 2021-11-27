import java.util.TreeSet;
public class IntEqualityPrinter {
    public static void printEqual (int a, int b, int c) {
        if (a > -1 && b > -1 && c > -1) {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(a); set.add(b); set.add(c);
            if (set.size() == 1) {
                System.out.println("All numbers are equal");
            } else if (set.size() == 2) {
                System.out.println("Neither all are equal or different");
            } else {
                System.out.println("All numbers are different");
            }
        } else System.out.println("Invalid Value");
    }
}
