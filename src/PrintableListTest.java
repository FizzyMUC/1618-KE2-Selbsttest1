public class PrintableListTest {
    public static void main(String[] args) {
        PrintableList list = new PrintableList();
        list.addLast(new Person("Hans"));
        list.addLast(new Cat());
        list.addLast(new Cat());
        list.addLast(new Cat());
        list.addLast(new Book("Und jetzt du."));
        list.addLast(new Person("Victoria"));

        PrintableList.ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            Printable p = iterator.next();
            p.print();
        }
        System.out.println("End");
    }
}
