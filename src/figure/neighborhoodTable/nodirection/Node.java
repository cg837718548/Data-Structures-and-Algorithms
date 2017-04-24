package figure.neighborhoodTable.nodirection;

/**
 *单链表节点类
 * @author 83771
 *
 */
public class Node {
	
	
	private  Integer data;
	public Node next;
	
	public Node(Integer data) {
		super();
		this.data = data;
	}

	/*
	 * 获取该节点的内容
	 */
	public Integer getData(){
		return this.data;
	}
	
	
}
