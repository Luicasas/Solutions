import java.io.*;
import java.nio.BufferOverflowException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    static {
        // Read locations and exits with FileReader
        /*
        try (Scanner scanner = new Scanner(new FileReader("locations.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported location : " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
         */

        // Read locations and exits with BufferedReader
        try (BufferedReader in = new BufferedReader(new FileReader("directions.txt"))) {
            String s;
            while ((s = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(s, ",");
                int loc = Integer.parseInt(st.nextToken());
                st.nextToken();
                String description = st.nextToken();
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // exits
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {
////                int loc = scanner.nextInt();
////                scanner.skip(scanner.delimiter());
////                String direction = scanner.next();
////                scanner.skip(scanner.delimiter());
////                String destination = scanner.nextLine();
////                int destin = Integer.parseInt(destination);
////                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // add Locations
        /*
        Map<String, Integer> tempMap = new HashMap<>();
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
         */
    }

    public static void main(String[] args) {
        /*
        try (FileWriter locationFile = new FileWriter("locations.txt");
             FileWriter directionFile = new FileWriter("directions.txt")) {
            for (Location location : locations.values()) {
                locationFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    directionFile.write(location.getLocationID() + ","
                            + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
         */
        try (BufferedWriter locationWriter = new BufferedWriter(new FileWriter("locations_writing.txt"));
             BufferedWriter directionWriter = new BufferedWriter(new FileWriter("directions_writing.txt"))) {
            for (Location location : locations.values()) {
                locationWriter.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        directionWriter.write(location.getLocationID() + "," + direction + "," +
                                location.getExits().get(direction) + "\n");
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
