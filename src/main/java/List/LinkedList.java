package List;

public class LinkedList {

    private Element root = null;
    private int length = 0;

    public void push(String item) {
        Element newItem = new Element(item, null);

        if (this.root == null) {
            this.root = newItem;
        } else {
            newItem.next = this.root;
            this.root = newItem;
        }
        ++this.length;
    }

    public void append(String item) {
        Element newItem = new Element(item, null);
        Element iterator = this.root;

        if (this.root == null) {
            this.root = newItem;
            return;
        }
        while (iterator.next != null) {
            iterator = iterator.next;
        }
        iterator.next = newItem;
        ++this.length;
    }

    public void insertAt(String item, int index) {
        Element newItem = new Element(item, null);
        Element iterator = this.root;
        Element prevIterator = this.root;
        int currentIndex = 0;

        if (index == 0) {
            this.push(item);
            return;
        }
        while (currentIndex != index && iterator.next != null) {
            ++currentIndex;
            prevIterator = iterator;
            iterator = iterator.next;
        }
        prevIterator.next = newItem;
        newItem.next = iterator;
        ++this.length;
    }

    public void removeAt(int index) {
        Element iterator = this.root;
        Element prevIterator = this.root;
        int currentIndex = 0;

        while (currentIndex != index && iterator.next != null) {
            ++currentIndex;
            prevIterator = iterator;
            iterator = iterator.next;
        }
        prevIterator.next = iterator.next;
        --this.length;
    }

    public void remove(String item) {
        Element iterator = this.root;
        Element prevIterator = null;

        while (iterator.next != null) {
            if (iterator.data.equals(item)) {
                if (iterator == this.root) {
                    this.root = this.root.next;
                    --this.length;
                    return;
                } else {
                    prevIterator.next = iterator.next;
                    --this.length;
                    return;
                }
            }
            prevIterator = iterator;
            iterator = iterator.next;
        }
    }

    public String getAtIndex(int index) {
        Element iterator = this.root;
        int currentIndex = 0;

        while (currentIndex != index && iterator.next != null) {
            ++currentIndex;
            iterator = iterator.next;
        }

        return iterator.data;
    }

    public String getFirst() {
        return this.root.data;
    }

    public String getLast() {
        Element iterator = this.root;

        while (iterator.next != null) {
            iterator = iterator.next;
        }

        return iterator.data;
    }

    public void sort() {

    }

    public int getLength() {
        return this.length;
    }

    public void display() {
        Element iterator = this.root;

        while (iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }
}
