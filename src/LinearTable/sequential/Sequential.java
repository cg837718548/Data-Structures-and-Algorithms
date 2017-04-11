package LinearTable.sequential;

public class Sequential {

	private Integer[] ints;
	private Integer maxSize;
	private Integer length;

	/*
	 * ���Ա��ʼ��
	 */
	public void initList() {
		//���Ա�������
		this.ints = new Integer[10];
		//��ǰ���Ա���
		this.length = 0;
		//���Ա������
		this.maxSize = 10;
	}

	/*
	 * �ж����Ա��Ƿ�Ϊ�ձ�
	 */
	public boolean isEmpty() {
		//��ǰ���Ա���Ϊ��
		if (this.length == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * �����Ա����
	 */
	public void clearSeq(){
		//�ӵ�һ����ʼ������
		for(int i = 0;i<length;i++){
			this.ints[i] = null;
		}
		length =0;
	}

	/*
	 * �������Ա�ָ��λ�õ�Ԫ��
	 */
	public Integer getElem(int index){
		//���λ���Ƿ����ʵ��
		if(index<1||index>length){
			return null;
		}
		else{
			return this.ints[index-1];
		}
	}

	/*
	 * ����ĳԪ�������Ա��е�λ��
	 */
	public int locateElem(Integer elem){
		for(int index = 1;index<=length;index++){
			if(this.ints[index-1] ==elem){
				return index;
			}
		}
		return -1;
	}
	
	/*
	 * �����Ա��е�ĳ��λ�ò���Ԫ��
	 * 
	 */
	public Integer insertElem(Integer elem,int index){
		//���Ԫ���Ƿ����ʵ��
		if(index<1||index>length+1||index>maxSize){
			return null;
		}
		else if(index == length+1){
			this.ints[index-1] = elem;
			length++;
			return elem;
		}
		else{
			for(int i = length;i>=index;i--){
				this.ints[i] = this.ints[i-1];
			}
			this.ints[index-1] = elem;
			length++;
			return elem;
		}
	}

	
	/*
	 * ɾ�����Ա�ĳ��λ�õ�Ԫ�أ������ظ�Ԫ��
	 */
	public void  deleteElem(int index){
		if(index<1||index>length||index>maxSize){
		}
		else if(index==length){
			this.ints[index-1] = null;
			length--;
		}
		else{
			for(int i = index;i<length;i++){
				this.ints[i-1] =this.ints[i];
			}
			this.ints[length-1] = null;
			length--;
		}
	}

	/*
	 * �������Ա�Ԫ�صĸ���
	 */
	public int Length(){
		return length;
	}
	
	public Integer[] getInts() {
		return ints;
	}

	public void setInts(Integer[] ints) {
		this.ints = ints;
	}

	public Integer getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
