public class FactorPrinter {
    public static void printFactors(int number) {
        if (number > -1) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    result.append(i).append(" ");
                }
            }
            System.out.println(result);
        } else System.out.println("Invalid Value");
    }
}
