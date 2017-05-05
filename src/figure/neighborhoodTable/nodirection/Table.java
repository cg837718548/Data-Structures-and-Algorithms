package figure.neighborhoodTable.nodirection;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表
 * 
 * @author 83771
 *
 */
public class Table {

	private List<TableYuansu> allyuansu = new ArrayList<TableYuansu>();

	public void initTable(List<TableYuansu> list) {
		allyuansu = list;
		for (TableYuansu tableYuansu : allyuansu) {
			tableYuansu.setLinkList(new LinkList());
		}
	}

	// 设置节点的连接情况
	public void setConnet(TableYuansu t1, TableYuansu t2) {

		// 获取元素的列表，并在该列表里添加值
		t1.getLinkList().insertHead(allyuansu.indexOf(t2));
		t2.getLinkList().insertHead(allyuansu.indexOf(t1));
	}

	// 获取图中的结点总数
	public int gainQuantity() {
		return allyuansu.size();
	}

	// 打印出所有的结点连接情况
	public void outputAll() {
		for (TableYuansu yuansu : allyuansu) {
			LinkList linkList = yuansu.getLinkList();
			List<Node> nodes = linkList.showAlldata();
			for (Node node : nodes) {
				System.out.println(yuansu.getData() + "和" + allyuansu.get(node.getData()).getData() + "相连接 ");
			}
		}
	}

	public List<TableYuansu> getAllyuansu() {
		return allyuansu;
	}

	public void setAllyuansu(List<TableYuansu> allyuansu) {
		this.allyuansu = allyuansu;
	}

}
