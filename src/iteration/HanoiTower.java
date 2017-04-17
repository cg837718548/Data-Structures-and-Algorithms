package iteration;

public class HanoiTower {

	// 汉诺塔问题解决方案（递归）
	/**
	 * 
	 * @param total  盘子总数
	 * @param Start  起始针
	 * @param Auxiliary 辅助针
	 * @param end 最终针
	 */
	public static void hanoiTower(int total, char Start, char Auxiliary, char end) {
		if (total == 1) {
			System.out.println(Start + "---->" + end);
		} else {
			// 将汉诺塔的前total-1个盘借助end移动到Auxiliary
			hanoiTower(total - 1, Start, end, Auxiliary);
			// 将最后一个直接从起始移到目标
			System.out.println(Start + "---->" + end);
			// 将汉诺塔的前total-1个盘借助start移动到end
			hanoiTower(total-1, Auxiliary, Start, end);
		}
	}
	
	public static void main(String[] args) {
		hanoiTower(3, 'A', 'B', 'C');
	}
}
