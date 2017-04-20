package Tree.BinaryTree;
/**
 * 二叉树类的建立及遍历（前序遍历）
 * @author 83771
 *
 */

import java.util.Scanner;

public class BinaryTree {
	/*
	 * 创建一个二叉树
	 */
	public static void createTree(Node node) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要增加的节点值");
		String data = scanner.nextLine();
		if (data.equals("")) {
			System.out.println("空");
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
	 * 谦虚遍历二叉树的节点
	 */
	public static void preorderTraversal(Node T, int level) {
		if (T != null) {
			System.out.println(T.getData() + "在第" + level + "层");
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
