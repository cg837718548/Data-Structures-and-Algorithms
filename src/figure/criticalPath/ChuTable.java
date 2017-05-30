package figure.criticalPath;

import java.util.ArrayList;
import java.util.List;

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
		t1.getLinkList().insertHead(allyuansu.indexOf(t2));
		t2.setRudu(t2.getRudu() + 1);
	}

	// ���ýڵ���������
	public void setConnet(TableYuansu t1, TableYuansu t2, int pow) {

		// ��ȡԪ�ص��б����ڸ��б������ֵ
		// t1.getLinkList().insertHead(allyuansu.indexOf(t2));
		t1.getLinkList().insertHead(allyuansu.indexOf(t2), pow);
	}

	// ��ӡ�����еĽ���������
	public void outputAll() {
		for (TableYuansu yuansu : allyuansu) {
			System.out.println(yuansu.getData()+"----"+yuansu.getRudu());
			LinkList linkList = yuansu.getLinkList();
			List<Node> nodes = linkList.showAlldata();
			for (Node node : nodes) {
				System.out.println(yuansu.getData() + ">>>>>>" + allyuansu.get(node.getData()).getData());
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
