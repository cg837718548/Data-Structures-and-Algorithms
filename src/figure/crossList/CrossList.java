package figure.crossList;

import java.util.LinkedList;
import java.util.List;

/**
 * 十字链表结构
 * 
 * @author 83771
 *
 */
public class CrossList {
	List<VertexNode> vertexNodes = new LinkedList<>();

	/**
	 * 初始化十字链表
	 */
	public void initCrossList(List<VertexNode> lists) {
		vertexNodes = lists;
	}

	/**
	 * 设置各个结点的连接情况
	 * 
	 * @param node1
	 *            弧的尾部
	 * @param node2
	 *            弧的头部
	 */
	public void setConnect(VertexNode node1, VertexNode node2) {
		SideNode sideNode = new SideNode();
		// 边结点的尾部设为node1的索引值
		sideNode.setTailVex(vertexNodes.indexOf(node1)+1);
		// 边结点的头部设为node2的索引值
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
	 * 输出十字链表的各个结点的连接情况
	 */
	public void outputAll() {
		SideNode jiezhi ;
		//遍历所有的顶点结点
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
