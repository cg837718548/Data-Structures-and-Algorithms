package LinearTable.twoWayLinklist;

public class TwoWayLinkList {

	//定义头节点
	private Node first = new Node();
	
	//初始化链表
	public void initList(){
		Node temp = first;
		Node target = first;
		for(int i = 0;i<26;i++){
			//新增节点
			temp = new Node((char)(i+65));
			//新增节点前一个为当前节点
			temp.setPrevious(target);
			//新增节点的下一节点等于当前节点的下一节点
			temp.setNext(target.getNext());
			//当前节点的下一节点等于新增节点
			target.setNext(temp);
			//将新增节点作为当前节点
			target = temp;
		}
		//将头节点的下一个节点的前节点设为当前节点最后一个节点
		first.getNext().setPrevious(target);
		//当前节点的下一个节点设为头节点的下一个节点
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
