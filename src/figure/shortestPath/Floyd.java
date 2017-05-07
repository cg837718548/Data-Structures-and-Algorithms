package figure.shortestPath;

import figure.neighborhoodMatrix.nodirection.NeighborhoodMatrix;

/**
 * 图的最短路径（Floyd算法）
 * 
 * @author 83771
 *
 */
public class Floyd {

	private int[][] pathArc;
	private int[][] pathSum;

	/**
	 * Floyd算法
	 * 
	 */
	public void floyd(NeighborhoodMatrix matrix, int[][] pathArc, int[][] pathSum) {
		int MaxVex = matrix.gainQuantity();
		for (int i = 0; i < MaxVex; i++) {
			for (int j = 0; j < MaxVex; j++) {
				pathSum[i][j] = matrix.getMatrix()[i][j];
				pathArc[i][j] = j;
			}
		}

		for (int i = 0; i < MaxVex; i++) {
			for (int j = 0; j < MaxVex; j++) {
				for (int k = 0; k < MaxVex; k++) {
					if (pathSum[j][k] > pathSum[j][i] + pathSum[i][k]) {
						pathSum[j][k] = pathSum[j][i] + pathSum[i][k];
						pathArc[j][k] = pathArc[j][i];
					}
				}
			}
		}
		this.pathArc = pathArc;
		this.pathSum = pathSum;

	}

	public static void main(String[] args) {

	}
}
