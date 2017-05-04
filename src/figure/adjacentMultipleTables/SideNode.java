package figure.adjacentMultipleTables;

/**
 * 邻接多重表的边界点类型
 * 
 * @author 83771
 *
 */
public class SideNode {

	private int iVax;
	private int jVax;
	private SideNode iLink;
	private SideNode jLink;

	public int getiVax() {
		return iVax;
	}

	public void setiVax(int iVax) {
		this.iVax = iVax;
	}

	public int getjVax() {
		return jVax;
	}

	public void setjVax(int jVax) {
		this.jVax = jVax;
	}

	public SideNode getiLink() {
		return iLink;
	}

	public void setiLink(SideNode iLink) {
		this.iLink = iLink;
	}

	public SideNode getjLink() {
		return jLink;
	}

	public void setjLink(SideNode jLink) {
		this.jLink = jLink;
	}
	

}
