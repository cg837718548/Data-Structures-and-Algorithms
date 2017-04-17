package LinearTable.CircularList;
/**
 * 测试类   测试链中是否有环
 * @author 83771
 *
 */
public class circleTest3 {

	public static void main(String[] args) {
		CircleList list  = new CircleList();
		list.initList();
		Node temp;
		for (temp = list.getFirst(); temp.getNext() != list.getFirst(); temp = temp.getNext()) ;
		temp.setNext(null);
		list.isHuan2();
		
		
	}

}
