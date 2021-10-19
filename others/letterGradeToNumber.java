import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class letterGradeToNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        System.out.println("Enter a grade: ");
        while ((s = in.readLine()) != null) {
            int grade = Integer.parseInt(s);
            if (s.equals("end")) {
                break;
            }
            switch (grade > 100 ? 1 :
                    grade >= 94 ? 2 :
                    grade >= 90 ? 3 :
                    grade >= 87 ? 4 :
                    grade >= 83 ? 5 :
                    grade >= 80 ? 6 :
                    grade >= 77 ? 7 :
                    grade >= 73 ? 8 :
                    grade >= 70 ? 9 :
                    grade >= 67 ? 10 :
                    grade >= 63 ? 11 :
                    grade >= 60 ? 12 : 13) {
                case 1 -> System.out.println("A+");
                case 2 -> System.out.println("A");
                case 3 -> System.out.println("A-");
                case 4 -> System.out.println("B+");
                case 5 -> System.out.println("B");
                case 6 -> System.out.println("B-");
                case 7 -> System.out.println("C+");
                case 8 -> System.out.println("C");
                case 9 -> System.out.println("C-");
                case 10 -> System.out.println("D+");
                case 11 -> System.out.println("D");
                case 12 -> System.out.println("D-");
                case 13 -> System.out.println("F");
                default -> System.out.println("Please enter a valid number");
            }
        }
    }
}
