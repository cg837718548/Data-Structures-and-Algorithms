package figure.crossList;

/**
 * 十字链表的结点结构
 * 
 * @author 83771
 *
 */
public class VertexNode {

	private String data;

	private SideNode firstIn;
	private SideNode firstOut;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public SideNode getFirstIn() {
		return firstIn;
	}

	public void setFirstIn(SideNode firstIn) {
		this.firstIn = firstIn;
	}

	public SideNode getFirstOut() {
		return firstOut;
	}

	public void setFirstOut(SideNode firstOut) {
		this.firstOut = firstOut;
	}

	public VertexNode(String data, SideNode firstIn, SideNode firstOut) {
		super();
		this.data = data;
		this.firstIn = firstIn;
		this.firstOut = firstOut;
	}

	public VertexNode() {
		super();
	}

	public VertexNode(String data) {
		super();
		this.data = data;
	}

}
