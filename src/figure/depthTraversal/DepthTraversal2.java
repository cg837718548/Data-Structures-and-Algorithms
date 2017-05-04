package figure.depthTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import figure.neighborhoodTable.direction.LinkList;
import figure.neighborhoodTable.direction.Node;
import figure.neighborhoodTable.direction.directionTable.ChuTable;
import figure.neighborhoodTable.direction.directionTable.RuTable;
import figure.neighborhoodTable.direction.TableYuansu;

/**
 * 图的深度遍历(邻接表版)
 * 
 * @author 83771
 *
 */
public class DepthTraversal2 {

	public static List<Integer> exitList = new ArrayList<>();

	public static void main(String[] args) {
		TableYuansu yuansu1 = new TableYuansu("1111");
		TableYuansu yuansu2 = new TableYuansu("1112");
		TableYuansu yuansu3 = new TableYuansu("1113");
		TableYuansu yuansu4 = new TableYuansu("1114");
		TableYuansu yuansu5 = new TableYuansu("1115");
		TableYuansu yuansu6 = new TableYuansu("1116");
		List<TableYuansu> lists = new LinkedList<>();
		lists.add(yuansu1);
		lists.add(yuansu2);
		lists.add(yuansu3);
		lists.add(yuansu4);
		lists.add(yuansu5);
		lists.add(yuansu6);
		ChuTable table = new ChuTable();
		table.initTable(lists);

		table.setConnet(yuansu1, yuansu6);
		table.setConnet(yuansu6, yuansu3);
		table.setConnet(yuansu3, yuansu2);
		table.setConnet(yuansu2, yuansu5);
		table.setConnet(yuansu5, yuansu4);
		table.setConnet(yuansu4, yuansu1);
//		table.setConnet(yuansu5, yuansu3);

		table.outputAll();
		traversal(table.getAllyuansu(), 0);
	}

	/**
	 * 遍历方法
	 * 
	 * @param qipan
	 * @param i
	 * @param exitNodes
	 */
	public static void traversal(List<TableYuansu> qipan, int i) {
		// 获得第i个元素
		TableYuansu yuansu = qipan.get(i);
		// 获得第i个元素的链表
		LinkList linkList = yuansu.getLinkList();
		// 如果链表不为空
		if (linkList != null) {
			// 获取该链表的第一个结点
			Node current = linkList.first;
			// 在结点不为空的情况下
			while (current != null) {
				// 如果结点已经存在，则跳过该结点，条到下一个节点
				while (current != null && exitList.contains(current.getData())) {
					current = current.next;
				}
				if (current != null) {
					System.out.println(qipan.get(current.getData()).getData());
					exitList.add(current.getData());
					traversal(qipan, current.getData());
				}
			}
		}

	}
}
