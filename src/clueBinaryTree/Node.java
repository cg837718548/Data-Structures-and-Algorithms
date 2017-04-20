package clueBinaryTree;

/**
 * 线索二叉树的节点类
 * 
 * @author 83771
 *
 */
public class Node {
	/*
	 * 节点数据
	 */
	String data;
	/*
	 * 左孩子或者是前驱（根据线索存储标志来却确定）
	 */
	Node l_node;
	/*
	 * 左线索存储标志（0：表示左孩子指针，1：表示前驱指针）
	 */
	int l_tag;
	/*
	 * 右孩子或者后继（根据线索存储标志来确定）
	 */
	Node r_node;
	/*
	 * 右线索存储标志（0：表示右孩子指针，1：表示后继指针）
	 */
	int r_tag;

}
