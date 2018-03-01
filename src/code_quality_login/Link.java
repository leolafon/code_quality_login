package code_quality_login;

public class Link {

	public int count;
	public String name;
	public Link prev;
	public Link next;
	
	public Link(String name, int count, Link prev, Link next) {
		this.count = count;
		this.name = name;
		this.prev = prev;
		this.next = next;
	}
}
