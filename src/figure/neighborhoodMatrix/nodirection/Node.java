package figure.neighborhoodMatrix.nodirection;

/**
 * 临阶矩阵的结点类
 * 
 * @author 83771
 *
 */
public class Node {
	// 结点数据
	private String data;
	//定义结点的序号
//	private int number;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

//	public int getNumber() {
//		return number;
//	}
//
//	public void setNumber(int number) {
//		this.number = number;
//	}

	public Node(String data) {
		super();
		this.data = data;
	}

	public Node() {
		super();
	}

}
