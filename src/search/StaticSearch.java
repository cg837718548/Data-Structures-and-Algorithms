package search;

public class StaticSearch {

	// (顺序查找)key要查找的数据，n所查找数组的长度，ints 当前数组
	public static int staticSearch(int key, int[] ints, int n) {
		for (int i = 1; i <= n; i++) {
			if (key == ints[i - 1]) {
				return i;
			}
		}
		return -1;
	}

	// (顺序查找优化方案)
	public static int staticSearchBetter(int key, int[] ints, int n) {
		int i = n ;
		ints[0] = key;
		while (ints[i-1] != key) {
			i--;
		}
		return i;
	}

	public static void main(String[] args) {
		int ints[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		//System.out.println(staticSearch(1, ints, ints.length));
		System.out.println(staticSearchBetter(1, ints, ints.length));
	}
}
