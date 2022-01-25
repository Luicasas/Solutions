import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static BufferedReader in;
    private static int boundary;

    public static void main(String[] args) throws IOException {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input the size of the array:");
            int integerSize = Integer.parseInt(in.readLine());
            int[] array = new int[integerSize];

            System.out.println("""
                    Select an option:
                    Option 1 - Manual input
                    Option 2 - Random generated values
                    Option 3 - Quit Program""");

            int option = Integer.parseInt(in.readLine());

            switch (option) {
                case 1 -> {
                    optionOne(array);
                }
                case 2 -> {
                    System.out.print("Select upper boundary for the random generated integers: ");
                    boundary = Integer.parseInt(in.readLine());
                    optionTwo(array);
                }
                case 3 -> {
                    in.close();
                }
                default -> {
                    System.out.println("Not an option.");
                    in.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }
    }

    static void optionOne(int[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Input #" + (i + 1) + ": ");
            array[i] = Integer.parseInt(in.readLine());
        }
        System.out.println("In which position from the array do you ought to learn its value? (from 1 to "
                + array.length + ")");
        searchArray(array, Integer.parseInt(in.readLine()));
    }

    static void optionTwo(int[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            array[i] = randomInteger();
        }
        System.out.println("In which position from the array do you ought to learn its value? (from 1 to "
                + array.length + ")");
        searchArray(array, Integer.parseInt(in.readLine()));
    }

    private static int randomInteger() {
        Random random = new Random();
        return random.nextInt(boundary);
    }

    static void searchArray(int[] array, int position) {
        Arrays.sort(array);
        position--;
        System.out.println("Value in the " + (position + 1) + " position is: " + array[position]);
    }
}
