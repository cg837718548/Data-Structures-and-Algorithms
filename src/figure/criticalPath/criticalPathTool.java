package figure.criticalPath;

import java.util.List;
import java.util.Stack;

/**
 * 求关键路径类 etv 事件最早发生时间 ltv 事件最晚发生时间 ete 活动最早发生时间 lte 活动最晚发生时间
 * 
 * @author jeker-chen
 *
 */
public class criticalPathTool {

	// etv数组
	private int[] etv;
	private int[] ltv;
	int ete, lte;

	// 定义栈，用于存储入度为零的顶点
	Stack<TableYuansu> stack = new Stack<>();
	Stack<TableYuansu> stack1 = new Stack<>();
	TableYuansu tableYuansu;
	Node node;
	// 用于统计输出顶点的个数
	int count = 0, k = 0;

	/**
	 * 判断是否可拓扑排序
	 * 
	 * @param table
	 * @return
	 */
	public boolean testTopology(ChuTable chuTable) {

		// 定义栈，用于存储入度为零的顶点
		stack = new Stack<>();
		stack1 = new Stack<>();
		List<TableYuansu> yuansus = chuTable.getAllyuansu();
		// 记录邻接表中的元素数
		int MaxVex = yuansus.size();
		etv = new int[MaxVex];
		// 此步将入度为零的顶点入栈
		for (int i = 0; i < MaxVex; i++) {
			tableYuansu = yuansus.get(i);
			if (0 == tableYuansu.getRudu()) {
				stack.push(tableYuansu);
			}
		}

		// etv (活动最早发生时间) 初始化都为0
		for (int i = 0; i < MaxVex; i++) {
			etv[i] = 0;
		}
		while (stack.size() > 0) {
			tableYuansu = stack.pop();
			// stack出栈并保存拓扑排序的顺序
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

	// 求关键路径
	public void criticalPath(ChuTable chuTable) {
		List<TableYuansu> yuansus = chuTable.getAllyuansu();
		int maxSize = yuansus.size();
		ltv = new int[maxSize];
		// 调用改进后的拓扑排序求出etv和stack1的值
		testTopology(chuTable);
		// 初始化ltv汇点的时间
		for (int j = 0; j < maxSize; j++) {
			ltv[j] = etv[maxSize - 1];
		}
		// 从汇点倒过来逐个计算ltv
		while (stack1.size() > 0) {
			tableYuansu = stack1.pop();
			for (node = tableYuansu.getLinkList().first; node != null; node = node.next) {
				k = node.getData();
				if (ltv[k] - node.getPow() < ltv[yuansus.indexOf(tableYuansu)]) {
					ltv[yuansus.indexOf(tableYuansu)] = ltv[k] - node.getPow();
				}
			}
		}

		// 通过etv 和ltv 求ete 和lte
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
