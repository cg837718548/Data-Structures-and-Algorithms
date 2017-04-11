package LinearTable.chain;


/**
 * 单链表类
 * @author 83771
 *
 */
public class LinkList {

	//头节点
	public  Node first;
	//记录节点位置
	public int  position = 0;
	
	/*
	 * 插入头节点
	 */
	public void insertHead(String data){
		//定义一个节点
		Node node = new Node(data);
		//将该节点的next设为null
		node.next  = first;
		//将该节点变量名变为first
		first = node;
	}
	
	/*
	 * 删除头节点
	 */
	public Node deleteHead(){
		//定义tempNode为头节点
		Node tempNode = first;
		//将头节点变为null
		first = tempNode.next;
		//返回头节点
		return tempNode;
	}
	
	/*
	 * 在指定位置插入节点
	 */
	public void insertNode(int index,String data){
		if(index ==0){
			this.insertHead(data);
		}
		//定义一个新节点
		Node node = new Node(data);
		//定义一个当前节点
		Node current =  first;
		//定义当前节点前一个节点
		Node previous = first;
		
		//当指针位置小于指定位置时
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
	 * 删除指定位置的节点
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
		//当前节点为头节点
		if(current == first){
			first = first.next;
		}else{
			previous.next = current.next;
			position = 0;
		}
		return current;
	}
	
	/*
	 * 根据节点的data删除指定节点（仅删除离头节点最近的一个节点）
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
	 *显示出所有节点的信息
	 */
	public void showAlldata(){
		Node current = first;
		while(current!=null){
			System.out.println(current.getData());
			current = current.next;
		}
	}
	
	/*
	 * 根据位置查找节点信息
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
	 *根据数据查找节点
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
	 * 利用快慢指针迅速找到
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
