public class Main {
    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");

        new Thread(() -> jane.sayHello(john)).start();
        new Thread(() -> john.sayHello(jane)).start();
    }

    record PolitePerson(String name) {

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
