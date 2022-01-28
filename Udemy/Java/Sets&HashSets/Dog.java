import java.util.Objects;

class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }
}

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Dog) {
            var oName = ((Dog) o).getName();
            return this.name.equals(oName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
