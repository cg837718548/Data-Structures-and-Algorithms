package huffmanCode;

/**
 * ����
 * 
 * @author 83771
 *
 */
public class Queue {

	private Node front;
	private Node rear;

	/*
	 * ����һ��������
	 */
	public void initQueue(char data) {
		Node temp = new Node(data);
		// ��ͷָ��ڵ㸳ֵΪ�½ڵ�
		front = temp;
		// ��βָ��ڵ㸳ֵΪ�½ڵ�
		rear = temp;
	}

	/*
	 * ����в���
	 */
	public void insertQueue(char data) {
		Node temp = new Node(data);
		// ���½ڵ��nextָ��null
		temp.setNext(null);
		// ������βָ���nextָ��temp
		rear.setNext(temp);
		// ��βָ�����һλ
		rear = temp;
	}

	/*
	 * �����в���
	 */
	public Node outQueue() {
		// �����е�ͷָ��Ԫ�ظ�ֵ��temp
		Node temp = front;
		// ȡ��ͷָ�������
		char data = temp.getData();
		// ��ͷָ�����һλ
		front = temp.getNext();
		// ��ͷָ��Ϊnull���������Ѿ�û��Ԫ��
		if (front == null) {
			rear = null;
			return temp;
		}
//		temp = null;
		return temp;
	}

	/*
	 * ����ȡ�����е�����
	 */
	public void outAll() {
		Node temp;
		while (front != null) {
			// System.out.println(front.getData()+"---"+rear.getData());
			temp = front;
			System.out.println(temp.getData());
			front = temp.getNext();
			temp = null;
		}
		rear = null;
	}

	/*
	 * ���ٶ��еĲ���
	 */
	public void destory() {
		Node temp;
		while (front != null) {
			temp = front;
			front = temp.getNext();
			temp = null;
		}
		rear = null;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		// queue.initQueue("��һ");
		// queue.insertQueue("�ڶ�");
		// queue.insertQueue("haha");
		// System.out.println(queue.outQueue());
		// System.out.println(queue.outQueue());
		// System.out.println(queue.outQueue());
		// queue.initQueue("11");
		//// System.out.println(queue.outQueue());
		//
		// queue.insertQueue("haha");
		// queue.insertQueue("hh");
		// queue.destory();
		// queue.outAll();
	}

	public Node getFront() {
		return front;
	}

	public void setFront(Node front) {
		this.front = front;
	}

	public Node getRear() {
		return rear;
	}

	public void setRear(Node rear) {
		this.rear = rear;
	}

}
