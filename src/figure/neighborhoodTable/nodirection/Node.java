package figure.neighborhoodTable.nodirection;

/**
 *������ڵ���
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
	 * ��ȡ�ýڵ������
	 */
	public Integer getData(){
		return this.data;
	}
	
	
}
