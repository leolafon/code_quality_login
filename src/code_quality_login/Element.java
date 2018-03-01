package code_quality_login;

public class Element {
    public String data;
    public Element next;

    Element(String data, Element next) {
        this.data = data;
        this.next = next;
    }
}
