package figure.adjacentmultipletables;

/**
 * �ڽӶ��ر�����ݽ��
 * 
 * @author 83771
 *
 */
public class Node {

	private String data;
	private SideNode sideNode;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public SideNode getSideNode() {
		return sideNode;
	}

	public void setSideNode(SideNode sideNode) {
		this.sideNode = sideNode;
	}

	public Node(String data) {
		super();
		this.data = data;
	}

	public Node() {
		super();
	}

}
