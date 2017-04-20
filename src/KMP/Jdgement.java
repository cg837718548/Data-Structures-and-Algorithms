package KMP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �ж�һ���ַ����Ƿ���һ����������
 * 
 * @author 83771
 *
 */
public class Jdgement {

	// �����str��ƥ��ֵ
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
		// �Ӵ���λ
		int i = 0;
		// ������λ
		int j = 0;

		while (i < zi.length() && j < zhu.length()) {
			System.out.println(i + "<i>" + j + "<j>" + zhu.length());
			if (i == 0 || zhu.charAt(j) == zi.charAt(i)) {
				j++;
				i++;
			} else {
				// �������ͬ�������i���ڶ��ټ�ǰ���м���Ԫ�أ�
				String str = zi.substring(0, i);
				// pΪƥ��ֵ��֪����Ҫ���Ƽ�λ
				int p = pipeizhi(str);
				i -= (str.length() - p);
				System.out.println(i + "   " + j);
			}
		}
		if (j == zhu.length() && i != zi.length()) {
			System.out.println("j=" + j);
			System.out.println("�Ӵ������ڣ�");
		} else {
			System.out.println("�Ӵ����ڣ�");
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
