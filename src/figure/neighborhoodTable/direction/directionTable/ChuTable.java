package figure.neighborhoodTable.direction.directionTable;

import java.util.ArrayList;
import java.util.List;

import figure.neighborhoodTable.direction.LinkList;
import figure.neighborhoodTable.direction.Node;
import figure.neighborhoodTable.direction.TableYuansu;

/**
 * �ڽӱ�����
 * 
 * @author 83771
 *
 */
public class ChuTable {

	private List<TableYuansu> allyuansu = new ArrayList<TableYuansu>();

	public void initTable(List<TableYuansu> list) {
		allyuansu = list;
		for (TableYuansu tableYuansu : allyuansu) {
			tableYuansu.setLinkList(new LinkList());
		}
	}

	// ���ýڵ���������
	public void setConnet(TableYuansu t1, TableYuansu t2) {

		// ��ȡԪ�ص��б����ڸ��б������ֵ
		// t1.getLinkList().insertHead(allyuansu.indexOf(t2));
		t1.getLinkList().insertHead(allyuansu.indexOf(t2));
	}

	// ���ýڵ���������
	public void setConnet(TableYuansu t1, TableYuansu t2, int pow) {

		// ��ȡԪ�ص��б����ڸ��б������ֵ
		// t1.getLinkList().insertHead(allyuansu.indexOf(t2));
		t1.getLinkList().insertHead(allyuansu.indexOf(t2),pow);
	}

	// ��ӡ�����еĽ���������
	public void outputAll() {
		for (TableYuansu yuansu : allyuansu) {
			LinkList linkList = yuansu.getLinkList();
			List<Node> nodes = linkList.showAlldata();
			for (Node node : nodes) {
				System.out.println(yuansu.getData() + ">>>>>>" + allyuansu.get(node.getData()).getData()+"ȨΪ��"+node.getPow());
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
