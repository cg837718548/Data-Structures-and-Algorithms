package KMP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 判断一个字符串是否在一个主串里面
 * 
 * @author 83771
 *
 */
public class Jdgement {

	// 计算出str的匹配值
	public static int pipeizhi(String str) {
		int res = 0;
		List<String> qian = new ArrayList<>();
		List<String> hou = new ArrayList<>();
		String jiezhi;
		for (int i = 0; i < str.length() - 1; i++) {
			System.out.println(str.substring(0, i + 1) + "   " + str.substring(i + 1, str.length()));
			qian.add(str.substring(0, i + 1));
			hou.add(str.substring(i + 1, str.length()));
		}
		Iterator<String> iterator = qian.iterator();
		while (iterator.hasNext()) {
			jiezhi = iterator.next();
			if (hou.contains(jiezhi)) {
				res += jiezhi.length();
			}
		}
		return res;
	}

	public static void judge(String zi, String zhu) {
		// 子串定位
		int i = 0;
		// 主串定位
		int j = 0;

		while (i < zi.length() && j < zhu.length()) {
			System.out.println(i + "<i>" + j + "<j>" + zhu.length());
			if (i == 0 || zhu.charAt(j) == zi.charAt(i)) {
				j++;
				i++;
			} else {
				// 解决不相同的情况（i等于多少即前面有几个元素）
				String str = zi.substring(0, i);
				// p为匹配值，知道需要后移几位
				int p = pipeizhi(str);
				i -= (str.length() - p);
				System.out.println(i + "   " + j);
			}
		}
		if (j == zhu.length() && i != zi.length()) {
			System.out.println("j=" + j);
			System.out.println("子串不存在！");
		} else {
			System.out.println("子串存在！");
		}

	}

	public static void main(String[] args) {
		System.out.println(pipeizhi("A"));
		judge("abc", "abcd");
		judge("abc", "aabc");
		judge("abc", "vabcv");
		judge("abg", "abc");
		judge("asd", "qwe");
		judge("a","aaaaaa");
		judge("wasd", "sfjdgjdbshajfwasdfhuiea");
	}
}
