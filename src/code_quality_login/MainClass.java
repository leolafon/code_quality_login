package code_quality_login;

public class MainClass {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push("toto");
		list.push("tata");
		list.push("tutu");

		list.append("last");
		list.append("last2");

		list.insertAt("index3", 3);

		list.display();
	}
}
