package clueBinaryTree;

import java.util.Scanner;

/**
 * ����������
 * 
 * @author 83771
 *
 */
public class Tree {
	// ȫ�ֱ��� ʼ��ָ��ոշ��ʹ��Ľڵ�
	private static Node pre;

	/*
	 * �����������ķ��� ��Լ������ǰ���������������
	 */
	public static void createTree(Node T) {
		System.out.println("������Ҫ�����ֵ");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		if (data.equals("")) {
			T = null;
			System.out.println("��");
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
	 * �������������
	 */
	public static void inThreading(Node t) {
		if (t != null) {
			// �ݹ�����������
			inThreading(t.l_node);
			// ��û�����ӣ����l_tagָ��ո�ǰһ�����ʹ��Ľڵ�
			if (t.l_node == null) {
				t.l_tag = 1;
				t.l_node = pre;
			}
			// ���շ��ʵĽڵ�û���Һ��ӣ����r_tagָ��t
			if (pre.r_node == null) {
				pre.r_tag = 1;
				pre.r_node = t;
			}
			// ����ǰһ���ڵ��λ�ú���һλ
			pre = t;
			// ������������һλ
			inThreading(t.r_node);
		}
	}

	/*
	 *��ʼ��pre
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
	 * ����������������ǵݹ飩
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
