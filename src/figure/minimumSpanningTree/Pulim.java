package figure.minimumSpanningTree;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodMatrix.nodirection.NeighborhoodMatrix;
import figure.neighborhoodMatrix.nodirection.Node;

/**
 * ��С������������ķ�㷨��
 * 
 * @author 83771
 *
 */
public class Pulim {

	/**
	 * ������ض�����±�
	 */
	private static int adjvex[];
	/**
	 * ������ض�����Ȩֵ
	 */
	private static int powcost[];

	/**
	 * ��С�������ķ���
	 */
	public static void pulim(NeighborhoodMatrix matrix) {
		int min, i, j, k, MAXVEX = matrix.gainQuantity();
		adjvex = new int[MAXVEX];
		powcost = new int[MAXVEX];

		// v0��Ϊ��С�������ĸ�����Ϊ�����Ŀ�ʼ
		powcost[0] = 0;
		adjvex[0] = 0;

		// ��ʼ������
		for (i = 1; i < MAXVEX; i++) {
			powcost[i] = matrix.getMatrix()[0][i]; // ���ڽӾ����0������Ȩֵ�ȼ�������
			adjvex[i] = 0; // ��ʼ��ȫ��Ϊvo�±�
		}

		// ��С����������
		for (i = 1; i < MAXVEX; i++) {
			min = Integer.MAX_VALUE;
			j = 1;
			k = 0;
			// �������еĶ���
			while (j < MAXVEX) {
				// �ҳ�powcost֮���Դ�����С��Ȩֵ
				if (powcost[j] != 0 && powcost[j] < min) {
					min = powcost[j];
					k = j; // ����Сֵ�±����k��������
				}
				j++;
			}

			// ��ӡ��ǰ����Ȩֵ��С�ı�
			System.out.println(adjvex[k] + "---->" + k);
			powcost[k] = 0; // ����ǰ�����Ȩֵ����Ϊ0����ʾ�˶�����������񣬽�����һ������ı���

			// �ڽӾ���k���������
			for (j = 1; j < MAXVEX; j++) {
				if (powcost[j] != 0 && matrix.getMatrix()[k][j] < powcost[j]) {
					powcost[j] = matrix.getMatrix()[k][j];
					adjvex[j] = k;
				}  
			}
		}

	}

	public static void main(String[] args) {
		List<Node> lists = new ArrayList<>();
		Node node0 = new Node("110");
		lists.add(node0);
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

		NeighborhoodMatrix matrix = new NeighborhoodMatrix();
		matrix.initMatrix(lists);
		matrix.setConnect(node0, node1, 6);
		matrix.setConnect(node0, node2, 1);
		matrix.setConnect(node0, node3, 5);
		matrix.setConnect(node1, node2, 5);
		matrix.setConnect(node1, node4, 3);
		matrix.setConnect(node2, node3, 7);
		matrix.setConnect(node2, node4, 5);
		matrix.setConnect(node2, node5, 4);
		matrix.setConnect(node3, node5, 2);
		matrix.setConnect(node4, node5, 6);

		matrix.Output();

		pulim(matrix);
	}
}
