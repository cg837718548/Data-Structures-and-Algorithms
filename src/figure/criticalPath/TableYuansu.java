package figure.criticalPath;

public class TableYuansu {

	private String data;
	private int rudu;
	private LinkList linkList;

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

	public int getRudu() {
		return rudu;
	}

	public void setRudu(int rudu) {
		this.rudu = rudu;
	}

	public TableYuansu(String data) {
		super();
		this.data = data;
	}

	public TableYuansu() {
		super();
	}

}
