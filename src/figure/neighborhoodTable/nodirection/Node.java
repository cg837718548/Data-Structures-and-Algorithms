package figure.neighborhoodTable.nodirection;

/**
 *单链表节点类
 * @author 83771
 *
 */
public class Node {
	
	
	private  Integer data;
	private  Integer pow;
	public Node next;
	
	public Node(Integer data) {
		super();
		this.data = data;
	}
	
	
	

	public Node(Integer data, Integer pow) {
		super();
		this.data = data;
		this.pow = pow;
	}




	public Integer getPow() {
		return pow;
	}


	public void setPow(Integer pow) {
		this.pow = pow;
	}


	/*
	 * 获取该节点的内容
	 */
	public Integer getData(){
		return this.data;
	}
	
	
}
