package iteration;

import java.util.LinkedList;
import java.util.List;

import LinearTable.chain.LinkList;

public class FibonacciSeries {

	// µü´ú
	public void fi(int k) {
		int[] sums = new int[k];
		for (int i = 0; i < k; i++) {
			if (i == 0) {
				sums[i] = 0;
			} else if (i == 1) {
				sums[i] = 1;
			} else {
				sums[i] = sums[i - 1] + sums[i - 2];
			}
			System.out.println(sums[i] + ">>");
		}
	}

	// µİ¹é
	public int Fibonacci(int k) {
		if (k == 0) {
			return 0;
		} else if (k == 1) {
			return 1;
		} else {
			return Fibonacci(k - 1) + Fibonacci(k - 2);
		}
	}

	// ×Ö·û´®µ¹ĞòÊä³öÀ´
	public void printReverse(String str) {
		if (str.length() > 1) {
			printReverse(str.substring(1, str.length()));
		}
		System.out.print(str.substring(0, 1));
	}

	// µİ¹éÊµÏÖÕÛ°ë²éÕÒ
	public void isExist(List<Integer> list, int aim) {
		if( list.get((list.size() - 1) / 2) == aim){
			System.out.println("´æÔÚ");
			return;
		}
		else if ( list.get((list.size() - 1) / 2) < aim) {
			list = list.subList((list.size() - 1) / 2 + 1, list.size());
			isExist(list, aim);
		}
		else if( list.get((list.size() - 1) / 2) > aim){
			list = list.subList(0,(list.size() - 1) / 2 );
			isExist(list, aim);
		}
	}

	public static void main(String[] args) {
//		System.out.println();
		FibonacciSeries series = new FibonacciSeries();
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		series.isExist(list, 1);
		series.isExist(list, 2);
		series.isExist(list, 3);
		series.isExist(list, 4);
		series.isExist(list, 5);
		series.isExist(list, 6);
//		series.printReverse("1234");
		// System.out.println(series.Fibonacci(12));
		// series.fi(12);

	}
}
