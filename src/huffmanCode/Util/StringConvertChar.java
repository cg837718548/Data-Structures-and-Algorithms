package huffmanCode.Util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringConvertChar {

	/*
	 * 将字符串转换为字符数组（重复的元素不加入该数组）
	 */
	public static char[] convertChar(String string) {
		StringBuilder builder = new StringBuilder();
		Set<Character> charset = new HashSet<>();
		for (int i = 0; i < string.length(); i++) {
			charset.add(string.charAt(i));
		}
		Iterator<Character> iterator = charset.iterator();
		while (iterator.hasNext()) {
			builder.append(iterator.next());
		}
		return builder.toString().toCharArray();
	}
}
