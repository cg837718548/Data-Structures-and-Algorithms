package figure.neighborhoodMatrix.nodirection;

import java.util.ArrayList;
import java.util.List;

/**
 * �ڽ׾�����
 * 
 * @author 83771
 *
 */
public class NeighborhoodMatrix {
	// ����һ�����ϣ��������Ŵ�Ž��Ԫ��
	private List<Node> serialNumbers;
	// ����һ�����󣬴�Ž��Ԫ��
	private int[][] matrix;

	// ��ʼ��ͼ
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

	// ��ȡͼ���ܽڵ���
	public int gainQuantity() {
		return matrix.length;
	}

	// ���ý�������ӷ���
	public void setConnect(Node node1, Node node2) {

		int n1 = serialNumbers.indexOf(node1);
		int n2 = serialNumbers.indexOf(node2);
		matrix[n1][n2] = 1;
		matrix[n2][n1] = 1;
	}

	// ���ý�������ӷ���
	public void setConnect(Node node1, Node node2, int pow) {

		int n1 = serialNumbers.indexOf(node1);
		int n2 = serialNumbers.indexOf(node2);
		matrix[n1][n2] = pow;
		matrix[n2][n1] = pow;
	}

	// ���ͼ���������ӵ�
	public void Output() {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (matrix[i][j] > 0) {
					System.out.println(serialNumbers.get(i).getData() + "��" + serialNumbers.get(j).getData() + "������"
							+ "ȨΪ��" + matrix[i][j]);
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
