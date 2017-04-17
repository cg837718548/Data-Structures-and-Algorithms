package LinearTable.CircularList;

public class CardGroup extends CircleList {

	public void resolve2() {
		int k[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		Node temp = getFirst();
		Node target = getFirst();
		int j = 0;

		//判断 若为第一张牌 则直接赋值
		if(k[j]==1){
			target.setData("1");
			target = target.getNext();
			j++;
		}
		while (target.getNext() != null&&k[j]>1&&j<12) {
			//遍历到后面相应的位置
			for (int i = 1; i < k[j] - 1; i++) {
				while(!target.getNext().getData().equals("0")){
					target = target.getNext();
				}
				target = target.getNext();
			}
			//相应的位置
			temp = target.getNext();
			//若相应的位置上已有数据则继续移到下一位，直到没有值的哪一位
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
		// 初始化牌组
		initList();
		
		// 使用加强版约瑟夫问题
		resolve2();
		getAll();
	}
	
	public static void main(String[] args) {
		CardGroup cardGroup = new CardGroup();
		cardGroup.createGroup();
	}
}
