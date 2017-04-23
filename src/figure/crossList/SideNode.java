package figure.crossList;

/**
 * 十字链表边结点结构
 * 
 * @author 83771
 *
 */
public class SideNode {

	private int tailVex;
	private int headVex;
	private SideNode headLink;
	private SideNode tailLink;

	public int getTailVex() {
		return tailVex;
	}

	public void setTailVex(int tailVex) {
		this.tailVex = tailVex;
	}

	public int getHeadVex() {
		return headVex;
	}

	public void setHeadVex(int headVex) {
		this.headVex = headVex;
	}

	public SideNode getHeadLink() {
		return headLink;
	}

	public void setHeadLink(SideNode headLink) {
		this.headLink = headLink;
	}

	public SideNode getTailLink() {
		return tailLink;
	}

	public void setTailLink(SideNode tailLink) {
		this.tailLink = tailLink;
	}

	public SideNode(int tailVex, int headVex, SideNode headLink, SideNode tailLink) {
		super();
		this.tailVex = tailVex;
		this.headVex = headVex;
		this.headLink = headLink;
		this.tailLink = tailLink;
	}

	public SideNode() {
		super();
	}

}
