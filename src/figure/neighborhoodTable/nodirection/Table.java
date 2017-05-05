package figure.neighborhoodTable.nodirection;

import java.util.ArrayList;
import java.util.List;

/**
 * �ڽӱ�
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

	// ���ýڵ���������
	public void setConnet(TableYuansu t1, TableYuansu t2) {

		// ��ȡԪ�ص��б����ڸ��б������ֵ
		t1.getLinkList().insertHead(allyuansu.indexOf(t2));
		t2.getLinkList().insertHead(allyuansu.indexOf(t1));
	}

	// ��ȡͼ�еĽ������
	public int gainQuantity() {
		return allyuansu.size();
	}

	// ��ӡ�����еĽ���������
	public void outputAll() {
		for (TableYuansu yuansu : allyuansu) {
			LinkList linkList = yuansu.getLinkList();
			List<Node> nodes = linkList.showAlldata();
			for (Node node : nodes) {
				System.out.println(yuansu.getData() + "��" + allyuansu.get(node.getData()).getData() + "������ ");
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
