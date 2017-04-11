package LinearTable.chain;


/**
 * ��������
 * @author 83771
 *
 */
public class LinkList {

	//ͷ�ڵ�
	public  Node first;
	//��¼�ڵ�λ��
	public int  position = 0;
	
	/*
	 * ����ͷ�ڵ�
	 */
	public void insertHead(String data){
		//����һ���ڵ�
		Node node = new Node(data);
		//���ýڵ��next��Ϊnull
		node.next  = first;
		//���ýڵ��������Ϊfirst
		first = node;
	}
	
	/*
	 * ɾ��ͷ�ڵ�
	 */
	public Node deleteHead(){
		//����tempNodeΪͷ�ڵ�
		Node tempNode = first;
		//��ͷ�ڵ��Ϊnull
		first = tempNode.next;
		//����ͷ�ڵ�
		return tempNode;
	}
	
	/*
	 * ��ָ��λ�ò���ڵ�
	 */
	public void insertNode(int index,String data){
		if(index ==0){
			this.insertHead(data);
		}
		//����һ���½ڵ�
		Node node = new Node(data);
		//����һ����ǰ�ڵ�
		Node current =  first;
		//���嵱ǰ�ڵ�ǰһ���ڵ�
		Node previous = first;
		
		//��ָ��λ��С��ָ��λ��ʱ
		while(index>position){
			if(current.next==null){
				return;
			}
			previous = current;
			current = previous.next;
			position++;
		}
		node.next = current;
		previous.next = node;
		position = 0;
	}
	
	
	/*
	 * ɾ��ָ��λ�õĽڵ�
	 */
	public Node deleteNode(int index){
		if(index==0){
			deleteHead();
		}
		Node current  = first;
		Node previous = first;
		while(position<index){
			if(current.next==null){
				return null;
			}
			previous = current;
			current = previous.next;
			position++;
		}
		//��ǰ�ڵ�Ϊͷ�ڵ�
		if(current == first){
			first = first.next;
		}else{
			previous.next = current.next;
			position = 0;
		}
		return current;
	}
	
	/*
	 * ���ݽڵ��dataɾ��ָ���ڵ㣨��ɾ����ͷ�ڵ������һ���ڵ㣩
	 */
	public Node deleteNodebyData(String data){
		Node current = first;
		Node previous = first;
		while(!current.getData().equals(data)){
			if(current.next ==null){
				return null;
			}
			previous = current;
			current = previous.next;
		}
		if(current ==first){
			first = first.next;
		}
		else{
			previous.next = current.next;
		}
		return current;
	}
	
	/*
	 *��ʾ�����нڵ����Ϣ
	 */
	public void showAlldata(){
		Node current = first;
		while(current!=null){
			System.out.println(current.getData());
			current = current.next;
		}
	}
	
	/*
	 * ����λ�ò��ҽڵ���Ϣ
	 */
	public Node findByposition(int position){
		Node current = first;
		while(this.position<position){
			if(current.next == null){
				return null;
			}
			current = current.next;
			position++;
		}
		return current;
	}
	
	/*
	 *�������ݲ��ҽڵ�
	 */
	public Node findBydata(String data){
		Node current = first;
		while(!current.getData().equals(data)){
			if(current.next == null){
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	/**
	 * @author Jeker_chen
	 * ���ÿ���ָ��Ѹ���ҵ�
	 */
	public Node getMedium(){
		Node search;
		Node mid;
		search = first;
		mid = first;
		while(search.next!=null){
			if(search.next.next!=null){
				search = search.next.next;
				mid = mid.next;
			}
			else{
				search = search.next;
			}
		}
		return mid;
	}
	
}
