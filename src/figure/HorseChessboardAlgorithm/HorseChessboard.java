package figure.HorseChessboardAlgorithm;

/**
 * 马蹋棋盘算法
 * 
 * @author 83771
 *
 */
public class HorseChessboard {

	public static final int Xmax = 5;
	public static final int Ymax = 5;
	public static final int[][] ChessBoard = new int[Xmax][Ymax];

	/**
	 * 判断棋子的下一步路劲是否可走
	 * 
	 * @param x
	 *            棋子的横坐标
	 * @param y
	 *            棋子的纵坐标
	 * @param count
	 *            棋子要走的第几种走法
	 * @return 判断是否走得通 （0:不能，1:能）
	 */
	public static boolean nextXY(Board board, int count) {
		switch (count) {
		case 0:
			if (board.x - 1 >= 0 && board.y + 2 <= Ymax - 1 && ChessBoard[board.x - 1][board.y + 2] == 0) {
				board.x -= 1;
				board.y += 2;
				return true;
			}
			break;
		case 1:
			if (board.x + 1 <= Xmax - 1 && board.y + 2 <= Ymax - 1 && ChessBoard[board.x + 1][board.y + 2] == 0) {
				board.x += 1;
				board.y += 2;
				return true;
			}
			break;
		case 2:
			if (board.x + 2 <= Xmax - 1 && board.y + 1 <= Ymax - 1 && ChessBoard[board.x + 2][board.y + 1] == 0) {
				board.x += 2;
				board.y += 1;
				return true;
			}
			break;
		case 3:
			if (board.x + 2 <= Xmax - 1 && board.y - 1 >= 0 && ChessBoard[board.x + 2][board.y - 1] == 0) {
				board.x += 2;
				board.y -= 1;
				return true;
			}
			break;
		case 4:
			if (board.x + 1 <= Xmax - 1 && board.y - 2 >= 0 && ChessBoard[board.x + 1][board.y - 2] == 0) {
				board.x += 1;
				board.y -= 2;
				return true;
			}
			break;

		case 5:
			if (board.x - 1 >= 0 && board.y - 2 >= 0 && ChessBoard[board.x - 1][board.y - 2] == 0) {
				board.x -= 1;
				board.y -= 2;
				return true;
			}
			break;
		case 6:
			if (board.x - 2 >= 0 && board.y - 1 >= 0 && ChessBoard[board.x - 2][board.y - 1] == 0) {
				board.x -= 2;
				board.y -= 1;
				return true;
			}
			break;
		case 7:
			if (board.x - 2 >= 0 && board.y + 1 <= Ymax - 1 && ChessBoard[board.x - 2][board.y + 1] == 0) {
				board.x -= 2;
				board.y += 1;
				return true;
			}
			break;
		default:
			break;
		}
		return false;
	}

	/**
	 * 深度优先遍历棋盘
	 * 
	 * @param x
	 *            棋子的横坐标
	 * @param y
	 *            棋子的纵坐标
	 * @param tag
	 *            标记变量 每走一步 ta+1
	 * @return 判断是否能走通
	 */
	public static Integer travelBoard(Board board, Integer tag) {
		// count:棋子所走路径的编号，flag:判断该路径是否已经别走过
		Board board1 = new Board(board.x, board.y);
		Integer count = 0;
		boolean flag;
		ChessBoard[board.x][board.y] = tag;
		// 若所走的步数等于棋盘总格数
		if (Xmax * Ymax == tag) {
			return 1;
		}

		flag = nextXY(board1, count);
		while (flag == false && count < 7) {
			count++;
			flag = nextXY(board1, count);
		}
		while (flag == true) {
			if (travelBoard(board1, tag + 1) == 1) {
				return 1;
			}
			board1.x = board.x;
			board1.y = board.y;
			count++;
			flag = nextXY(board1, count);
			while (flag == false && count < 7) {
				count++;
				flag = nextXY(board1, count);
			}
		}
		if (flag == false) {
			ChessBoard[board.x][board.y] = 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		Board board = new Board(2, 2);
		for (int i = 0; i < Xmax; i++) {
			for (int j = 0; j < Ymax; j++) {
				ChessBoard[i][j] = 0;
			}
		}
		travelBoard(board, 1);
		System.out.println("查找完毕");
		for (int i = 0; i < Xmax; i++) {
			for (int j = 0; j < Ymax; j++) {
				System.out.print("  " + ChessBoard[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
