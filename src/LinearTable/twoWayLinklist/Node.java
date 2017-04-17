package LinearTable.twoWayLinklist;

public class Node {

	private Character data;
	private Node next;
	private Node previous;
	public Character getData() {
		return data;
	}
	public void setData(Character data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node(Character data) {
		super();
		this.data = data;
	}
	public Node() {
		super();
	}
	
	
	
	
}
