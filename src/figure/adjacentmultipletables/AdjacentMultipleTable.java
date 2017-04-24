package figure.adjacentmultipletables;
/**
 * �ڽӶ��ر���
 * @author 83771
 *
 */

import java.util.LinkedList;
import java.util.List;

public class AdjacentMultipleTable {
	private List<Node> nodeList = new LinkedList<>();

	/**
	 * ��ʼ���ڽӶ��ر�
	 * 
	 * @param lists
	 */
	public void initTable(List<Node> lists) {
		nodeList = lists;
	}

	/**
	 * ���ø�������������(node1��node2����)
	 */
	public void setConnect(Node node1, Node node2) {
		// �½��߶���
		SideNode sideNode = new SideNode();
		sideNode.setiVax(nodeList.indexOf(node1) + 1);
		sideNode.setjVax(nodeList.indexOf(node2) + 1);
		panduan(node1, sideNode);
		panduan(node2, sideNode);
	}

	/**
	 * ���ö��������
	 */
	public void panduan(Node node, SideNode sideNode) {
		// ��node1֮ǰ��û�б����ӹ�
		if (node.getSideNode() == null) {
			node.setSideNode(sideNode);
		} else {
			// ��ȡnode1�����ӵı�
			SideNode s = node.getSideNode();
			// ��ȡnode1��nodeList�е�����
			int index = nodeList.indexOf(node) + 1;
			SideNode jiezhi = new SideNode();
			// �ߵ��󶥵�����Ҷ������node1������ֵʱ
			while (s != null) {
				jiezhi = s;
				s = (s.getiVax() == index ? s.getiLink() : s.getjLink());
				// if (s.getiVax() == index) {
				// s = s.getiLink();
				// } else {
				// s = s.getjLink();
				// jiezhi = (s.getiVax() == index ? s.getiLink() :
				// s.getjLink());
				// }
			}
			if (jiezhi.getiVax() == index) {
				jiezhi.setiLink(sideNode);
			} else {
				jiezhi.setjLink(sideNode);
			}
		}
	}

	/**
	 * ������н����������
	 */
	public void outAll() {
		// �����б������Ԫ�أ����������Ԫ�ص��������
		for (Node node : nodeList) {
			System.out.println(nodeList.indexOf(node)+1+"[--------------------");
			int index = nodeList.indexOf(node) + 1;
			SideNode s = node.getSideNode();
			SideNode jiezhi = s;
			while (s != null) {
				System.out.println(s.getiVax() + "��" + s.getjVax() + "������");
				s = (s.getiVax() == index ? s.getiLink() : s.getjLink());
//				jiezhi = s;
//				while (jiezhi != null) {
//					if (s.getiVax() == index) {
//						s = s.getiLink();
//						// jiezhi = (s.getiVax() == index ? s.getiLink() :
//						// s.getjLink());
//					} else {
//						System.out.println(s.getiVax() + "��" + s.getjVax() + "������");
//						s = s.getjLink();
//						// jiezhi = (s.getiVax() == index ? s.getiLink() :
//						// s.getjLink());
//					}
//				}
			}
		}
		System.out.println("����������");
	}

}
