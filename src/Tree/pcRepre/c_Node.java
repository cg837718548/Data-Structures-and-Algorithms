package Tree.pcRepre;

/**
 * 孩子节点类
 * 
 * @author 83771
 *
 */
public class c_Node {
	private int child;
	private c_Node node;

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public c_Node getNode() {
		return node;
	}

	public void setNode(c_Node node) {
		this.node = node;
	}

	public c_Node(int child, c_Node node) {
		super();
		this.child = child;
		this.node = node;
	}

	public c_Node(c_Node node) {
		super();
		this.node = node;
	}

	public c_Node(int child) {
		super();
		this.child = child;
	}

	public c_Node() {
		super();
	}

}
