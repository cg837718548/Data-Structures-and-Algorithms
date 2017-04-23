package figure.neighborhoodMatrix.nodirection;

import java.util.ArrayList;
import java.util.List;

/**
 * Õº¡ŸΩ◊æÿ’Û≤‚ ‘¿‡
 * 
 * @author 83771
 *
 */
public class NeighborhoodMatrixTest {

	public static void main(String[] args) {
		List<Node> lists = new ArrayList<>();
		Node node1 = new Node("111");
		lists.add(node1);
		Node node2 = new Node("112");
		lists.add(node2);
		Node node3 = new Node("113");
		lists.add(node3);
		Node node4 = new Node("114");
		lists.add(node4);
		Node node5 = new Node("115");
		lists.add(node5);
		Node node6 = new Node("116");
		lists.add(node6);

		NeighborhoodMatrix matrix = new NeighborhoodMatrix();
		matrix.initMatrix(lists);
		matrix.setConnect(node1, node5);
		matrix.setConnect(node5, node1);
		matrix.setConnect(node2, node6);
		matrix.setConnect(node6, node2);
		matrix.setConnect(node3, node4);
		matrix.setConnect(node4, node3);
		
		matrix.Output();
	}
}
