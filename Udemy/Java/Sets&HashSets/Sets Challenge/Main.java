import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem;
    private static Set<HeavenlyBody> planets;

    static {
        Main.solarSystem = new HashMap<>();
        Main.planets = new HashSet<>();
    }

    public static void main(final String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        temp = new Planet("Venus", 225.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        temp = new Planet("Earth", 365.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27.0);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        Main.solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        temp = new Planet("Uranus", 30660.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        temp = new Planet("Neptune", 165.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);

        temp = new DwarfPlanet("Pluto", 248.0);
        Main.solarSystem.put(temp.getKey(), temp);
        Main.planets.add(temp);
        System.out.println("Planets");

        for (final HeavenlyBody planet : Main.planets) {
            System.out.println("\t" + planet.getKey());
        }
        final HeavenlyBody body = Main.solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("\nMoons of " + body.getKey());
        for (final HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }
        final Set<HeavenlyBody> moons = new HashSet<>();
        for (final HeavenlyBody planet2 : Main.planets) {
            moons.addAll(planet2.getSatellites());
        }
        System.out.println("\nAll Moons");
        for (final HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }


        System.out.println("=============");
        HeavenlyBody pluto = new Planet("Pluto", 842);
        planets.add(pluto);

        for (HeavenlyBody planet : planets) {
            System.out.println(planet);
        }

        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("The solar system contains:");
        for (HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println(heavenlyBody);
        }
    }
}
