package huffmanCode;

import huffmanCode.Util.StringConvertChar;

/**
 * ��������
 * 
 * @author 83771
 *
 */
public class huffmanTree {
	//��󷵻صĽڵ�
	private  Node rootNode;

	/*
	 * ������
	 */
	public Node buildTree(String str) {
		// ͳ���ַ����и��ַ����ֵĴ���
		int[] frequency = appearNum(str);
		// ���ַ�������Ԫ�س���Ƶ���������ַ�����
		char[] chars = insertSort(str, frequency);
		// ����һ������
		Queue queue = buildQueue(chars);
		// �������е�������һ���շ�����
		Node treeNode = achieveTree(queue, null, null, null, frequency);
		return treeNode;
	}

	/*
	 * ��¼�ַ����и������ַ����ֵĴ���
	 */
	public int[] appearNum(String str) {
		int[] ints = new int[256];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = 0;
		}
		for (int i = 0; i < str.length(); i++) {
			ints[str.charAt(i)]++;
		}
		return ints;
	}

	/*
	 * ���ݳ���Ƶ�ʵĴ�С����һ������
	 * 
	 */
	public Queue buildQueue(char[] chars) {
		Queue queue = new Queue();
		queue.initQueue(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			queue.insertQueue(chars[i]);
		}
		return queue;
	}

	/**
	 * ���ַ����е��ַ����ճ���Ƶ�� �ӵ͵��߽�������
	 * 
	 * @param numbers
	 */
	public char[] insertSort(String str, int[] ints) {
		char[] chars = StringConvertChar.convertChar(str);
		int size = chars.length;
		char temp;
		int tempcishu = 0;
		int j = 0;

		for (int i = 0; i < size; i++) {
			temp = chars[i];
			tempcishu = ints[chars[i]];
			// ����temp��ǰ���ֵС����ǰ���ֵ����
			for (j = i; j > 0 && tempcishu < ints[chars[j - 1]]; j--) {
				chars[j] = chars[j - 1];
			}
			chars[j] = temp;
		}
		return chars;
		// for (int k = 0; k < chars.length; k++) {
		// System.out.println(chars[k]);
		// }
		// return null;
	}

	/*
	 * �����Ѿ��еĶ�����������(�ݹ�)
	 */
	public Node achieveTree(Queue queue, Node node, Node L_node, Node R_node, int[] ints) {
		if (queue.getRear() == null) {
			System.out.println((int)node.getData()+"----");
			rootNode = node;
			return null;
		}
		if (L_node == null && R_node == null) {
			L_node = queue.outQueue();
			R_node = queue.outQueue();
		} else {
			Node oNode = queue.outQueue();
			if (ints[oNode.getData()] <= (int) node.getData()) {
				L_node = oNode;
				R_node = node;
			} else {
				L_node = node;
				R_node = oNode;
			}
		}
		int z = 0, y = 0;
		if (ints[L_node.getData()] > 0) {
			z = ints[L_node.getData()];
		} else {
			z = (int) node.getData();
		}
		if (ints[R_node.getData()] > 0) {
			y = ints[R_node.getData()];
		} else {
			y = (int) node.getData();
		}
		node = new Node();
		node.setLeft_child(L_node);
		node.setRight_child(R_node);
		// ���øýڵ��ֵΪ�������ӽڵ����ݳ���Ƶ��
		node.setData((char) (z + y));
		System.out.println((z + y) + "     " + "��" + z + "�ң�" + y);
		achieveTree(queue, node, L_node, R_node, ints);
		return rootNode;
	}

	public static void main(String[] args) {
		huffmanTree tree = new huffmanTree();
		String str = "chhhhheenganggggnnnnn";
		Node node = tree.buildTree(str);
		System.out.println((int)node.getData());
//		int[] ints = tree.appearNum(str);
//		char[] chars = tree.insertSort(str, ints);
//		for (int i = 0; i < chars.length; i++) {
//			System.out.print(chars[i] + "--");
//		}
//		System.out.println();
//		Queue queue = tree.buildQueue(chars);
//		tree.achieveTree(queue, null, null, null, ints);
//		// queue.outAll();
	}
}
