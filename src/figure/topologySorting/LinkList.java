package figure.topologySorting;

import java.util.LinkedList;
import java.util.List;

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
	public void insertHead(int data){
		//定义一个节点
		Node node = new Node(data);
		//将该节点的next设为null
		node.next  = first;
		//将该节点变量名变为first
		first = node;
	}
	
	/*
	 * 插入头节点
	 */
	public void insertHead(int data , int pow){
		//定义一个节点
		Node node = new Node(data,pow);
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
	public void insertNode(int index,int data){
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
	public Node deleteNodebyData(int data){
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
	public List<Node> showAlldata(){
		List<Node> list=  new LinkedList<>();
		Node current = first;
		while(current!=null){
//			System.out.println(current.getData());
			list.add(current);
			current = current.next;
		}
		return list;
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
	
	/*
	 * 判断链表中是否有环
	 */
	public void isHuan(){
		int pos = 0;
		int jishu = 0;
		Node temp = first;
		Node target = first;
		
		while(target.next!=null){
			target = target.next;
			pos++;
			for(;temp.getData()!=target.getData();temp = temp.next){
				jishu++;
			}
			if(jishu !=pos){
				System.out.println("该链表存在环");
				return ;
			}
			temp = first;
			jishu = 0;
		}
	}
	
}
