import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Main
{
    private static Map<String, HeavenlyBody> solarSystem;
    private static Set<HeavenlyBody> planets;

    public static void main(final String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        temp = new HeavenlyBody("Venus", 225.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        temp = new HeavenlyBody("Earth", 365.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27.0);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        temp = new HeavenlyBody("Mars", 687.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        tempMoon = new HeavenlyBody("Deimos", 1.3);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Phobos", 0.3);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        temp = new HeavenlyBody("Jupiter", 4332.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        tempMoon = new HeavenlyBody("Io", 1.8);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Europa", 3.5);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Callisto", 16.7);
        Main.solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        temp = new HeavenlyBody("Saturn", 10759.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        temp = new HeavenlyBody("Uranus", 30660.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        temp = new HeavenlyBody("Neptune", 165.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        temp = new HeavenlyBody("Pluto", 248.0);
        Main.solarSystem.put(temp.getName(), temp);
        Main.planets.add(temp);
        System.out.println("Planets");

        for (final HeavenlyBody planet : Main.planets) {
            System.out.println("\t" + planet.getName());
        }
        final HeavenlyBody body = Main.solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for (final HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }
        final Set<HeavenlyBody> moons = new HashSet<HeavenlyBody>();
        for (final HeavenlyBody planet2 : Main.planets) {
            moons.addAll(planet2.getSatellites());
        }
        System.out.println("All Moons");
        for (final HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
    }
    static {
        Main.solarSystem = new HashMap<String, HeavenlyBody>();
        Main.planets = new HashSet<HeavenlyBody>();
    }
}
