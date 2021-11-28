import java.util.Calendar;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
        }
        return false;
    }
    public static int getDaysInMonth(int month, int year) {
        if (month >= 1 && month <= 12 && year >= 1 && year <= 9999) {
            if (month == 2 && isLeapYear(year)) {
                return 29;
            } else if (month == 2 && !isLeapYear(year)) {
                return 28;
            }
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
            }
        }
        return -1;
    }
}
