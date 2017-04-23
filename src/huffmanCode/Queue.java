package huffmanCode;

/**
 * 队列
 * 
 * @author 83771
 *
 */
public class Queue {

	private Node front;
	private Node rear;

	/*
	 * 创建一个链队列
	 */
	public void initQueue(char data) {
		Node temp = new Node(data);
		// 将头指针节点赋值为新节点
		front = temp;
		// 将尾指针节点赋值为新节点
		rear = temp;
	}

	/*
	 * 入队列操作
	 */
	public void insertQueue(char data) {
		Node temp = new Node(data);
		// 将新节点的next指向null
		temp.setNext(null);
		// 将队列尾指针的next指向temp
		rear.setNext(temp);
		// 将尾指针后移一位
		rear = temp;
	}

	/*
	 * 出队列操作
	 */
	public Node outQueue() {
		// 将队列的头指针元素赋值给temp
		Node temp = front;
		// 取出头指针的数据
		char data = temp.getData();
		// 将头指针后移一位
		front = temp.getNext();
		// 若头指针为null即队列中已经没有元素
		if (front == null) {
			rear = null;
			return temp;
		}
//		temp = null;
		return temp;
	}

	/*
	 * 依次取出所有的数据
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
	 * 销毁队列的操作
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
		// queue.initQueue("第一");
		// queue.insertQueue("第二");
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
