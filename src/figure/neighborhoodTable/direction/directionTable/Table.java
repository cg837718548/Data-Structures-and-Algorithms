package figure.neighborhoodTable.direction.directionTable;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodTable.direction.LinkList;
import figure.neighborhoodTable.direction.TableYuansu;

/**
 * 邻接表
 * 
 * @author 83771
 *
 */
public class Table {

	private List<TableYuansu> allyuansu = new ArrayList<TableYuansu>();
	RuTable ruTable = new RuTable();
	ChuTable chuTable = new ChuTable();

	public void initTable(List<TableYuansu> list) {
		ruTable.initTable(list);
		chuTable.initTable(list);
//		allyuansu = list;
//		for (TableYuansu tableYuansu : allyuansu) {
//			tableYuansu.setLinkList(new LinkList());
//		}
	}

	// 设置节点的连接情况
	public void setConnet(TableYuansu t1, TableYuansu t2) {
		ruTable.setConnet(t1, t2);
		chuTable.setConnet(t1, t2);
//		ChuTable chuTable = new ChuTable();
		// 获取元素的列表，并在该列表里添加值
//		t1.getLinkList().insertHead(allyuansu.indexOf(t2));
//		t2.getLinkList().insertHead(allyuansu.indexOf(t1));
	}
	// 设置节点的连接情况
		public void setConnet(TableYuansu t1, TableYuansu t2,int pow) {
			ruTable.setConnet(t1, t2,pow);
			chuTable.setConnet(t1, t2,pow);
//			ChuTable chuTable = new ChuTable();
			// 获取元素的列表，并在该列表里添加值
//			t1.getLinkList().insertHead(allyuansu.indexOf(t2));
//			t2.getLinkList().insertHead(allyuansu.indexOf(t1));
		}

	// 打印出所有的结点连接情况
	public void outputAll() {
		ruTable.outputAll();
		chuTable.outputAll();
//		for (TableYuansu yuansu : allyuansu) {
//			LinkList linkList = yuansu.getLinkList();
//			List<Node> nodes = linkList.showAlldata();
//			for (Node node : nodes) {
//				System.out.println(yuansu.getData() +"<<<<<<"+ allyuansu.get(node.getData()).getData() + "相连接 ");
//			}
//		}
	}
}
