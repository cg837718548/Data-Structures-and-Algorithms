package iteration;

public class HanoiTower {

	// ��ŵ���������������ݹ飩
	/**
	 * 
	 * @param total  ��������
	 * @param Start  ��ʼ��
	 * @param Auxiliary ������
	 * @param end ������
	 */
	public static void hanoiTower(int total, char Start, char Auxiliary, char end) {
		if (total == 1) {
			System.out.println(Start + "---->" + end);
		} else {
			// ����ŵ����ǰtotal-1���̽���end�ƶ���Auxiliary
			hanoiTower(total - 1, Start, end, Auxiliary);
			// �����һ��ֱ�Ӵ���ʼ�Ƶ�Ŀ��
			System.out.println(Start + "---->" + end);
			// ����ŵ����ǰtotal-1���̽���start�ƶ���end
			hanoiTower(total-1, Auxiliary, Start, end);
		}
	}
	
	public static void main(String[] args) {
		hanoiTower(3, 'A', 'B', 'C');
	}
}
