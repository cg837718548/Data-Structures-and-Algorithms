package LinearTable.CircularList;
/**
 * ѭ��������
 * @author 83771
 *
 */

import java.util.Scanner;

public class CircleList {

	//ͷ�ڵ�
	 private Node first;


	public void initList() {
		Scanner scanner = new Scanner(System.in);
		String data;
		Node temp;
		Node target;
		System.out.println("��������Ҫ�����ֵ����ɳ�ʼ��");
		while (true) {
			data = scanner.nextLine();
			if(data.equals("")){
				System.out.println("��ʼ������");
				return;
			}
			if(first ==null){
				first = new Node(data);
				first.setNext(first);
			}
			else{
				//�ҵ����������һ���ڵ�
				for(target = first;!target.getNext().equals(first);target = target.getNext());
				
				//����һ���µĽڵ�
				temp = new Node(data);
				temp.setNext(target.getNext());
				target.setNext(temp);
			}
		}
	}
	
	/*
	 * ָ��λ�ò���ڵ�
	 */
	public void insertData(){
		Scanner scanner = new Scanner(System.in);
		Node temp;
		Node target;
		String data;
		int i;
		int j = 1;
		
		System.out.println("������Ҫ�����ֵ");
		data = scanner.nextLine();
		System.out.println("����������λ��");
		i = scanner.nextInt();
		if(data.equals("")){
			System.out.println("����û��ֵ");
			return;
		}
		if(i==1){
			//�²���ڵ���Ϊ��һ���ڵ�
			temp = new Node(data);
			
			//Ѱ�����һ���ڵ�
			for(target = first;target.getNext()!=first;target = target.getNext());
			
			temp.setNext(target.getNext());
			target.setNext(temp);
			first = temp;
			System.out.println("����");
		}
		else{
			target = first;
			for(;j<i-1;j++){
				target = target.getNext();
			}
			temp = new Node(data);
			temp.setNext(target.getNext());
			target.setNext(temp);
			System.out.println("����");
		}
	}
	
	/*
	 * ɾ���ڵ�
	 */
	public void deleteData(){
		Scanner scanner = new Scanner(System.in);
		Node target ;
		Node temp;
		int i;
		System.out.println("������Ҫɾ����λ��");
		i = scanner.nextInt();
		if(i==1){
			for(target = first;target.getNext()!=first;target  = target.getNext());
			temp = first;
			first = first.getNext();
			target.setNext(first);
			temp = null;
			System.out.println("����");
		}
		else{
			target = first;
			for(int L=1;L<i-1;L++){
				target = target.getNext();
			}
			temp  = target.getNext();
			target.setNext(temp.getNext());
			temp=null;
			System.out.println("����");
		}
	}
	
	/*
	 * ���ؽڵ�����λ��
	 */
	public void getIndex(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ���ҵ�ֵ");
		String data = scanner.nextLine();
		Node target = first;
		int i=1;
		while(!target.getData().equals(data)){
			if(target.getNext() == first){
				System.out.println("��");
				System.out.println("����");
				return ;
			}
			target = target.getNext();
			i++;
		}
		System.out.println(i);
		System.out.println("����");
		
	}
	
	/*
	 * ���η������нڵ��ֵ
	 */
	public void getAll(){
		Node target ;
		for(target = first;target.getNext()!=first;target=target.getNext()){
			System.out.print(target.getData()+">");
		}
		System.out.print(target.getData());
		System.out.println();
	}
	
	/*
	 *����������м�ڵ�
	 */
	public void getMedium(){
		Node search = first;
		Node mid = first;
		while(search.getNext()!=first){
			if(search.getNext().getNext()!=first){
				search = search.getNext().getNext();
				mid = mid.getNext();
			}else{
				search = search.getNext();
			}
		}
		System.out.println(mid.getData());
	}

}
