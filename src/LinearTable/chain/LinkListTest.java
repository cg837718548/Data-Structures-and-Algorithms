package LinearTable.chain;

public class LinkListTest {

	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		
		linkList.insertHead("ͷ");
		linkList.insertHead("ͷ1");
		linkList.insertHead("ͷ2");
		linkList.insertHead("ͷ3");
		linkList.insertHead("ͷ4");
		linkList.insertHead("ͷ5");
		
		System.out.println("++++++++++++++++++");
		System.out.println(linkList.getMedium().getData());
		System.out.println("++++++++++++++++++");
		linkList.showAlldata();
		System.out.println("--------------");
		
		linkList.deleteHead();
		linkList.showAlldata();
		System.out.println("--------------");
		
		
		linkList.insertNode(2,"��");
		linkList.showAlldata();
		System.out.println("--------------");
		
		linkList.deleteNode(3);
		linkList.showAlldata();
		System.out.println("--------------");
		
		
		linkList.deleteNodebyData("ͷ1");
		linkList.showAlldata();
		System.out.println("--------------");
		
		Node node = linkList.findBydata("��");
		System.out.println(node.getData());
		
		Node node2 = linkList.findByposition(0);
		System.out.println(node2.getData());
		
	}

}
