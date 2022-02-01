import java.io.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static Locations locations = new Locations();

    public static void main(String[] args) throws IOException {
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
