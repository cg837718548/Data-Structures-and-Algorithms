package eightQuen;

/**
 * 八皇后问题
 * 
 * @author 83771
 *
 */
public class eightQuen {
	// 定义一个数组 表示棋盘
	public static Integer[][] checkerBoard = new Integer[8][8];
	// 棋盘副本
	public static Integer[][] checkerBoardCopy = new Integer[8][8];

	// 计数器 用于计数有多少种方法
	public static Integer jishu = 1;

	// 定义横竖斜方向上是否有棋子
	public static boolean flag1 = true;
	public static boolean flag2 = true;
	public static boolean flag3 = true;
	public static boolean flag4 = true;

	// 初始化一个棋盘 8x8
	public static void init() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(0 + "    ");
				checkerBoard[i][j] = 0;
			}
			System.out.println();
		}
		checkerBoardCopy = checkerBoard;
	}

	// 递归测试方法
	public static void startTest(int row) {
		for (int col = 0; col < 8; col++) {
			if (checkCheet(row, col, checkerBoardCopy) == 1) {
				if (row < 7) {
					startTest(++row);
					--row;
				}
			}
			// 该行重新赋值为0    进行下一次判断
			checkerBoardCopy[row][col] = 0;
		}
	}

	// 检查是否危险
	// row行
	// col列
	public static int checkCheet(int row, int col, Integer[][] checkerBoardCopy) {
		flag1 = true;
		flag2 = true;
		flag3 = true;
		flag4 = true;
		// 行方向上是否满足条件
		for (int i = 0; i < 8; i++) {
			if (checkerBoardCopy[row][i] == 1) {
				flag1 = false;
				break;
			}
		}
		// 列方向上是否满足条件
		for (int j = 0; j < 8; j++) {
			if (checkerBoardCopy[j][col] == 1) {
				flag2 = false;
				break;
			}
		}
		// 右下方向
		for (int i = row, j = col; i < 8 & j < 8; i++, j++) {
			if (checkerBoardCopy[i][j] == 1) {
				flag3 = false;
				break;
			}
		}
		// 左上方向
		for (int i = row, j = col; i >= 0 & j >= 0; i--, j--) {
			if (checkerBoardCopy[i][j] == 1) {
				flag3 = false;
				break;
			}
		}
		// 左下方向
		for (int i = row, j = col; i < 8 & j >= 0; i++, j--) {
			if (checkerBoardCopy[i][j] == 1) {
				flag4 = false;
				break;
			}
		}
		// 右上方向
		for (int i = row, j = col; i >= 0 & j < 8; i--, j++) {
			if (checkerBoardCopy[i][j] == 1) {
				flag4 = false;
				break;
			}
		}
		if (flag1 & flag2 & flag3 & flag4) {
			// 若为真 增此点的值赋为1
			checkerBoardCopy[row][col] = 1;
			// 如果已经判断到最后一行 并且最后一行也符合情况 打印整个棋盘
			if (row == 7) {
				printCheets(checkerBoardCopy);
			}
			return 1;
		}
		return 0;
	}

	// 打印棋盘方法
	public static void printCheets(Integer[][] checkerBoardCopy) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(checkerBoardCopy[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println("=================" + jishu++);
	}

	public static void main(String[] args) {
		init();
		startTest(0);
	}

}