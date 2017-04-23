package huffmanCode;

import huffmanCode.Util.StringConvertChar;

/**
 * 哈夫曼树
 * 
 * @author 83771
 *
 */
public class huffmanTree {
	//最后返回的节点
	private  Node rootNode;

	/*
	 * 创建树
	 */
	public Node buildTree(String str) {
		// 统计字符串中个字符出现的次数
		int[] frequency = appearNum(str);
		// 将字符串按照元素出现频率排序后的字符数组
		char[] chars = insertSort(str, frequency);
		// 构建一个队列
		Queue queue = buildQueue(chars);
		// 根据已有的树构建一个赫夫曼树
		Node treeNode = achieveTree(queue, null, null, null, frequency);
		return treeNode;
	}

	/*
	 * 记录字符串中个各个字符出现的次数
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
	 * 根据出现频率的大小构建一个队列
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
	 * 将字符串中的字符按照出现频率 从低到高进行排序
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
			// 假如temp比前面的值小，则将前面的值后移
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
	 * 根据已经有的队列来构建树(递归)
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
		// 设置该节点的值为两个孩子节点内容出现频率
		node.setData((char) (z + y));
		System.out.println((z + y) + "     " + "左：" + z + "右：" + y);
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
