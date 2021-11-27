public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes > -1) {
            if (minutes <= 1440) {
                double r = (double) minutes / 525600;
                r %= 1;
                r *= 365;
                System.out.println(minutes + " min = " + "0 y" + " and " + (long) r + " d");
            } else if (minutes / 525600 > 0){
                double r = (double) minutes / 525600;
                r %= 1;
                r *= 365;
                System.out.println(minutes + " min = " + minutes / 525600 + " y" + " and " + (long) Math.round(r) + " d");
            }
        } else {
            System.out.println("Invalid Value");
        }
    }
}
