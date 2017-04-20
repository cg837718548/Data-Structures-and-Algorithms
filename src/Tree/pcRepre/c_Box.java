package Tree.pcRepre;

/**
 * 表头结构（双亲孩子表示法）
 * @author 83771
 *
 */
public class c_Box {

	private String data;
	private int parent;
	private c_Node c_Node;
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
	public c_Node getC_Node() {
		return c_Node;
	}
	public void setC_Node(c_Node c_Node) {
		this.c_Node = c_Node;
	}
	public c_Box(String data, int parent, Tree.pcRepre.c_Node c_Node) {
		super();
		this.data = data;
		this.parent = parent;
		this.c_Node = c_Node;
	}
	public c_Box() {
		super();
	}
	
	
}
