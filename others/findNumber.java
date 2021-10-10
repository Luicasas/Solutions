import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findNumber {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(in.readLine());
        int[] array = {5, 10, 20, 30, 40, 2, 4, 8, 200, 36, 52};

        boolean check = findIfInList(array, input);

        if (check) {
            System.out.println(input + " está en la lista");
        } else {
            System.out.println(input + " no está en la lista");
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println(endTime);
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
