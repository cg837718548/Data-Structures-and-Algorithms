package figure.neighborhoodTable.nodirection;

/**
 *������ڵ���
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
	 * ��ȡ�ýڵ������
	 */
	public Integer getData(){
		return this.data;
	}
	
	
}
