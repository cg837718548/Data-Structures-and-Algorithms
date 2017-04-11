package LinearTable.staticList;

public class ListTest {

	public static void main(String[] args) {
		StaticList list = new StaticList(100);
		list.initList();
		
		System.out.println(list.getLength()+"-----------");
		
		list.insertData(1, "第一");
		list.insertData(2, "第二");
		list.insertData(3, "第三");
		list.insertData(4, "第四");
		list.insertData(5, "第五");
//		list.insertData(6, "第6");
//		list.insertData(7, "第7");
//		list.insertData(8, "第8");
//		list.insertData(9, "第9");
//		list.insertData(10, "第0");
//		list.insertData(6, "第六");
		
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
