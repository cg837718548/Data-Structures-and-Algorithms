package figure.depthTraversal;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodMatrix.direction.NeighborhoodMatrix;
import figure.neighborhoodMatrix.direction.Node;

/**
 * 图的深度遍历(邻接矩阵版)
 * 
 * @author 83771
 *
 */
public class DepthTraversal {

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
		matrix.setConnect(node1, node2);
		matrix.setConnect(node2, node3);
		matrix.setConnect(node3, node6);
		matrix.setConnect(node6, node5);
		matrix.setConnect(node5, node4);
		matrix.setConnect(node4, node1);
		matrix.setConnect(node1, node5);
		

		for (int i = 0; i < matrix.getMatrix().length; i++) {
			for (int j = 0; j < matrix.getMatrix().length; j++) {
				System.out.print("   " + matrix.getMatrix()[i][j]);
			}
			System.out.println();
		}

		traversal(matrix.getMatrix(), 0, matrix);
	}

	public static void traversal(int[][] qipan, int i, NeighborhoodMatrix matrix) {
		int length = qipan.length;
		for (int k = 0; k < length; k++) {
			// 判断第i行上的连接情况
			if (qipan[i][k] > 0) {
				System.out.println(matrix.getSerialNumbers().get(i).getData());
				for (int j = 0; j < length; j++) {
					qipan[j][k] = 0;
				}
				traversal(qipan, k, matrix);
			}
		}
	}
}
