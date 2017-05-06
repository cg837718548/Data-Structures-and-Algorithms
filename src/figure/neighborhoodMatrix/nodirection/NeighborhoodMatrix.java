package figure.neighborhoodMatrix.nodirection;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻阶矩阵类
 * 
 * @author 83771
 *
 */
public class NeighborhoodMatrix {
	// 定义一个集合，按结点序号存放结点元素
	private List<Node> serialNumbers;
	// 定义一个矩阵，存放结点元素
	private int[][] matrix;

	// 初始化图
	public void initMatrix(List<Node> nodes) {
		int size = nodes.size();
		serialNumbers = nodes;
		matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = 37201;
				}
			}
		}
	}

	// 获取图的总节点数
	public int gainQuantity() {
		return matrix.length;
	}

	// 设置结点间的连接方法
	public void setConnect(Node node1, Node node2) {

		int n1 = serialNumbers.indexOf(node1);
		int n2 = serialNumbers.indexOf(node2);
		matrix[n1][n2] = 1;
		matrix[n2][n1] = 1;
	}

	// 设置结点间的连接方法
	public void setConnect(Node node1, Node node2, int pow) {

		int n1 = serialNumbers.indexOf(node1);
		int n2 = serialNumbers.indexOf(node2);
		matrix[n1][n2] = pow;
		matrix[n2][n1] = pow;
	}

	// 输出图中所有连接点
	public void Output() {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (matrix[i][j] > 0) {
					System.out.println(serialNumbers.get(i).getData() + "和" + serialNumbers.get(j).getData() + "相连接"
							+ "权为：" + matrix[i][j]);
				}
			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		List<String> lists = new ArrayList<>();
		lists.add("111");
		lists.add("112");
		lists.add("113");
		lists.add("114");
		lists.add("115");
		String[] strs = lists.toArray(new String[0]);
		System.out.println(strs.length);
		String[] strs1 = lists.toArray(new String[19]);
		System.out.println(strs.length);

	}

	public List<Node> getSerialNumbers() {
		return serialNumbers;
	}

	public void setSerialNumbers(List<Node> serialNumbers) {
		this.serialNumbers = serialNumbers;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

}
