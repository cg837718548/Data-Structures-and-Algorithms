package Tree.parentalRepresentation;

/**
 * 树的的节点类 双亲表示法
 * 
 * @author 83771
 *
 */
public class Node {
	// 节点所存数据
	private String data;
	// 记录双亲的位置
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
