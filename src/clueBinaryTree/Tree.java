package clueBinaryTree;

import java.util.Scanner;

/**
 * 线索二叉树
 * 
 * @author 83771
 *
 */
public class Tree {
	// 全局变量 始终指向刚刚访问过的节点
	private static Node pre;

	/*
	 * 创建二叉树的方法 ，约定按照前序遍历来输入数据
	 */
	public static void createTree(Node T) {
		System.out.println("请输入要插入的值");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		if (data.equals("")) {
			T = null;
			System.out.println("空");
		} else {
			T.data = data;
			T.l_tag = 0;
			T.r_tag = 0;
			T.l_node = new Node();
			createTree(T.l_node);
			T.r_node = new Node();
			createTree(T.r_node);
		}
	}

	/*
	 * 中序遍历线索化
	 */
	public static void inThreading(Node t) {
		if (t != null) {
			// 递归左孩子线索化
			inThreading(t.l_node);
			// 若没有左孩子，则把l_tag指向刚刚前一个访问过的节点
			if (t.l_node == null) {
				t.l_tag = 1;
				t.l_node = pre;
			}
			// 若刚访问的节点没有右孩子，则把r_tag指向t
			if (pre.r_node == null) {
				pre.r_tag = 1;
				pre.r_node = t;
			}
			// 并将前一个节点的位置后移一位
			pre = t;
			// 继续线索化后一位
			inThreading(t.r_node);
		}
	}

	/*
	 *初始化pre
	 */
	public static void inOrderThreading(Node p, Node t) {
		p.l_tag = 0;
		p.r_tag = 1;
		p.r_node = p;

		if (t == null) {
			p.l_node = p;
		} else {
			p.l_node = t;
			pre = p;
			inThreading(t);
			pre.r_node = p;
			pre.r_tag = 1;
			p.r_node = pre;
		}
	}

	/*
	 * 中序遍历二叉树（非递归）
	 */
	public static void showAll(Node T) {
		Node P;
		P = T.l_node;

		while (P != T) {
			while (P.l_tag == 0) {
				P = P.l_node;
			}
			System.out.println(P.data);
			while (P.r_tag == 1 && P.r_node != T) {
				P = P.r_node;
				System.out.println(P.data);
			}
			P = P.r_node;
		}
	}

	public static void main(String[] args) {
		Node p = new Node();
		Node t = new Node();
		createTree(t);
		inOrderThreading(p, t);
		showAll(p);
	}
}
