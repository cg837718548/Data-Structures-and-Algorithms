package LinearTable.chain;

public class LinkListTest {

	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		
		linkList.insertHead("头");
		linkList.insertHead("头1");
		linkList.insertHead("头2");
		linkList.insertHead("头3");
		linkList.insertHead("头4");
		linkList.insertHead("头5");
		
		System.out.println("++++++++++++++++++");
		System.out.println(linkList.getMedium().getData());
		System.out.println("++++++++++++++++++");
		linkList.showAlldata();
		System.out.println("--------------");
		
		linkList.deleteHead();
		linkList.showAlldata();
		System.out.println("--------------");
		
		
		linkList.insertNode(2,"手");
		linkList.showAlldata();
		System.out.println("--------------");
		
		linkList.deleteNode(3);
		linkList.showAlldata();
		System.out.println("--------------");
		
		
		linkList.deleteNodebyData("头1");
		linkList.showAlldata();
		System.out.println("--------------");
		
		Node node = linkList.findBydata("手");
		System.out.println(node.getData());
		
		Node node2 = linkList.findByposition(0);
		System.out.println(node2.getData());
		
	}

}
