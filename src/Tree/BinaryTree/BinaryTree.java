package Tree.BinaryTree;
/**
 * ��������Ľ�����������ǰ�������
 * @author 83771
 *
 */

import java.util.Scanner;

public class BinaryTree {
	/*
	 * ����һ��������
	 */
	public static void createTree(Node node) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ���ӵĽڵ�ֵ");
		String data = scanner.nextLine();
		if (data.equals("")) {
			System.out.println("��");
			node = null;
		} else {
			node.setData(data);
			node.setL_node(new Node());
			createTree(node.getL_node());
			node.setR_node(new Node());
			createTree(node.getR_node());
		}
	}

	/*
	 * ǫ������������Ľڵ�
	 */
	public static void preorderTraversal(Node T, int level) {
		if (T != null) {
			System.out.println(T.getData() + "�ڵ�" + level + "��");
			preorderTraversal(T.getL_node(), level + 1);
			preorderTraversal(T.getR_node(), level + 1);
		}
	}

//	public static void set(Node node) {
//		node = new Node("hahahaha");
//	}

	public static void main(String[] args) {
		Node node = new Node();
		createTree(node);
		preorderTraversal(node, 1);
	}
}
