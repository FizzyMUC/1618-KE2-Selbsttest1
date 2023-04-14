public class Person implements Printable {
    private final String name;

    public Person(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println(name);
    }
}
