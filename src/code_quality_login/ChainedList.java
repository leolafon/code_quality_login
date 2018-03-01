package code_quality_login;

public class ChainedList {
	
	public Link last;
	public Link first;
	public int count;
	
	public ChainedList() {
		this.count = 0;
		this.last = null;
		this.first = null;
		
	}
	
	public void addLast(String name) {
		this.count++;
		Link newOne = new Link(name, this.count, this.last, this.first);
		if (this.first == null) {
			this.first = newOne;
			newOne.next = newOne;
		}
		this.last = newOne;
	}
	
	public void addBegin(String name) {
		this.count++;
		for(int i = 0; i < this.count; i++) {
			this.first.count++;
			System.out.println(this.first.name);
			this.first = this.first.next;
		}
		Link newOne = new Link(name, this.count, this.last, this.first);
		this.first = newOne;
	}
	
	public void addPosition(String name, int position) {
		for(int i = 0; i <= position; i++) {
			this.first = this.first.next;
		}	
		Link save = this.first;
		while (this.first != this.last) {
			this.first.count++;
			this.first = this.first.next;
		}
		this.first.count++;
		this.count++;
		this.first = this.first.next;
		Link newOne = new Link(name, position, save.prev, save);
		save.prev = newOne;
	}
	
	public void displayAll() {
		System.out.println("Affichage de la liste des maillons");
		if (this.first != null) {
			for(int i = 0; i < this.count; i++) {
				System.out.println(this.first.name + " à la place : " + this.first.count);
				this.first = this.first.next;
			}		
		}
		else {
			System.out.println("Liste vide.");
		}
	}
}
