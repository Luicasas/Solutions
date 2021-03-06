import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new LinkedHashMap<>(exits);
            this.exits.put("Q", 0);
        } else {
            this.exits = new LinkedHashMap<>();
            this.exits.put("Q", 0);
        }
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }

    void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
