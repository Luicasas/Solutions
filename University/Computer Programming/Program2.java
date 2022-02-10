import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String RED = ThreadColor.ANSI_RED;
    private static final String YELLOW = ThreadColor.ANSI_YELLOW;
    private static final String CYAN = ThreadColor.ANSI_CYAN;
    private static final String PURPLE = ThreadColor.ANSI_PURPLE;
    private static final String RESET = ThreadColor.ANSI_RESET;
    private static int arraySize = 0;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(YELLOW + """
                    Welcome. What do you want to do?
                    1 -> Initialize program
                    2 -> Exit""" + RESET);
            try {
                switch (Integer.parseInt(reader.readLine())) {
                    case 1 -> Initialization();
                    case 2 -> {
                        System.out.println(RED + "Exiting program..." + RESET);
                        reader.close();
                    }
                    default -> {
                        System.out.println(RED + "Not a correct choice. Exiting program..." + RESET);
                        reader.close();
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println(RED + "Not a number. Exiting program..." + RESET);
                reader.close();
            }
        } catch (IOException exception) {
            System.out.println("Error");
        }
    }

    private static void Initialization() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(YELLOW + """
                    The program consists of generating an array. Either randomly, or manually. First, enter the size
                    of the array (integer):""" + RESET);
            try {
                arraySize = Integer.parseInt(reader.readLine());
                System.out.println(YELLOW + """
                        Do you want to input the numbers manually or randomly?
                        1 -> Manually
                        2 -> Randomly""" + RESET);
                switch (Integer.parseInt(reader.readLine())) {
                    case 1 -> Manual();
                    case 2 -> Randomly();
                    default -> {
                        System.out.println(RED + "Not a correct choice. Exiting program..." + RESET);
                        reader.close();
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println(RED + "Not a valid integer. Exiting program." + RESET);
                reader.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void Manual() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] array = new int[arraySize];
            try {
                for (int i = 0; i < array.length; i++) {
                    System.out.printf(YELLOW + "Input #%s: " + RESET + "\n", (i + 1));
                    array[i] = Integer.parseInt(reader.readLine());
                }
                System.out.println(YELLOW + "Final array:" + RESET);
                for (int i = 0; i < array.length; i++) {
                    System.out.print(i < array.length - 1 ? CYAN + array[i] + " " : array[i] + RESET + "\n");
                }
                System.out.println(RED + "Terminating program..." + RESET);
                reader.close();
            } catch (NumberFormatException exception) {
                System.out.println(RED + "Not a valid integer." + RESET);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void Randomly() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.printf(CYAN + "Please define the lower and upper bound for the randomly generated numbers: "
                    + RESET + "\n" + RED + "(separated by a space in a single line with values from %s to %s)" + "\n" +
                    "EXAMPLE: " + RESET + CYAN + "-5 374" + RESET + "\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            if (stringTokenizer.countTokens() > 2) {
                System.out.println(RED + "Invalid elements." + RESET);
                reader.close();
            }
            try {
                Randomizer randomizer = new Randomizer(arraySize, Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken()));

                Thread randomizingThread = new Thread(randomizer);
                randomizingThread.start();

                Runnable timing = () -> System.out.println(PURPLE + "Generating numbers..." + RESET);
                ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

                while (randomizingThread.isAlive()) {
                    executorService.scheduleAtFixedRate(timing, 0, 1, TimeUnit.SECONDS);
                }
                executorService.shutdown();

                int[] array = Randomizer.getArray();
                for (int i = 0; i < array.length; i++) {
                    System.out.print(i < array.length - 1 ? CYAN + array[i] + " " : array[i] + RESET + "\n");
                }
                System.out.println(RED + "Terminating program..." + RESET);
                reader.close();
            } catch (NumberFormatException exception) {
                System.out.println(RED + "Not a valid integer." + RESET);
                reader.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

class Randomizer implements Runnable {
    private static int[] array;
    private final int lowerBound;
    private final int upperBound;

    public Randomizer(int size, int lowerBound, int upperBound) {
        array = new int[size];
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(lowerBound, upperBound);
        }
    }

    public static int[] getArray() {
        return array;
    }
}
