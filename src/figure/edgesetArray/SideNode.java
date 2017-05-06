package figure.edgesetArray;

/**
 * 边集数组中的元素
 * 
 * @author 83771
 *
 */
public class SideNode {

	/**
	 * 边的开头
	 */
	private int begain;
	/**
	 * 边的结尾
	 */
	private int end;
	/**
	 * 边的权
	 */
	private int weight;

	public int getBegain() {
		return begain;
	}

	public void setBegain(int begain) {
		this.begain = begain;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public SideNode(int begain, int end, int weight) {
		super();
		this.begain = begain;
		this.end = end;
		this.weight = weight;
	}

	public SideNode() {
		super();
	}
	

}
