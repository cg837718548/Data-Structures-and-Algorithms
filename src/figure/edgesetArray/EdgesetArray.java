package figure.edgesetArray;

import java.util.LinkedList;
import java.util.List;

/**
 * 图的边集数组表示法
 * 
 * @author 83771
 *
 */
public class EdgesetArray {

	private String[] datas;
	private SideNode[] sideArray;

	public void initArray(List<String> strs, List<SideNode> sides) {
		int length = strs.size();
		datas = new String[length];
		for (int i = 0; i < length; i++) {
			datas[i] = strs.get(i);
		}

		length = sides.size();
		sideArray = new SideNode[length];
		for (int i = 0; i < length; i++) {
			sideArray[i] = sides.get(i);
		}
	}

	public List<SideNode> sortList(List<SideNode> list) {
		List<SideNode> sides = new LinkedList<>();
		int biaoji = 0;
		while (list.size() > 0) {
			int maxPow = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getWeight() < maxPow) {
					maxPow = list.get(i).getWeight();
					biaoji = i;
				}
			}
			sides.add(list.get(biaoji));
			list.remove(biaoji);
		}
		return sides;
	}

	/**
	 * 获取边的数量
	 * 
	 * @return
	 */
	public int gainQuantity() {
		return sideArray.length;
	}
	/**
	 * 获取顶点的数量
	 * @return
	 */
	public int gainDataNum(){
		return datas.length;
	}

	public SideNode[] getSideArray() {
		return sideArray;
	}

	public void setSideArray(SideNode[] sideArray) {
		this.sideArray = sideArray;
	}
	

	public String[] getDatas() {
		return datas;
	}

	public void setDatas(String[] datas) {
		this.datas = datas;
	}

	public static void main(String[] args) {
		List<String> strs = new LinkedList<>();
		List<SideNode> list = new LinkedList<>();
		String str0 = "110";
		String str1 = "111";
		String str2 = "112";
		String str3 = "113";
		String str4 = "114";
		String str5 = "115";
		String str6 = "116";
		String str7 = "117";
		String str8 = "118";
		strs.add(str0);
		strs.add(str1);
		strs.add(str2);
		strs.add(str3);
		strs.add(str4);
		strs.add(str5);
		strs.add(str6);
		strs.add(str7);
		strs.add(str8);
		SideNode sideNode0 = new SideNode(0, 1, 10);
		SideNode sideNode1 = new SideNode(0, 5, 11);
		SideNode sideNode2 = new SideNode(1, 2, 18);
		SideNode sideNode3 = new SideNode(1, 6, 16);
		SideNode sideNode4 = new SideNode(1, 8, 12);
		SideNode sideNode5 = new SideNode(2, 3, 22);
		SideNode sideNode6 = new SideNode(2, 8, 8);
		SideNode sideNode13 = new SideNode(3, 4, 20);
		SideNode sideNode14 = new SideNode(3, 7, 16);
		
		SideNode sideNode7 = new SideNode(3, 6, 24);
		SideNode sideNode8 = new SideNode(3, 8, 21);
		SideNode sideNode9 = new SideNode(4, 5, 26);
		SideNode sideNode10 = new SideNode(4, 7, 7);
		SideNode sideNode11 = new SideNode(5, 6, 17);
		SideNode sideNode12 = new SideNode(6, 7, 19);
		list.add(sideNode0);
		list.add(sideNode1);
		list.add(sideNode2);
		list.add(sideNode3);
		list.add(sideNode4);
		list.add(sideNode5);
		list.add(sideNode6);
		list.add(sideNode7);
		list.add(sideNode8);
		list.add(sideNode9);
		list.add(sideNode10);
		list.add(sideNode11);
		list.add(sideNode12);
		list.add(sideNode13);
		list.add(sideNode14);
		
		
		EdgesetArray edgesetArray = new EdgesetArray();
		List<SideNode> sides = edgesetArray.sortList(list);
		for(int i = 0;i<sides.size();i++){
			System.out.println(sides.get(i).getBegain()+"---->"+sides.get(i).getEnd()+"=="+sides.get(i).getWeight());
		}

	}

}
