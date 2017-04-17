package LinearTable.CircularList;
/**
 * 循环链表类
 * @author 83771
 *
 */

import java.util.Scanner;

public class CircleList {

	// 头节点
	private Node first;

	// 尾节点

	private Node end;
	
	

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public void initList() {
		Scanner scanner = new Scanner(System.in);
		String data;
		Node temp;
		Node target;
		System.out.println("请输入需要插入的值，完成初始化");
		while (true) {
			data = scanner.nextLine();
			if (data.equals("")) {
				System.out.println("初始化结束");
				return;
			}
			if (first == null) {
				first = new Node(data);
				first.setNext(first);
			} else {
				// 找到链表中最后一个节点
				for (target = first; !target.getNext().equals(first); target = target.getNext())
					;

				// 生成一个新的节点
				temp = new Node(data);
				temp.setNext(target.getNext());
				target.setNext(temp);
			}
		}
	}

	/*
	 * 指定位置插入节点
	 */
	public void insertData() {
		Scanner scanner = new Scanner(System.in);
		Node temp;
		Node target;
		String data;
		int i;
		int j = 1;

		System.out.println("请输入要插入的值");
		data = scanner.nextLine();
		System.out.println("请输入插入的位置");
		i = scanner.nextInt();
		if (data.equals("")) {
			System.out.println("不能没有值");
			return;
		}
		if (i == 1) {
			// 新插入节点作为第一个节点
			temp = new Node(data);

			// 寻找最后一个节点
			for (target = first; target.getNext() != first; target = target.getNext())
				;

			temp.setNext(target.getNext());
			target.setNext(temp);
			first = temp;
			System.out.println("结束");
		} else {
			target = first;
			for (; j < i - 1; j++) {
				target = target.getNext();
			}
			temp = new Node(data);
			temp.setNext(target.getNext());
			target.setNext(temp);
			System.out.println("结束");
		}
	}

	/*
	 * 删除节点
	 */
	public void deleteData() {
		Scanner scanner = new Scanner(System.in);
		Node target;
		Node temp;
		int i;
		System.out.println("请输入要删除的位置");
		i = scanner.nextInt();
		if (i == 1) {
			for (target = first; target.getNext() != first; target = target.getNext())
				;
			temp = first;
			first = first.getNext();
			target.setNext(first);
			temp = null;
			System.out.println("结束");
		} else {
			target = first;
			for (int L = 1; L < i - 1; L++) {
				target = target.getNext();
			}
			temp = target.getNext();
			target.setNext(temp.getNext());
			temp = null;
			System.out.println("结束");
		}
	}

	/*
	 * 返回节点所在位置
	 */
	public void getIndex() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查找的值");
		String data = scanner.nextLine();
		Node target = first;
		int i = 1;
		while (!target.getData().equals(data)) {
			if (target.getNext() == first) {
				System.out.println("无");
				System.out.println("结束");
				return;
			}
			target = target.getNext();
			i++;
		}
		System.out.println(i);
		System.out.println("结束");

	}

	/*
	 * 依次返回所有节点的值
	 */
	public void getAll() {
		Node target;
		for (target = first; target.getNext() != first; target = target.getNext()) {
			System.out.print(target.getData() + ">");
		}
		System.out.print(target.getData());
		System.out.println();
	}

	/*
	 * 返回链表的中间节点
	 */
	public void getMedium() {
		Node search = first;
		Node mid = first;
		while (search.getNext() != first) {
			if (search.getNext().getNext() != first) {
				search = search.getNext().getNext();
				mid = mid.getNext();
			} else {
				search = search.getNext();
			}
		}
		System.out.println(mid.getData());
	}

	/*
	 * 解决约瑟夫问题
	 */
	public void resolve() {
		int k = 2;
		Node temp = first;
		Node target = first;

		// 判断链表中是否仅有一个节点
		while (target.getNext() != target) {
			for (int i = 1; i < k - 1; i++) {
				// 将当前节点后移
				target = target.getNext();
			}
			temp = target.getNext();
			System.out.print(temp.getData() + "-->");
			// 节点删除
			target.setNext(temp.getNext());
			target = target.getNext();
			temp = null;
		}
		System.out.print(target.getData());
		System.out.println();

	}

	/*
	 * 加强版约瑟夫问题
	 */
	public void resolve2() {
		int k[] = { 1, 2, 3, 2, 1, 3 };
		Node temp = first;
		Node target = first;
		int j = 1;

		// 判断链表中是否仅有一个节点
		while (target.getNext() != target) {
			for (int i = 1; i < k[j] - 1; i++) {
				// 将当前节点后移
				target = target.getNext();
			}
			temp = target.getNext();
			System.out.print(temp.getData() + "-->");
			// 节点删除
			target.setNext(temp.getNext());
			target = target.getNext();
			temp = null;
			j++;
		}
		System.out.print(target.getData());
		System.out.println();

	}

	/*
	 * 连接两个循环链表
	 */
	public void connect(CircleList list, CircleList list2) {
		Node temp;
		for (temp = list.first; temp.getNext() != list.first; temp = temp.getNext()) ;
		list.end = temp;
		for (temp = list2.first; temp.getNext() != list2.first; temp = temp.getNext()) ;
		list2.end = temp;

		list.end.setNext(list2.first);
		list2.end.setNext(list.first);
		
		for(temp = list2.end;temp.getNext()!=list2.end;temp = temp.getNext()){
			System.out.print(temp.getData()+">");
		}
		System.out.print(temp.getData());
	}
	
	/*
	 * 判断链表中是否有环
	 */
	public void isHuan(){
		
		int pos = 0;
		int jishu = 0;
		Node temp = first;
		Node target = first;
		
		while(target.getNext()!=null){
			target = target.getNext();
			pos++;
			for(;temp.getData()!=target.getData();temp = temp.getNext()){
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
	
	/*
	 * 判断链表中是否有环(快慢指针)
	 */
	public void isHuan2(){
		Node kuai = first;
		Node  man = first;
		
		for(kuai = kuai.getNext().getNext();kuai.getData()!=null&&kuai.getNext()!=null;kuai = kuai.getNext().getNext()){
			man = man.getNext();
			if(man.getData()==kuai.getData()){
				System.out.println("改链表存在环");
				return;
			}
		}
	}

}
