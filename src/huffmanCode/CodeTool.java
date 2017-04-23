package huffmanCode;

import java.util.HashMap;

/**
 * 哈夫曼编码的解码和编码工具
 * 
 * @author 83771
 *
 */
public class CodeTool {

	private static huffmanTree huffmanTree = new huffmanTree();
	private static huffmanTable huffmanTable = new huffmanTable();

	/*
	 * 编码工具（将给定的字符转换成编码格式储存）
	 */
	public static void enCode(String content) {
		Node rootNode = huffmanTree.buildTree(content);
		huffmanTable.storeData(rootNode, 2,"");
	}

	/*
	 * 解码工具（将给定的编码格式的字符串转换成相应的字符）
	 */
	public static String deCode(String contentCode) {
		StringBuilder builder = new StringBuilder();
		StringBuilder content = new StringBuilder();
		HashMap<String, Character> hashMap = huffmanTable.getHuffmanTable();
		for (int i = 0; i < contentCode.length(); i++) {
			builder.append(contentCode.charAt(i));
			if (hashMap.containsKey(builder.toString())) {
				content.append(hashMap.get(builder.toString()));
				builder.delete(0, builder.length());
			}
		}
		return content.toString();
	}

}
