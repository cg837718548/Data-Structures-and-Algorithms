package LinearTable.staticList;

/**
 * �����ڵ�
 * 
 * @author 83771
 *
 */
public class Node {
	// �ڵ�����
	private String data;
	// �α�
	private int cursor;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	public Node(String data) {
		super();
		this.data = data;
	}
	public Node() {
		super();
	}
	

}
