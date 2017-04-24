package figure.adjacentmultipletables;
/**
 * 邻接多重表测试类
 * @author 83771
 *
 */

import java.util.LinkedList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		AdjacentMultipleTable multipleTable = new AdjacentMultipleTable();
		Node node1 = new Node("1111");
		Node node2 = new Node("1112");
		Node node3 = new Node("1113");
		Node node4 = new Node("1114");
		Node node5 = new Node("1115");
		Node node6 = new Node("1116");
		
		List<Node> lists = new LinkedList<>();
		lists.add(node1);
		lists.add(node2);
		lists.add(node3);
		lists.add(node4);
		lists.add(node5);
		lists.add(node6);
		
		multipleTable.initTable(lists);
		multipleTable.setConnect(node1, node2);
		multipleTable.setConnect(node1, node3);
		multipleTable.setConnect(node4, node5);
		multipleTable.setConnect(node2, node4);
		multipleTable.outAll();
	}

}
