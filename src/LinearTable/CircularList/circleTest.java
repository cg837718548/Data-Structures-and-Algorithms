package LinearTable.CircularList;

import java.util.Scanner;

public class circleTest {

	public static void main(String[] args) {
		CircleList list = new CircleList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1��ʼ����2�������ݣ�3ɾ�����ݣ�4��ʾ�������ݣ�5��ʾĳһ����ֵ,6��ʾ������м�ֵ,7Լɪ������ѡ��˳��");
		while (scanner.hasNextLine()) {
			int s = Integer.parseInt(scanner.nextLine());
			switch (s) {
			case 1:
				list.initList();
				System.out.println("--------------------------");
				break;
			case 2:
				list.insertData();
				System.out.println("--------------------------");
				break;
			case 3:
				list.deleteData();
				System.out.println("--------------------------");
				break;
			case 4:
				list.getAll();
				System.out.println("--------------------------");
				break;
			case 5:
				list.getIndex();
				System.out.println("--------------------------");
				break;
			case 6:
				list.getMedium();
				System.out.println("--------------------------");
				break;
			default :
				list.resolve2();
				System.out.println("--------------------------");
			}
		}

	}

}
