package LinearTable.twoWayLinklist;

public class TwoWayLinkList {

	//����ͷ�ڵ�
	private Node first = new Node();
	
	//��ʼ������
	public void initList(){
		Node temp = first;
		Node target = first;
		for(int i = 0;i<26;i++){
			//�����ڵ�
			temp = new Node((char)(i+65));
			//�����ڵ�ǰһ��Ϊ��ǰ�ڵ�
			temp.setPrevious(target);
			//�����ڵ����һ�ڵ���ڵ�ǰ�ڵ����һ�ڵ�
			temp.setNext(target.getNext());
			//��ǰ�ڵ����һ�ڵ���������ڵ�
			target.setNext(temp);
			//�������ڵ���Ϊ��ǰ�ڵ�
			target = temp;
		}
		//��ͷ�ڵ����һ���ڵ��ǰ�ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		first.getNext().setPrevious(target);
		//��ǰ�ڵ����һ���ڵ���Ϊͷ�ڵ����һ���ڵ�
		target.setNext(first.getNext());
	}
	
	public void panduan(int i ){
		Node target = first;
		
		if(i>0){
			for( ;i!=0;i-- ){
				target = target.getNext();
			}
		}
		else if(i<0){
			for( ;i!=0;i++){
				target = target.getPrevious();
			}
		}
		
		for(int j= 0;j<26;j++){
			System.out.print(target.getNext().getData()+">");
			target = target.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		TwoWayLinkList linkList = new TwoWayLinkList();
		
		linkList.initList();
		linkList.panduan(3);
		
	}
	
}
