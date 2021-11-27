import java.io.*;
import java.util.*;

public class secondsAndMinutes {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) throws IOException {
        System.out.println(getDurationString(12637, 42));
        System.out.println(getDurationString(5126));
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0 && (seconds >= 0 && seconds <= 59)) {
            int hours = 0;
            double minute = minutes;
            if (minutes > 60) {
                hours = minutes / 60;
                minute = (double) minutes / 60;
                minute %= 1;
                minute *= 60;
            }
            String h = String.valueOf(hours);
            String min = String.valueOf(minute);
            StringTokenizer st = new StringTokenizer(min, ".");
            min = st.nextToken();
            String s = String.valueOf(seconds);
            if (h.length() == 1 && min.length() == 1 && s.length() == 1) {
                return "0" + hours + "h 0" + Math.round(minute) + "m 0" + seconds + "s";
            } else if (min.length() == 1 && s.length() == 1) {
                return hours + "h 0" + Math.round(minute) + "m 0" + seconds + "s";
            } else if (h.length() == 1 && s.length() == 1) {
                return "0" + hours + "h " + Math.round(minute) + "m 0" + seconds + "s";
            } else if (h.length() == 1 && min.length() == 1) {
                return "0" + hours + "h 0" + Math.round(minute) + "m " + seconds + "s";
            } else if (h.length() == 1) {
                return "0" + hours + "h " + Math.round(minute) + "m " + seconds + "s";
            } else {
                return hours + "h " + Math.round(minute) + "m " + seconds + "s";
            }
        }
        return INVALID_VALUE_MESSAGE;
    }

    public static String getDurationString(int seconds) {
        if (seconds >= 0) {
            int minutes = 0;
            double second = seconds;
            if (seconds > 60) {
                minutes = seconds / 60;
                second = (double) seconds / 60;
                second %= 1;
                second *= 60;
            }
            return getDurationString(minutes, (int) Math.round(second));
        }
        return INVALID_VALUE_MESSAGE;
    }
}
