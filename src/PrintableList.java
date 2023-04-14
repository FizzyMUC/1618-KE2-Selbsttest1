public class PrintableList {
    private Entry header = new Entry(null, null, null);
    private int size;

    public PrintableList() {
        header.next = header;
        header.previous = header;
    }

    Printable getLast() {
        if (size == 0) throw new java.util.NoSuchElementException();
        return header.previous.printableElement;
    }

    Printable getElementAt(int position) {
        if (size == 0 || (position + 1) > size || position < 0) throw new java.util.NoSuchElementException();
        Entry targetEntry = header;
        for (int i = 0; i <= position; i++) {
            targetEntry = targetEntry.next;
        }
        return targetEntry.printableElement;
    }

    Printable removeLast() {
        Entry lastEntry = header.previous;
        if (lastEntry == header) throw new java.util.NoSuchElementException();
        lastEntry.previous.next = lastEntry.next;
        lastEntry.next.previous = lastEntry.previous;
        size--;
        return lastEntry.printableElement;
    }

    void addLast(Printable p) {
        Entry newEntry = new Entry(p, header, header.previous);
        header.previous.next = newEntry;
        header.previous = newEntry;
        size++;
    }

    int size() {
        return size;
    }
    // Nicht statische innere Klasse ListIterator


    public class ListIterator {
        private int nextIndex;
        private Entry next = header.next;

        boolean hasNext() {
            return nextIndex != size;
        }

        Printable next() {
            if (nextIndex == size) throw new java.util.NoSuchElementException();
            Printable elem = next.printableElement;
            next = next.next;
            nextIndex++;
            return elem;
        }


    }

    // Einen Iterator für eine bestimmte Liste kann man mit deren Methode listIterator erhalten
    ListIterator listIterator() {
        return new ListIterator();
    }

    // Von außen nicht sichtbare statische innere Klasse Entry
    private static class Entry {
        private Printable printableElement;
        private Entry next;
        private Entry previous;

        public Entry(Printable printableElement, Entry next, Entry previous) {
            this.printableElement = printableElement;
            this.next = next;
            this.previous = previous;
        }
        //
    }
}

