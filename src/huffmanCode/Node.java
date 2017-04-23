package huffmanCode;

/**
 * 队列的节点
 * 
 * @author 83771
 *
 */
public class Node {

	private char data;
	private Node next;
	private Node left_child;
	private Node right_child;

	public Node getRight_child() {
		return right_child;
	}

	public void setRight_child(Node right_child) {
		this.right_child = right_child;
	}

	public Node getLeft_child() {
		return left_child;
	}

	public void setLeft_child(Node left_child) {
		this.left_child = left_child;
	}


	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(char data) {
		super();
		this.data = data;
	}

	public Node() {
		super();
	}

}
