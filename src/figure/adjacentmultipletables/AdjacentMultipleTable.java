package figure.adjacentmultipletables;
/**
 * 邻接多重表类
 * @author 83771
 *
 */

import java.util.LinkedList;
import java.util.List;

public class AdjacentMultipleTable {
	private List<Node> nodeList = new LinkedList<>();

	/**
	 * 初始化邻接多重表
	 * 
	 * @param lists
	 */
	public void initTable(List<Node> lists) {
		nodeList = lists;
	}

	/**
	 * 设置各个点的连接情况(node1和node2相邻)
	 */
	public void setConnect(Node node1, Node node2) {
		// 新建边对象
		SideNode sideNode = new SideNode();
		sideNode.setiVax(nodeList.indexOf(node1) + 1);
		sideNode.setjVax(nodeList.indexOf(node2) + 1);
		panduan(node1, sideNode);
		panduan(node2, sideNode);
	}

	/**
	 * 设置顶点的连接
	 */
	public void panduan(Node node, SideNode sideNode) {
		// 若node1之前还没有被连接过
		if (node.getSideNode() == null) {
			node.setSideNode(sideNode);
		} else {
			// 获取node1所连接的边
			SideNode s = node.getSideNode();
			// 获取node1在nodeList中的索引
			int index = nodeList.indexOf(node) + 1;
			SideNode jiezhi = new SideNode();
			// 边的左顶点或者右顶点等于node1的索引值时
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
	 * 输出所有结点的链接情况
	 */
	public void outAll() {
		// 遍历列表的所有元素，并输出各个元素的连接情况
		for (Node node : nodeList) {
			System.out.println(nodeList.indexOf(node)+1+"[--------------------");
			int index = nodeList.indexOf(node) + 1;
			SideNode s = node.getSideNode();
			SideNode jiezhi = s;
			while (s != null) {
				System.out.println(s.getiVax() + "和" + s.getjVax() + "相连接");
				s = (s.getiVax() == index ? s.getiLink() : s.getjLink());
//				jiezhi = s;
//				while (jiezhi != null) {
//					if (s.getiVax() == index) {
//						s = s.getiLink();
//						// jiezhi = (s.getiVax() == index ? s.getiLink() :
//						// s.getjLink());
//					} else {
//						System.out.println(s.getiVax() + "和" + s.getjVax() + "相连接");
//						s = s.getjLink();
//						// jiezhi = (s.getiVax() == index ? s.getiLink() :
//						// s.getjLink());
//					}
//				}
			}
		}
		System.out.println("遍历结束！");
	}

}
