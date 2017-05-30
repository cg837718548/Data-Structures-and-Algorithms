package figure.criticalPath;

import java.util.List;
import java.util.Stack;

/**
 * ��ؼ�·���� etv �¼����緢��ʱ�� ltv �¼�������ʱ�� ete ����緢��ʱ�� lte �������ʱ��
 * 
 * @author jeker-chen
 *
 */
public class criticalPathTool {

	// etv����
	private int[] etv;
	private int[] ltv;
	int ete, lte;

	// ����ջ�����ڴ洢���Ϊ��Ķ���
	Stack<TableYuansu> stack = new Stack<>();
	Stack<TableYuansu> stack1 = new Stack<>();
	TableYuansu tableYuansu;
	Node node;
	// ����ͳ���������ĸ���
	int count = 0, k = 0;

	/**
	 * �ж��Ƿ����������
	 * 
	 * @param table
	 * @return
	 */
	public boolean testTopology(ChuTable chuTable) {

		// ����ջ�����ڴ洢���Ϊ��Ķ���
		stack = new Stack<>();
		stack1 = new Stack<>();
		List<TableYuansu> yuansus = chuTable.getAllyuansu();
		// ��¼�ڽӱ��е�Ԫ����
		int MaxVex = yuansus.size();
		etv = new int[MaxVex];
		// �˲������Ϊ��Ķ�����ջ
		for (int i = 0; i < MaxVex; i++) {
			tableYuansu = yuansus.get(i);
			if (0 == tableYuansu.getRudu()) {
				stack.push(tableYuansu);
			}
		}

		// etv (����緢��ʱ��) ��ʼ����Ϊ0
		for (int i = 0; i < MaxVex; i++) {
			etv[i] = 0;
		}
		while (stack.size() > 0) {
			tableYuansu = stack.pop();
			// stack��ջ���������������˳��
			stack1.push(tableYuansu);
			count++;
			for (node = tableYuansu.getLinkList().first; node != null; node = node.next) {
				k = node.getData();
				tableYuansu = yuansus.get(k);
				tableYuansu.setRudu(tableYuansu.getRudu() - 1);
				if (tableYuansu.getRudu() == 0) {
					stack.push(yuansus.get(k));
				}
				if (etv[yuansus.indexOf(tableYuansu)] + node.getPow() > etv[k]) {
					etv[k] = etv[yuansus.indexOf(tableYuansu)] + node.getPow();
				}
			}
		}
		if (count < MaxVex) {
			return false;
		} else {
			return true;
		}
	}

	// ��ؼ�·��
	public void criticalPath(ChuTable chuTable) {
		List<TableYuansu> yuansus = chuTable.getAllyuansu();
		int maxSize = yuansus.size();
		ltv = new int[maxSize];
		// ���øĽ���������������etv��stack1��ֵ
		testTopology(chuTable);
		// ��ʼ��ltv����ʱ��
		for (int j = 0; j < maxSize; j++) {
			ltv[j] = etv[maxSize - 1];
		}
		// �ӻ�㵹�����������ltv
		while (stack1.size() > 0) {
			tableYuansu = stack1.pop();
			for (node = tableYuansu.getLinkList().first; node != null; node = node.next) {
				k = node.getData();
				if (ltv[k] - node.getPow() < ltv[yuansus.indexOf(tableYuansu)]) {
					ltv[yuansus.indexOf(tableYuansu)] = ltv[k] - node.getPow();
				}
			}
		}

		// ͨ��etv ��ltv ��ete ��lte
		for (int i = 0; i > maxSize; i++) {
			for (node = yuansus.get(i).getLinkList().first; node != null; node = node.next) {
				k = node.getData();
				ete = etv[i];
				lte = ltv[k] - node.getPow();
				if (ete == lte) {
					System.out.println(
							yuansus.get(i).getData() + "------" + yuansus.get(k).getData() + "[" + node.getPow() + "]");
				}
			}
		}
	}

}
