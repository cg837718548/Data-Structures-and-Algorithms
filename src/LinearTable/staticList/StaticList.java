package LinearTable.staticList;

/**
 * ��̬����
 * 
 * @author 83771
 *
 */
public class StaticList {

	// ���������
	private int maxsize;
	// ����
	private Node staticLinkList[];

	public StaticList(int maxsize) {
		super();
		this.maxsize = maxsize;
		this.staticLinkList = new Node[maxsize];
	}

	/*
	 * ��ÿ��з����±�
	 */
	public int gainSpaceSub() {
		// �����һ��Ԫ�ص�curָ���һ�����з���
		int i = staticLinkList[0].getCursor();
		// ���������������0��Ϊ0��˵����������
		if (i != 0) {
			// ��������һ��������Ϊ����
			staticLinkList[0].setCursor(staticLinkList[i].getCursor());
		}
		return i;
	}

	/*
	 * ��̬�����ʼ��
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
	 * �ھ�̬�����i��Ԫ��֮ǰ��������
	 */
	public void insertData(int i, String data) {
		int j, k;
		// ��������һ��Ԫ��
		k = maxsize - 1;
		// ��i������Χ
		if (i < 1 || i > getLength() + 1) {
			return;
		}
		// ��ÿ��з����ĵ�һ���±�
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
	 * ��̬�����ɾ����i��Ԫ��
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
		// ���±�Ϊj�Ŀ��нڵ���յ���������
		freeData(j);

	}

	// �����нڵ���յ�����������
	public void freeData(int i) {
		staticLinkList[i].setData(null);
		staticLinkList[i].setCursor(staticLinkList[0].getCursor());
		staticLinkList[0].setCursor(i);
	}

	/*
	 * ���ؾ�̬�����еĸ���
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
	 * �����̬�����е�����
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
	 * ��ȡ��̬������м�ֵ
	 */
	public void getMedium() {
		int  k = 0;
		// ��һ��Ԫ�ص��±�
		int j = staticLinkList[maxsize - 1].getCursor();
		int m = staticLinkList[maxsize - 1].getCursor();
		// ����һ��Ԫ�ص��α겻Ϊ0
		while (staticLinkList[j].getCursor() != 0) {
			// ��ȡ���Ԫ�ص���һ���α�
			k = staticLinkList[j].getCursor();
			// ����һ���α����һ���α겻Ϊ0
			if (staticLinkList[k].getCursor() != 0) {
				// ���Ƹ�j
				j = staticLinkList[k].getCursor();
				m = staticLinkList[m].getCursor();
			} else {
				j=k;
			}
		}
		System.out.println(staticLinkList[m].getData());
	}

}
