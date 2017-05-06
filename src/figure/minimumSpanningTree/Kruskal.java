package figure.minimumSpanningTree;

import java.util.LinkedList;
import java.util.List;

import figure.edgesetArray.EdgesetArray;
import figure.edgesetArray.SideNode;

/**
 * 最小生成树（Kruskal算法）
 * 
 * @author 83771
 *
 */
public class Kruskal {

	public static int find(int[] parents, int f) {
		while (parents[f] > 0) {
			f = parents[f];
		}
		return f;
	}

	/**
	 * 最小生成树的实现方法
	 */
	public static void kruskal(EdgesetArray edgesetArray) {
		int n, m;
		int maxSides = edgesetArray.gainQuantity();
		int maxDatas = edgesetArray.gainDataNum();
		// 定义边集数组
		SideNode[] sideNodes = edgesetArray.getSideArray();
		// 定义parents数组判断边与边之间是否产生回路
		int[] parents = new int[maxDatas];

		// 初始化parents数组
		for (int i = 0; i < maxDatas; i++) {
			parents[i] = 0;
		}

		for (int i = 0; i < maxSides; i++) {
			m = find(parents, sideNodes[i].getBegain());
			n = find(parents, sideNodes[i].getEnd());

			if (n != m) {
				parents[m] = n;
				System.out.println(sideNodes[i].getBegain() + "------->" + sideNodes[i].getEnd() + "权为："
						+ sideNodes[i].getWeight());
			}
		}
		for(int j:parents){
			System.out.print(j+"   ");
		}
	}

	public static void main(String[] args) {
		System.out.println("----------------------欢迎使用kruskal算法------------------------");
		System.out.println("Author：jeker_chen                                                                    |");
		System.out.println("------------------------------------------------------------------");
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

		edgesetArray.initArray(strs, sides);

		kruskal(edgesetArray);
	}

}
