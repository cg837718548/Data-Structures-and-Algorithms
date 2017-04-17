package Stack.queue;
/**
 * 循环队列的实现
 * @author 83771
 *
 */
public class CircleQueue {
	private static final int MAXSIZE = 4;

	//数据数组
	private String [] datas ;
	//头指针
	private int front;
	//尾指针
	private int rear;
	
	//队列的初始化
	public void initQueue(){
		this.datas = new String[MAXSIZE];
		front = rear = 0;
	}
	
	//队列的添加操作
	public void  insertData(String data){
		//判断队列是否已满(小甲鱼个傻逼，他的这个判断根本就是错的)
		if((rear)%MAXSIZE  == front&&datas[front]!=null){
			return ;
		}
		System.out.println("rear的值："+rear);
		datas[rear] = data;
		rear = (rear+1)%MAXSIZE;
	}
	
	//数据出队列的操作
	public String outData(){
		//判断队列是否为空
		if(rear == front && datas[front]==null){
			return null;
		}
		String data = datas[front];
		datas[front] = null;
		front = (front+1)%MAXSIZE;
		return data;
	}
	public static void main(String[] args) {
		//定义一个队列
		CircleQueue queue = new CircleQueue();
		queue.initQueue();
		queue.insertData("第一");
		queue.insertData("第2");
		queue.insertData("第3");
		queue.insertData("第4");
		System.out.println(queue.outData());
		System.out.println(queue.outData());
		System.out.println(queue.outData());
		queue.insertData("第5");
		System.out.println(queue.outData());
		System.out.println(queue.outData());
	}
	
	public String[] getDatas() {
		return datas;
	}
	public void setDatas(String[] datas) {
		this.datas = datas;
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}
	
}
