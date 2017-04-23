package figure.crossList;

import java.util.LinkedList;
import java.util.List;

/**
 * ʮ������ṹ
 * 
 * @author 83771
 *
 */
public class CrossList {
	List<VertexNode> vertexNodes = new LinkedList<>();

	/**
	 * ��ʼ��ʮ������
	 */
	public void initCrossList(List<VertexNode> lists) {
		vertexNodes = lists;
	}

	/**
	 * ���ø��������������
	 * 
	 * @param node1
	 *            ����β��
	 * @param node2
	 *            ����ͷ��
	 */
	public void setConnect(VertexNode node1, VertexNode node2) {
		SideNode sideNode = new SideNode();
		// �߽���β����Ϊnode1������ֵ
		sideNode.setTailVex(vertexNodes.indexOf(node1)+1);
		// �߽���ͷ����Ϊnode2������ֵ
		sideNode.setHeadVex(vertexNodes.indexOf(node2)+1);

		if (node1.getFirstOut() == null) {
			node1.setFirstOut(sideNode);
		} else {
			SideNode s = node1.getFirstOut();
			while (s.getTailLink() != null) {
				s = s.getTailLink();
			}
			s.setTailLink(sideNode);
		}

		if (node2.getFirstIn() == null) {
			node2.setFirstIn(sideNode);
		} else {
			SideNode s = node2.getFirstIn();
			while (s.getHeadLink() != null) {
				s = s.getHeadLink();
			}
			s.setHeadLink(sideNode);
		}
	}

	/**
	 * ���ʮ������ĸ��������������
	 */
	public void outputAll() {
		SideNode jiezhi ;
		//�������еĶ�����
		for (VertexNode node : vertexNodes) {
			jiezhi = node.getFirstOut();
			while (jiezhi!=null) {
				System.out.println(jiezhi.getTailVex()+"-->"+jiezhi.getHeadVex());
				jiezhi = jiezhi.getTailLink();
			}
			jiezhi = node.getFirstIn();
			while (jiezhi!=null) {
				System.out.println(jiezhi.getHeadVex()+"<--"+jiezhi.getTailVex());
				jiezhi = jiezhi.getHeadLink();
			}
		}
	}

}
