package Tree.parentalRepresentation;

/**
 * ���ĵĽڵ��� ˫�ױ�ʾ��
 * 
 * @author 83771
 *
 */
public class Node {
	// �ڵ���������
	private String data;
	// ��¼˫�׵�λ��
	private int parent;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public Node(String data) {
		super();
		this.data = data;
	}

	public Node(String data, int parent) {
		super();
		this.data = data;
		this.parent = parent;
	}

	public Node() {
		super();
	}

}
