package figure.breadthTraversal;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import figure.neighborhoodTable.nodirection.LinkList;
import figure.neighborhoodTable.nodirection.Node;
import figure.neighborhoodTable.nodirection.Table;
import figure.neighborhoodTable.nodirection.TableYuansu;

/**
 * 图的广度遍历（邻接表）
 * 
 * @author 83771
 *
 */
public class breadthTraversal2 {

	/**
	 * 图的广度遍历方法
	 */
	public static void BTSTraveres(Table table) {
		int i;
		LinkList linkList = new LinkList();
		int quantity = table.gainQuantity();
		boolean[] flags = new boolean[quantity];
		Queue<TableYuansu> queue = new ArrayDeque<>();
		for (i = 0; i < quantity; i++) {
			flags[i] = false;
		}

		if (!flags[0]) {
			TableYuansu tableYuansu = table.getAllyuansu().get(0);
			System.out.println(tableYuansu.getData());
			flags[0] = true;
			queue.add(tableYuansu);

			while (!queue.isEmpty()) {
				TableYuansu polldata = queue.poll();
				linkList = polldata.getLinkList();
				List<Node> indexList = linkList.showAlldata();
				for (i = 0; i < indexList.size(); i++) {
					int index = indexList.get(i).getData();
					if (!flags[index]) {
						tableYuansu = table.getAllyuansu().get(index);
						System.out.println(tableYuansu.getData());
						System.out.println("索引值" + index);
						flags[index] = true;
						queue.add(tableYuansu);
					}

				}
			}
		}
	}

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
		Table table = new Table();
		table.initTable(lists);

		table.setConnet(yuansu1, yuansu2);
		table.setConnet(yuansu1, yuansu3);
		table.setConnet(yuansu2, yuansu4);
		table.setConnet(yuansu2, yuansu6);
		table.setConnet(yuansu3, yuansu5);
		table.setConnet(yuansu3, yuansu6);
		table.setConnet(yuansu4, yuansu5);

		BTSTraveres(table);
	}
}
