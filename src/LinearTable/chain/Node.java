package LinearTable.chain;

/**
 *单链表节点类
 * @author 83771
 *
 */
public class Node {
	
	
	private  String data;
	public Node next;
	
	public Node(String data) {
		super();
		this.data = data;
	}

	/*
	 * 获取该节点的内容
	 */
	public String getData(){
		return this.data;
	}
	
	
}
