package LinearTable.sequential;

public class Sequential {

	private Integer[] ints;
	private Integer maxSize;
	private Integer length;

	/*
	 * 线性表初始化
	 */
	public void initList() {
		//线性表总容量
		this.ints = new Integer[10];
		//当前线性表长度
		this.length = 0;
		//线性表最长长度
		this.maxSize = 10;
	}

	/*
	 * 判断线性表是否为空表
	 */
	public boolean isEmpty() {
		//当前线性表长度为零
		if (this.length == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 将线性表清空
	 */
	public void clearSeq(){
		//从第一个开始逐个清楚
		for(int i = 0;i<length;i++){
			this.ints[i] = null;
		}
		length =0;
	}

	/*
	 * 返回线性表指定位置的元素
	 */
	public Integer getElem(int index){
		//检查位置是否符合实际
		if(index<1||index>length){
			return null;
		}
		else{
			return this.ints[index-1];
		}
	}

	/*
	 * 查找某元素在线性表中的位置
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
	 * 在线性表中的某个位置插入元素
	 * 
	 */
	public Integer insertElem(Integer elem,int index){
		//检查元素是否符合实际
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
	 * 删除线性表某个位置的元素，并返回该元素
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
	 * 返回线性表元素的个数
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
