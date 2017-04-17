package LinearTable.CircularList;

public class CardGroup extends CircleList {

	public void resolve2() {
		int k[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		Node temp = getFirst();
		Node target = getFirst();
		int j = 0;

		//�ж� ��Ϊ��һ���� ��ֱ�Ӹ�ֵ
		if(k[j]==1){
			target.setData("1");
			target = target.getNext();
			j++;
		}
		while (target.getNext() != null&&k[j]>1&&j<12) {
			//������������Ӧ��λ��
			for (int i = 1; i < k[j] - 1; i++) {
				while(!target.getNext().getData().equals("0")){
					target = target.getNext();
				}
				target = target.getNext();
			}
			//��Ӧ��λ��
			temp = target.getNext();
			//����Ӧ��λ������������������Ƶ���һλ��ֱ��û��ֵ����һλ
			while(!temp.getData().equals("0")){
				temp = temp.getNext();
			}
			temp.setData(k[j]+"");
			target = temp.getNext();
			while(!target.getData().equals("0")){
				target = target.getNext();
			}
			temp = null;
			j++;
		}
		while (!target.getData().equals("0")) {
			target = target.getNext();
		}
		target.setData(k[j]+"");

	}

	public void createGroup() {
		// ��ʼ������
		initList();
		
		// ʹ�ü�ǿ��Լɪ������
		resolve2();
		getAll();
	}
	
	public static void main(String[] args) {
		CardGroup cardGroup = new CardGroup();
		cardGroup.createGroup();
	}
}
