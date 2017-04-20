package Tree.parentalRepresentation;

public class TreeTest {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.initTree();
		//显示树的所有节点
		tree.showAll(-1,"-");
		System.out.println("初始化---------------------------------");
		//增加节点
		Node node = new Node("我是新来的！", 3);
		tree.insertNode(node);
		tree.showAll(-1, "-");
		System.out.println("新加元素 父节点在索引为3---------------------------------");
		//删除节点
		tree.deleteNode(3);
		tree.showAll(-1, "-");
		System.out.println("删除第三个节点及子树---------------------------------");
		//查询节点
		System.out.println(tree.selectNode(2));
		
	}
}
