package Tree.pcRepre;

/**
 * 表头结构（双亲孩子表示法）
 * @author 83771
 *兄弟孩子表示法
 */
public class c_Box2 {

	private String data;
	private int bl;
	private int br;
	private c_Node c_Node;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getBl() {
		return bl;
	}
	public void setBl(int bl) {
		this.bl = bl;
	}
	public int getBr() {
		return br;
	}
	public void setBr(int br) {
		this.br = br;
	}
	public c_Node getC_Node() {
		return c_Node;
	}
	public void setC_Node(c_Node c_Node) {
		this.c_Node = c_Node;
	}
	public c_Box2() {
		super();
	}
	
	
}
