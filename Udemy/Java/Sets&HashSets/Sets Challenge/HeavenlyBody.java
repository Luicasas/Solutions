import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(final String name, final double orbitalPeriod, final BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.key = new Key(name, bodyType);
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public void addSatellite(final HeavenlyBody moon) {
        this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof HeavenlyBody object) {
            return this.key.equals(object.getKey());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyTypes) {
        return new Key(name, bodyTypes);
    }

    @Override
    public String toString() {
        return key.name + ":" + "\n\tbodyType = " + key.bodyTypes + "\n\torbitalPeriod = " + orbitalPeriod;
    }

    public enum BodyTypes {
        STAR, PLANET, DWARF_PLANET, MOON, COMET, ASTEROID
    }

    protected static final class Key {
        private final String name;
        private final BodyTypes bodyTypes;

        public Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyTypes;
        }

        @Override
        public boolean equals(Object obj) {
            var key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyTypes == key.getBodyTypes());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(bodyTypes);
        }
    }
}
