package Tree.parentalRepresentation;

public class TreeTest {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.initTree();
		//��ʾ�������нڵ�
		tree.showAll(-1,"-");
		System.out.println("��ʼ��---------------------------------");
		//���ӽڵ�
		Node node = new Node("���������ģ�", 3);
		tree.insertNode(node);
		tree.showAll(-1, "-");
		System.out.println("�¼�Ԫ�� ���ڵ�������Ϊ3---------------------------------");
		//ɾ���ڵ�
		tree.deleteNode(3);
		tree.showAll(-1, "-");
		System.out.println("ɾ���������ڵ㼰����---------------------------------");
		//��ѯ�ڵ�
		System.out.println(tree.selectNode(2));
		
	}
}
