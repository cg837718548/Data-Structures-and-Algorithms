package LinearTable.staticList;

/**
 * 链表单节点
 * 
 * @author 83771
 *
 */
public class Node {
	// 节点数据
	private String data;
	// 游标
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
