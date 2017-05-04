package figure.breadthTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import figure.neighborhoodMatrix.nodirection.NeighborhoodMatrix;
import figure.neighborhoodMatrix.nodirection.Node;

/**
 * ͼ�Ĺ�ȱ���
 * 
 * @author 83771
 *
 */
public class breadthTraversal {

	/**
	 * ͼ�Ĺ�ȱ�������
	 */
	public static void BTSTraveres(NeighborhoodMatrix matrix) {
		int i, j;
		Node node; // ��¼��������
		int quantity = matrix.gainQuantity();
		boolean[] flags = new boolean[quantity];
		// ��������
		Queue<Node> queue = new ArrayDeque<>();
		// ��ʼ��ͼ�ĸ�������״̬
		for (i = 0; i < quantity; i++) {
			flags[i] = false;
		}

		// for (i = 0; i < quantity; i++) {
		if (!flags[0]) {
			node = matrix.getSerialNumbers().get(0);
			System.out.println(node.getData());
			flags[0] = true;
			queue.add(node);

			while (!queue.isEmpty()) {
				Node polldata = queue.poll();
				i = matrix.getSerialNumbers().indexOf(polldata);
				System.out.println("����ֵ" + i);
				for (j = 0; j < quantity; j++) {
					if (matrix.getMatrix()[i][j] > 0 && !flags[j]) {
						node = matrix.getSerialNumbers().get(j);
						System.out.println(node.getData());
						flags[j] = true;
						queue.add(node);
					}
				}
			}

		
		}
	}


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
		matrix.setConnect(node1, node3);
		matrix.setConnect(node2, node4);
		matrix.setConnect(node2, node6);
		matrix.setConnect(node3, node5);
		matrix.setConnect(node3, node6);
		matrix.setConnect(node4, node5);

		BTSTraveres(matrix);

	}
}
