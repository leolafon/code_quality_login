import List.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push("toto");
        list.push("tata");
        list.push("tutu");

        list.append("last");
        list.append("last2");

        list.insertAt("index3", 3);
        list.removeAt(3);

        list.remove("tata");

        list.display();
    }
}
