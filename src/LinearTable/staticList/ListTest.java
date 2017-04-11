package LinearTable.staticList;

public class ListTest {

	public static void main(String[] args) {
		StaticList list = new StaticList(100);
		list.initList();
		
		System.out.println(list.getLength()+"-----------");
		
		list.insertData(1, "��һ");
		list.insertData(2, "�ڶ�");
		list.insertData(3, "����");
		list.insertData(4, "����");
		list.insertData(5, "����");
//		list.insertData(6, "��6");
//		list.insertData(7, "��7");
//		list.insertData(8, "��8");
//		list.insertData(9, "��9");
//		list.insertData(10, "��0");
//		list.insertData(6, "����");
		
		list.getMedium();
		System.out.println("+++++++++++++++++++");
		list.getAllData();
		
		System.out.println(list.getLength()+"-----------");
		
		list.insertData(1, "diyi");
		list.getAllData();
		System.out.println(list.getLength()+"-----------");
		
		
		list.deleteData(1);
		list.deleteData(3);
		list.getAllData();
		System.out.println(list.getLength()+"-----------");
		
		list.deleteData(3);
		list.getAllData();
		System.out.println(list.getLength()+"-----------");
		
	}
	
}
