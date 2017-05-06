package figure.shortestPath;

import java.util.LinkedList;
import java.util.List;

import figure.neighborhoodMatrix.nodirection.NeighborhoodMatrix;
import figure.neighborhoodMatrix.nodirection.Node;

/**
 * ͼ�����·����Dijkstrah�㷨��
 * 
 * @author 83771
 *
 */
public class Dijkstrah {
	private int[] pathArc;
	private int[] pathSum;

	/**
	 * ���·�����ɷ���
	 * 
	 * @param matrix
	 *            ͼ���ڽӾ���
	 * @param v0
	 *            Դ��
	 * @param pathArc
	 *            ���ڴ������·�����±�
	 * @param pathSum
	 *            �洢�������·����Ȩֵ��
	 */
	public void dijkstrah(NeighborhoodMatrix matrix, int v0, int[] pathArc, int[] pathSum) {

		int v, min, w, k;
		int MaxVex = matrix.gainQuantity();
		pathArc = new int[MaxVex];
		pathSum = new int[MaxVex];
		// sign[w]=1��ʾ����v0��vw���е����·��
		int[] sign = new int[MaxVex];

		// ��ʼ������
		for (v = 0; v < MaxVex; v++) {
			sign[v] = 0;
			pathSum[v] = matrix.getMatrix()[v0][v];
			pathArc[v] = 0;
		}

		pathSum[v0] = 0;
		sign[v0] = 1;
		//test
		outProcess(pathArc, pathSum,sign);

		// ��ʼ��ѭ����ÿ�����v0��ĳ���������̾���
		for (v = 1; v < MaxVex; v++) {
			min = Integer.MAX_VALUE;
			k = 0;
			for (w = 0; w < MaxVex; w++) {
				if (sign[w] == 0 && pathSum[w] < min) {
					k = w;
					min = pathSum[w];
				}
			}
			sign[k] = 1; // ��Ŀǰ�ҵ��ö�����1
			//test
			outProcess(pathArc, pathSum,sign);

			// ������ǰ���·���;���
			for (w = 0; w < MaxVex; w++) {
				// ������v�����·������������·�̵û������
				if (sign[w] == 0 && (min + matrix.getMatrix()[k][w]) < pathSum[w]) {
					pathSum[w] = min + matrix.getMatrix()[k][w]; // �޸ĵ�ǰ·������
					pathArc[w] = k; // ���ǰ������
				}
			}
			//test
			outProcess(pathArc, pathSum,sign);
		}
		this.pathArc = pathArc;
		this.pathSum = pathSum;
	}
	
	public  void outProcess(int[] arc,int[] sum,int[] sign ){
		for(int i = 0;i<sum.length;i++){
			if(sum[i] ==37201){
				System.out.print("   "+0);
			}else{
				System.out.print("   "+sum[i]);
			}
		}
		System.out.println();
		for(int i = 0;i<arc.length;i++){
			System.out.print("   "+arc[i]);
		}
		System.out.println();
		for(int i = 0;i<sign.length;i++){
			System.out.print("   "+sign[i]);
		}
		System.out.println();
		System.out.println("============================");
	}

	public static void main(String[] args) {
//		System.out.println(2+Integer.MAX_VALUE);
		NeighborhoodMatrix matrix = new NeighborhoodMatrix();
		List<Node> nodes = new LinkedList<>();
		Node node0 = new Node("110");
		Node node1 = new Node("111");
		Node node2 = new Node("112");
		Node node3 = new Node("113");
		Node node4 = new Node("114");
		Node node5 = new Node("115");
		Node node6 = new Node("116");
		Node node7 = new Node("117");
		Node node8 = new Node("118");
		nodes.add(node0);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);
		nodes.add(node7);
		nodes.add(node8);
		matrix.initMatrix(nodes);
		matrix.setConnect(node0, node1, 1);
		matrix.setConnect(node0, node2, 5);
		matrix.setConnect(node1, node2, 3);
		matrix.setConnect(node1, node3, 7);
		matrix.setConnect(node1, node4, 5);
		matrix.setConnect(node2, node4, 1);
		matrix.setConnect(node2, node5, 7);
		matrix.setConnect(node3, node4, 2);
		matrix.setConnect(node3, node6, 3);
		matrix.setConnect(node4, node5, 3);
		matrix.setConnect(node4, node6, 6);
		matrix.setConnect(node4, node7, 9);
		matrix.setConnect(node5, node7, 5);
		matrix.setConnect(node6, node7, 2);
		matrix.setConnect(node6, node8, 7);
		matrix.setConnect(node7, node8, 4);
		
		
		Dijkstrah dijkstrah = new Dijkstrah();
		
		dijkstrah.dijkstrah(matrix, 0, dijkstrah.pathArc,dijkstrah.pathSum);
		for(int i = 0;i<matrix.gainQuantity();i++){
			System.out.print("   "+dijkstrah.pathArc[i]);
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		for(int i = 0;i<matrix.gainQuantity();i++){
			System.out.print("   "+dijkstrah.pathSum[i]);
		}

	}

}
