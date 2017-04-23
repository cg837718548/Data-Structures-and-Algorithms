package huffmanCode;
/**
 * 赫夫曼表（记录各个字符所对应的在赫夫曼树中的编码）
 * @author 83771
 *
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class huffmanTable {
	private HashMap<String, Character> HuffmanTable = new HashMap<>();
//	private String codeValue = "";

	/**
	 * 存放huffmanTree中各个叶子结点的变长编码数据
	 * 
	 * @param node
	 *            huffmanTree的根节点
	 */
	public void storeData(Node node, int zy,String codeValue) {
		if (node != null) {
			switch (zy) {
			case 0:
				codeValue += "0";
				break;
			case 1:
				codeValue += "1";
				break;
			default:
				break;
			}
			if (node.getLeft_child() == null && node.getRight_child() == null) {
				HuffmanTable.put(codeValue,node.getData());
			} else {
				if (node.getLeft_child() != null) {
					storeData(node.getLeft_child(), 0,codeValue);
				}
				if (node.getRight_child() != null) {
					storeData(node.getRight_child(), 1,codeValue);
				}
			}
		}
	}



	public HashMap<String, Character> getHuffmanTable() {
		return HuffmanTable;
	}

	public void setHuffmanTable(HashMap<String, Character> huffmanTable) {
		HuffmanTable = huffmanTable;
	}

//	public String getCodeValue() {
//		return codeValue;
//	}
//
//	public void setCodeValue(String codeValue) {
//		this.codeValue = codeValue;
//	}

	public static void main(String[] args) {
		// System.out.println("hello".substring(0, 4));
		huffmanTree tree = new huffmanTree();
		String str = "chhhhheenganggggnnnnn";
		Node rootNode = tree.buildTree(str);
		huffmanTable table = new huffmanTable();
		table.storeData(rootNode, 2,"");
		System.out.println(table.HuffmanTable.size());
		Set<String> set = table.HuffmanTable.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String yuansu = iterator.next();
			System.out.println(yuansu + ">>>>>>>" + table.HuffmanTable.get(yuansu));
		}
	}

}
