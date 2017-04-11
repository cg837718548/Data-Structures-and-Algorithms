package LinearTable.staticList;

/**
 * 静态链表
 * 
 * @author 83771
 *
 */
public class StaticList {

	// 链表的容量
	private int maxsize;
	// 链表
	private Node staticLinkList[];

	public StaticList(int maxsize) {
		super();
		this.maxsize = maxsize;
		this.staticLinkList = new Node[maxsize];
	}

	/*
	 * 获得空闲分量下标
	 */
	public int gainSpaceSub() {
		// 数组第一个元素的cur指向第一个空闲分量
		int i = staticLinkList[0].getCursor();
		// 若这个分量不等于0，为0则说明容量满了
		if (i != 0) {
			// 把他的下一个分量作为备用
			staticLinkList[0].setCursor(staticLinkList[i].getCursor());
		}
		return i;
	}

	/*
	 * 静态链表初始化
	 */
	public void initList() {
		for (int i = 0; i <= maxsize - 1; i++) {
			staticLinkList[i] = new Node();
		}
		for (int i = 0; i < maxsize - 1; i++) {
			staticLinkList[i].setCursor(i + 1);
		}
		staticLinkList[maxsize - 1].setCursor(0);
	}

	/*
	 * 在静态链表第i个元素之前插入数据
	 */
	public void insertData(int i, String data) {
		int j, k;
		// 数组的最后一个元素
		k = maxsize - 1;
		// 若i超出范围
		if (i < 1 || i > getLength() + 1) {
			return;
		}
		// 获得空闲分量的第一个下标
		j = gainSpaceSub();
		if (j != 0) {
			staticLinkList[j].setData(data);
			for (int L = 1; L <= i - 1; L++) {
				k = staticLinkList[k].getCursor();
			}
			staticLinkList[j].setCursor(staticLinkList[k].getCursor());
			staticLinkList[k].setCursor(j);
		}
	}

	/*
	 * 静态链表的删除第i个元素
	 */
	public void deleteData(int i) {
		int j, k;
		k = maxsize - 1;
		if (i < 1 || i > maxsize - 1) {
			return;
		}
		for (j = 1; j <= i - 1; j++) {
			k = staticLinkList[k].getCursor();
			if (k == 0) {
				return;
			}
		}
		j = staticLinkList[k].getCursor();
		staticLinkList[k].setCursor(staticLinkList[j].getCursor());
		// 将下标为j的空闲节点回收到备用链表
		freeData(j);

	}

	// 将空闲节点回收到备用链表中
	public void freeData(int i) {
		staticLinkList[i].setData(null);
		staticLinkList[i].setCursor(staticLinkList[0].getCursor());
		staticLinkList[0].setCursor(i);
	}

	/*
	 * 返回静态链表中的个数
	 */
	public int getLength() {
		int j = 0;
		int i = staticLinkList[maxsize - 1].getCursor();
		while (i != 0) {
			i = staticLinkList[i].getCursor();
			j++;
		}
		return j;

	}

	public String getData(int i) {
		int k = staticLinkList[maxsize - 1].getCursor();
		for (int j = 1; j < i; j++) {
			k = staticLinkList[k].getCursor();
			if (k == 0) {
				return null;
			}
		}
		return staticLinkList[k].getData();
	}

	/*
	 * 输出静态链表中的内容
	 */
	public void getAllData() {
		int j = 0;
		int i = staticLinkList[maxsize - 1].getCursor();
		while (i != 0) {
			System.out.println(staticLinkList[i].getData());
			i = staticLinkList[i].getCursor();
		}
	}

	/*
	 * 获取静态链表的中间值
	 */
	public void getMedium() {
		int  k = 0;
		// 第一个元素的下标
		int j = staticLinkList[maxsize - 1].getCursor();
		int m = staticLinkList[maxsize - 1].getCursor();
		// 若后一个元素的游标不为0
		while (staticLinkList[j].getCursor() != 0) {
			// 获取这个元素的下一个游标
			k = staticLinkList[j].getCursor();
			// 若下一个游标的下一个游标不为0
			if (staticLinkList[k].getCursor() != 0) {
				// 复制给j
				j = staticLinkList[k].getCursor();
				m = staticLinkList[m].getCursor();
			} else {
				j=k;
			}
		}
		System.out.println(staticLinkList[m].getData());
	}

}
