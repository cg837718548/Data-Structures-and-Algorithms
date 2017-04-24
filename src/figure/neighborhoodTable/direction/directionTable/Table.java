package figure.neighborhoodTable.direction.directionTable;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodTable.direction.LinkList;
import figure.neighborhoodTable.direction.TableYuansu;

/**
 * �ڽӱ�
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

	// ���ýڵ���������
	public void setConnet(TableYuansu t1, TableYuansu t2) {
		ruTable.setConnet(t1, t2);
		chuTable.setConnet(t1, t2);
//		ChuTable chuTable = new ChuTable();
		// ��ȡԪ�ص��б����ڸ��б������ֵ
//		t1.getLinkList().insertHead(allyuansu.indexOf(t2));
//		t2.getLinkList().insertHead(allyuansu.indexOf(t1));
	}
	// ���ýڵ���������
		public void setConnet(TableYuansu t1, TableYuansu t2,int pow) {
			ruTable.setConnet(t1, t2,pow);
			chuTable.setConnet(t1, t2,pow);
//			ChuTable chuTable = new ChuTable();
			// ��ȡԪ�ص��б����ڸ��б������ֵ
//			t1.getLinkList().insertHead(allyuansu.indexOf(t2));
//			t2.getLinkList().insertHead(allyuansu.indexOf(t1));
		}

	// ��ӡ�����еĽ���������
	public void outputAll() {
		ruTable.outputAll();
		chuTable.outputAll();
//		for (TableYuansu yuansu : allyuansu) {
//			LinkList linkList = yuansu.getLinkList();
//			List<Node> nodes = linkList.showAlldata();
//			for (Node node : nodes) {
//				System.out.println(yuansu.getData() +"<<<<<<"+ allyuansu.get(node.getData()).getData() + "������ ");
//			}
//		}
	}
}
