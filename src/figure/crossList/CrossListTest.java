package figure.crossList;

import java.util.LinkedList;
import java.util.List;

/**
 * 十字链表的测试类
 * 
 * @author 83771
 *
 */
public class CrossListTest {

	public static void main(String[] args) {
		CrossList crossList = new CrossList();
		List<VertexNode> nodes = new LinkedList<>();
		VertexNode node1 = new VertexNode("11111");
		VertexNode node2 = new VertexNode("11112");
		VertexNode node3 = new VertexNode("11113");
		VertexNode node4 = new VertexNode("11114");
		VertexNode node5 = new VertexNode("11115");
		VertexNode node6 = new VertexNode("11116");
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);
		
		crossList.initCrossList(nodes);
		
		crossList.setConnect(node2, node1);
		crossList.setConnect(node3, node1);
		crossList.setConnect(node4, node1);
		crossList.setConnect(node5, node3);
		crossList.setConnect(node3, node6);
		crossList.setConnect(node6, node1);
		crossList.setConnect(node1, node6);
		
		
		crossList.outputAll();
		
		
		
		
	}
}
