import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(final String name, final double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<HeavenlyBody>();
    }

    public String getName() {
        return this.name;
    }

    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }

    public boolean addMoon(final HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(this.satellites);
    }
}
