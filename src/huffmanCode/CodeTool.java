package huffmanCode;

import java.util.HashMap;

/**
 * ����������Ľ���ͱ��빤��
 * 
 * @author 83771
 *
 */
public class CodeTool {

	private static huffmanTree huffmanTree = new huffmanTree();
	private static huffmanTable huffmanTable = new huffmanTable();

	/*
	 * ���빤�ߣ����������ַ�ת���ɱ����ʽ���棩
	 */
	public static void enCode(String content) {
		Node rootNode = huffmanTree.buildTree(content);
		huffmanTable.storeData(rootNode, 2,"");
	}

	/*
	 * ���빤�ߣ��������ı����ʽ���ַ���ת������Ӧ���ַ���
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
