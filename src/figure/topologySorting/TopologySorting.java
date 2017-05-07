package figure.topologySorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ͼ����������
 * 
 * @author 83771
 *
 */
public class TopologySorting {

	/**
	 * ���������㷨
	 */
	public void topologySorting(ChuTable chuTable) {
		// ����ջ�����ڴ洢���Ϊ��Ķ���
		Stack<TableYuansu> stack = new Stack<>();
		List<TableYuansu> yuansus = chuTable.getAllyuansu();
		// ����ͳ���������ĸ���
		int count = 0, k = 0;
		Node node;
		TableYuansu tableYuansu;
		// ��¼�ڽӱ��е�Ԫ����
		int MaxVex = yuansus.size();

		// �˲������Ϊ��Ķ�����ջ
		for (int i = 0; i < MaxVex; i++) {
			tableYuansu = yuansus.get(i);
			if (0 == tableYuansu.getRudu()) {
				stack.push(tableYuansu);
			}
		}

		while (stack.size() > 0) {
			tableYuansu = stack.pop();
			System.out.print(tableYuansu.getData() + "--->");
			count++;

			for (node = tableYuansu.getLinkList().first; node != null; node = node.next) {
				k = node.getData();
				tableYuansu = yuansus.get(k);
				tableYuansu.setRudu(tableYuansu.getRudu() - 1);
				if (tableYuansu.getRudu() == 0) {
					stack.push(yuansus.get(k));
				}
			}
		}
		System.out.println();
		if (count < MaxVex) {
			System.out.println(count + "������������");
		} else {
			System.out.println(count + "������������");
		}

	}

	public static void main(String[] args) {
		TableYuansu yuansu1 = new TableYuansu("1111");
		TableYuansu yuansu2 = new TableYuansu("1112");
		TableYuansu yuansu3 = new TableYuansu("1113");
		TableYuansu yuansu4 = new TableYuansu("1114");
		TableYuansu yuansu5 = new TableYuansu("1115");
		List<TableYuansu> lists = new LinkedList<>();
		lists.add(yuansu1);
		lists.add(yuansu2);
		lists.add(yuansu3);
		lists.add(yuansu4);
		lists.add(yuansu5);
		ChuTable table = new ChuTable();
		table.initTable(lists);

		table.setConnet(yuansu1, yuansu2);
//		table.setConnet(yuansu1, yuansu3);
//		table.setConnet(yuansu1, yuansu4);
		table.setConnet(yuansu2, yuansu4);
		table.setConnet(yuansu3, yuansu4);
		table.setConnet(yuansu3, yuansu5);
//		table.setConnet(yuansu4, yuansu5);
		table.setConnet(yuansu4, yuansu1);
		

		TopologySorting sorting = new TopologySorting();
		sorting.topologySorting(table);

	}

}
