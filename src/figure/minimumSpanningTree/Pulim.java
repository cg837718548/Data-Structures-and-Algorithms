package figure.minimumSpanningTree;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodMatrix.nodirection.NeighborhoodMatrix;
import figure.neighborhoodMatrix.nodirection.Node;

/**
 * 最小生成树（普里姆算法）
 * 
 * @author 83771
 *
 */
public class Pulim {

	/**
	 * 保存相关顶点的下标
	 */
	private static int adjvex[];
	/**
	 * 保存相关顶点间的权值
	 */
	private static int powcost[];

	/**
	 * 最小生成树的方法
	 */
	public static void pulim(NeighborhoodMatrix matrix) {
		int min, i, j, k, MAXVEX = matrix.gainQuantity();
		adjvex = new int[MAXVEX];
		powcost = new int[MAXVEX];

		// v0作为最小生成树的根，作为遍历的开始
		powcost[0] = 0;
		adjvex[0] = 0;

		// 初始化操作
		for (i = 1; i < MAXVEX; i++) {
			powcost[i] = matrix.getMatrix()[0][i]; // 将邻接矩阵第0行所有权值先加入数组
			adjvex[i] = 0; // 初始化全部为vo下标
		}

		// 最小生成树步骤
		for (i = 1; i < MAXVEX; i++) {
			min = Integer.MAX_VALUE;
			j = 1;
			k = 0;
			// 遍历所有的顶点
			while (j < MAXVEX) {
				// 找出powcost之中以储存最小的权值
				if (powcost[j] != 0 && powcost[j] < min) {
					min = powcost[j];
					k = j; // 将最小值下标存入k，待试用
				}
				j++;
			}

			// 打印当前变中权值最小的边
			System.out.println(adjvex[k] + "---->" + k);
			powcost[k] = 0; // 将当前顶点的权值设置为0，表示此鼎点已完成任务，进行下一个顶点的遍历

			// 邻接矩阵k行逐个遍历
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
