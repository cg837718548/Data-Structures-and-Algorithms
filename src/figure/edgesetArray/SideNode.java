package figure.edgesetArray;

/**
 * �߼������е�Ԫ��
 * 
 * @author 83771
 *
 */
public class SideNode {

	/**
	 * �ߵĿ�ͷ
	 */
	private int begain;
	/**
	 * �ߵĽ�β
	 */
	private int end;
	/**
	 * �ߵ�Ȩ
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
