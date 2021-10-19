import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class letterToNumberGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        System.out.println("Enter a grade: ");
        while ((s = in.readLine()) != null) {
            if (s.equals("end")) {
                break;
            }
            switch (s) {
                case "A+" -> System.out.println("100+");
                case "A" -> System.out.println("94-100");
                case "B+" -> System.out.println("90-93");
                case "B" -> System.out.println("87-89");
                case "B-" -> System.out.println("80-82");
                case "C+" -> System.out.println("77-79");
                case "C" -> System.out.println("73-76");
                case "C-" -> System.out.println("70-72");
                case "D+" -> System.out.println("67-69");
                case "D" -> System.out.println("63-66");
                case "D-" -> System.out.println("60-62");
                case "F" -> System.out.println("0-59");
                default -> System.out.println("Please enter a valid grade: ");
            }
        }
    }
}
