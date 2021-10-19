import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(in.readLine());
        int[] array = {5, 10, 20, 30, 40, 2, 4, 8, 200, 36, 52};

        boolean check = findIfInList(array, input);

        if (check) {
            System.out.println(input + " is in the array");
        } else {
            System.out.println(input + " is not in the array);
        }
    }
    public static boolean findIfInList(int[] arr, int input) {
        for (int element : arr) {
            if (element == input) {
                return true;
            }
        }
        return false;
    }
}
