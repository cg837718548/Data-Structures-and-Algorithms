package LinearTable.CircularList;

public class circleTest2 {
	public static void main(String[] args) {
		CircleList list = new CircleList();
		CircleList  list2  = new CircleList();
		
		list.initList();
		list2.initList();
		
		list.connect(list, list2);
	}
}
