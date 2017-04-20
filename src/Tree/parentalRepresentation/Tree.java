package Tree.parentalRepresentation;

import java.util.Scanner;

/**
 * ���� ˫�ױ�ʾ��
 * 
 * @author 83771
 *
 */
public class Tree {

	// �����������ڵ�����
	private static final int Max_Size = 100;
	// ����һ�������Žڵ�
	private Node[] tree = new Node[Max_Size];
	// �������λ��
	private int r = 0;
	// ����ڵ���Ŀ
	private int n = 0;
	private StringBuilder cishu = new StringBuilder();

	// ��ʼ����
	public void initTree() {
		String data = "";
		int parent = 0;
		Node node = new Node();
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ʼ�����ṹ��������");
		System.out.println("����������ֵ��");
		String rootData = scanner.nextLine();
		Node root = new Node(rootData, -1);
		tree[n++] = root;
		System.out.println("������Ҫ��ʼ���Ľڵ㣬����#������ʼ��");
		while (true) {
			System.out.print("�ڵ����ݣ�");
			data = scanner.next();
			if (data.equals("#")) {
				break;
			}
			System.out.print("�ڵ��˫��λ�ã�");
			parent = scanner.nextInt();
			if (tree[parent] != null) {
				node = new Node(data, parent);
				tree[n++] = node;
			} else {
				System.out.println("��Ҫ���õ�˫�׽ڵ㲻����,���������룡");
			}
		}
		System.out.println("��ʼ�����");
	}

	// ���ӽڵ�
	public void insertNode(Node node) {
		tree[n++] = node;
	}

	// ɾ���ڵ�
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

	// ��ѯ�ڵ�
	public String selectNode(int index) {
		Node node = tree[index-1];
		return node.getData();
	}

	// �޸Ľڵ�
	public void updateNode(String data, int index) {
		Node node = tree[index-1];
		node.setData(data);
	}
	
	//��ʾ���нڵ�
	public void showAll(int i,String c){
		//������ڵ��ֵ
//		cishu.append("-");
		//�ҵĸýڵ�������ӽڵ㲢��ӡ
		for(int j = 0;j<n;j++){
			if (tree[j].getParent() == i) {
				System.out.println(c+tree[j].getData());
				showAll(j,c+"-");
			}
		}
	}
}
