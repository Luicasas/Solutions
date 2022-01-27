import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in the forest"));
        locations.put(5, new Location(5, "You are in Colombia."));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        int location = 1;
        while (true) {
            System.out.println(locations.get(location).getDescription());
            if (location == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(location).getExits();
            System.out.println("Available exits are ");
            int counter = 0;
            for (String exit : exits.keySet()) {
                System.out.print(counter < exits.size() - 1 ? exit + ", " : exit);
                counter++;
            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                HashMap<String, String> vocabulary = new HashMap<>();
                vocabulary.put("QUIT", "Q");
                vocabulary.put("NORTH", "N");
                vocabulary.put("SOUTH", "S");
                vocabulary.put("WEST", "W");
                vocabulary.put("EAST", "E");

                ArrayList<String> words = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(direction, "~!@#$%^&*()_+{}<>?:-=[]';,.");
                while (st.hasMoreTokens()) {
                    words.add(st.nextToken());
                }

                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }

                System.out.println(words);
            }

            if (exits.containsKey(direction)) {
                location = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction!");
            }
        }
    }
}
