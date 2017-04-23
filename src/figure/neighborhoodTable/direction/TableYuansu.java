package figure.neighborhoodTable.direction;

public class TableYuansu {

	private String data;
	private LinkList linkList ;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LinkList getLinkList() {
		return linkList;
	}

	public void setLinkList(LinkList linkList) {
		this.linkList = linkList;
	}

	public TableYuansu(String data) {
		super();
		this.data = data;
	}

	public TableYuansu() {
		super();
	}

}
