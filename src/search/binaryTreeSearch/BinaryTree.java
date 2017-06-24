package search.binaryTreeSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 二叉树类
 * 
 * @author jeker-chen
 *
 */
public class BinaryTree {
	private static Node orignNode = new Node();

	/**
	 * 插入节点
	 * 
	 * @param 要插入的节点
	 * @param orign
	 *            目标节点
	 */
	public void InsertTree(Node node, Node orign) {
		if (node.data < orign.data) {
			if (orign.leftNode != null) {
				InsertTree(node, orign.leftNode);
			} else {
				orign.leftNode = new Node(node.data);
			}
		} else if (node.data > orign.data) {
			if (orign.rightNode != null) {
				InsertTree(node, orign.rightNode);
			} else {
				orign.rightNode = new Node(node.data);
			}
		} else {
			// do nothing
		}
	}

	/**
	 * 二叉树查找
	 * 
	 * @param mubiao
	 *            所要查找的数据
	 * @param orign
	 *            二叉树的根节点
	 */
	public Map<Node, Node> searchNode(int mubiao, Node orign, Node father) {
		if (orign == null) {
			System.out.println("查找节点不存在！");
			return null;
		}
		if (orign.data == mubiao) {
			Map<Node, Node> map = new HashMap<>();
			map.put(orign, father);
			return map;
		} else if (orign.data < mubiao) {
			return searchNode(mubiao, orign.rightNode, orign);
		} else {
			return searchNode(mubiao, orign.leftNode, orign);
		}
	}

	/**
	 * 删除二叉树中指定的元素
	 * 
	 * @param orign
	 *            二叉树根节点
	 * @param mubiao
	 *            索要删除节点的数据
	 */
	public void deleteNode(Map<Node, Node> nodeMap) {
		Node mubiao = nodeMap.keySet().iterator().next();
		Node father = nodeMap.get(mubiao);
		// 若不存在左子树
		if (mubiao.leftNode == null) {
			// 将右子节点的数据赋值给目标节点
			if (father.leftNode == mubiao) {
				father.leftNode = mubiao.rightNode;
			} else {
				father.rightNode = mubiao.rightNode;
			}
		} else if (mubiao.rightNode == null) {
			if (father.leftNode == mubiao) {
				father.leftNode = mubiao.leftNode;
			} else {
				father.rightNode = mubiao.leftNode;
			}
		} else {
			Node left = mubiao.leftNode;
			if (left.rightNode == null) {
				father.leftNode = mubiao.leftNode;
				mubiao = null;
			} else {
				father = left;
				// 获得目标节点相邻节点
				while (left.rightNode != null) {
					father = left;
					left = left.rightNode;
				}
				mubiao.data = left.data;
				father.rightNode = null;
			}
		}
	}

	public Node Create(List<Integer> integers) {
		for (int i = 0; i < integers.size(); i++) {
			if (i == 0) {
				orignNode.data = integers.get(i);
			} else {
				Node node = new Node(integers.get(i));
				InsertTree(node, orignNode);
			}
		}
		return orignNode;
	}

	/*
	 * 前序遍历二叉树的节点
	 */
	public void preorderTraversal(Node T, int level) {
		if (T != null) {
			System.out.println(T.data + "在第" + level + "层");
			preorderTraversal(T.leftNode, level + 1);
			preorderTraversal(T.rightNode, level + 1);
		}
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		List<Integer> integers = new LinkedList<>();
		integers.add(5);
		integers.add(7);
		integers.add(3);
		integers.add(1);
		integers.add(2);
		integers.add(6);
		integers.add(4);
		
		binaryTree.Create(integers);
		binaryTree.preorderTraversal(orignNode, 0);
		System.out.println("=====================");
		Map<Node, Node> nodeMap = binaryTree.searchNode(1, orignNode, orignNode);
		// System.out.println(node.data);
		System.out.println(nodeMap.keySet().iterator().next().data);
		System.out.println(nodeMap.get(nodeMap.keySet().iterator().next()).data);
		binaryTree.deleteNode(nodeMap);
		binaryTree.preorderTraversal(orignNode, 0);

	}

}
