package LinearTable.chain;

/**
 *������ڵ���
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
	 * ��ȡ�ýڵ������
	 */
	public String getData(){
		return this.data;
	}
	
	
}
