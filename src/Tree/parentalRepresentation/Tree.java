package Tree.parentalRepresentation;

import java.util.Scanner;

/**
 * 树类 双亲表示法
 * 
 * @author 83771
 *
 */
public class Tree {

	// 定义树的最大节点容量
	private static final int Max_Size = 100;
	// 定义一个数组存放节点
	private Node[] tree = new Node[Max_Size];
	// 定义根的位置
	private int r = 0;
	// 定义节点数目
	private int n = 0;
	private StringBuilder cishu = new StringBuilder();

	// 初始化树
	public void initTree() {
		String data = "";
		int parent = 0;
		Node node = new Node();
		Scanner scanner = new Scanner(System.in);
		System.out.println("初始化树结构。。。。");
		System.out.println("请输入树根值：");
		String rootData = scanner.nextLine();
		Node root = new Node(rootData, -1);
		tree[n++] = root;
		System.out.println("请输入要初始化的节点，输入#结束初始化");
		while (true) {
			System.out.print("节点数据：");
			data = scanner.next();
			if (data.equals("#")) {
				break;
			}
			System.out.print("节点的双亲位置：");
			parent = scanner.nextInt();
			if (tree[parent] != null) {
				node = new Node(data, parent);
				tree[n++] = node;
			} else {
				System.out.println("所要引用的双亲节点不成立,请重新输入！");
			}
		}
		System.out.println("初始化完毕");
	}

	// 增加节点
	public void insertNode(Node node) {
		tree[n++] = node;
	}

	// 删除节点
	public void deleteNode(int index) {
//		System.out.println("^^"+n);
		System.out.println(tree[index-1].getData());
		tree[index - 1] = new Node();
//		System.out.println("^^^^"+n);
		for (int i = 0; i < n; i++) {
			if (tree[i].getParent() == index-1) {
				deleteNode(i+1);
			}
		}
	}

	// 查询节点
	public String selectNode(int index) {
		Node node = tree[index-1];
		return node.getData();
	}

	// 修改节点
	public void updateNode(String data, int index) {
		Node node = tree[index-1];
		node.setData(data);
	}
	
	//显示所有节点
	public void showAll(int i,String c){
		//输出父节点的值
//		cishu.append("-");
		//找的该节点的所有子节点并打印
		for(int j = 0;j<n;j++){
			if (tree[j].getParent() == i) {
				System.out.println(c+tree[j].getData());
				showAll(j,c+"-");
			}
		}
	}
}
