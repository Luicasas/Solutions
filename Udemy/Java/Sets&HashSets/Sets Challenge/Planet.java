public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public void addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyTypes() == BodyTypes.MOON) {
            super.addSatellite(moon);
        } else {
            System.out.println(moon.getKey().getName() + " is not a moon for planet.");
        }
    }
}
