package search.binaryTreeSearch;
/**
 * 二叉树节点
 * @author jeker-chen
 *
 */
public class Node {
	int data;
	Node leftNode ;
	Node rightNode ;
	public Node(int data, Node leftNode, Node rightNode) {
		super();
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	public Node() {
		super();
	}
	public Node(int data) {
		super();
		this.data = data;
	}
	
	
}
