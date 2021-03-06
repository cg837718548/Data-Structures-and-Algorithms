package figure.neighborhoodTable.direction.directionTable;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodTable.direction.LinkList;
import figure.neighborhoodTable.direction.Node;
import figure.neighborhoodTable.direction.TableYuansu;

/**
 * 邻接表(入表)
 * 
 * @author 83771
 *
 */
public class RuTable {

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
		t2.getLinkList().insertHead(allyuansu.indexOf(t1));
		// t2.getLinkList().insertHead(allyuansu.indexOf(t1));
	}

	// 设置节点的连接情况
	public void setConnet(TableYuansu t1, TableYuansu t2, int pow) {

		// 获取元素的列表，并在该列表里添加值
		t2.getLinkList().insertHead(allyuansu.indexOf(t1),pow);
		// t2.getLinkList().insertHead(allyuansu.indexOf(t1));
	}

	// 打印出所有的结点连接情况
	public void outputAll() {
		for (TableYuansu yuansu : allyuansu) {
			LinkList linkList = yuansu.getLinkList();
			List<Node> nodes = linkList.showAlldata();
			for (Node node : nodes) {
				System.out.println(yuansu.getData() + "<<<<<<" + allyuansu.get(node.getData()).getData()+"权为："+node.getPow());
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
