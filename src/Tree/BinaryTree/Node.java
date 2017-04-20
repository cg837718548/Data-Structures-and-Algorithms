package Tree.BinaryTree;

/**
 * 二叉树的节点类
 * 
 * @author 83771
 *
 */
public class Node {

	private String data;
	private Node l_node;
	private Node r_node;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getL_node() {
		return l_node;
	}

	public void setL_node(Node l_node) {
		this.l_node = l_node;
	}

	public Node getR_node() {
		return r_node;
	}

	public void setR_node(Node r_node) {
		this.r_node = r_node;
	}

	public Node(String data, Node l_node, Node r_node) {
		super();
		this.data = data;
		this.l_node = l_node;
		this.r_node = r_node;
	}
	

	public Node(String data) {
		super();
		this.data = data;
	}

	public Node() {
		super();
	}

}
