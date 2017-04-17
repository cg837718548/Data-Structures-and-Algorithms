package Stack.queue;
/**
 * ѭ�����е�ʵ��
 * @author 83771
 *
 */
public class CircleQueue {
	private static final int MAXSIZE = 4;

	//��������
	private String [] datas ;
	//ͷָ��
	private int front;
	//βָ��
	private int rear;
	
	//���еĳ�ʼ��
	public void initQueue(){
		this.datas = new String[MAXSIZE];
		front = rear = 0;
	}
	
	//���е���Ӳ���
	public void  insertData(String data){
		//�ж϶����Ƿ�����(С�����ɵ�ƣ���������жϸ������Ǵ��)
		if((rear)%MAXSIZE  == front&&datas[front]!=null){
			return ;
		}
		System.out.println("rear��ֵ��"+rear);
		datas[rear] = data;
		rear = (rear+1)%MAXSIZE;
	}
	
	//���ݳ����еĲ���
	public String outData(){
		//�ж϶����Ƿ�Ϊ��
		if(rear == front && datas[front]==null){
			return null;
		}
		String data = datas[front];
		datas[front] = null;
		front = (front+1)%MAXSIZE;
		return data;
	}
	public static void main(String[] args) {
		//����һ������
		CircleQueue queue = new CircleQueue();
		queue.initQueue();
		queue.insertData("��һ");
		queue.insertData("��2");
		queue.insertData("��3");
		queue.insertData("��4");
		System.out.println(queue.outData());
		System.out.println(queue.outData());
		System.out.println(queue.outData());
		queue.insertData("��5");
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
