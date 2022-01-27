import java.io.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> tempMap = new HashMap<>();

        locations.put(0, new Location(0, "You are sitting in front of a computer learning java", tempMap));

        // Location 1
        tempMap.put("W", 2);
        tempMap.put("E", 3);
        tempMap.put("S", 4);
        tempMap.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick", tempMap));
        // Location 2
        tempMap = new HashMap<>();
        tempMap.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempMap));
        // Location 3
        tempMap = new HashMap<>();
        tempMap.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempMap));
        // Location 4
        tempMap = new HashMap<>();
        tempMap.put("N", 1);
        tempMap.put("W", 2);
        locations.put(4, new Location(4, "You are in the forest", tempMap));
        // Location 5
        tempMap = new HashMap<>();
        tempMap.put("S", 1);
        tempMap.put("W", 2);
        locations.put(5, new Location(5, "You are in Colombia.", tempMap));
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
