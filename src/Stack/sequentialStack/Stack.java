package Stack.sequentialStack;

import java.util.LinkedList;

/**
 * ����һ��ջ
 * 
 * @author 83771
 *
 */
public class Stack {
	private static final int MaxSize = 3;
	private static final int Increment = 3;

	// ջ����ֵ
	private Character[] topData;
	// ջ��ָ��
	private int base;
	// ջ��ָ��
	private int top;
	// ջ������
	private int stackSize;

	public Character[] getTopData() {
		return topData;
	}

	public void setTopData(Character[] topData) {
		this.topData = topData;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getStackSize() {
		return stackSize;
	}

	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	/*
	 * ��ʼ��һ��ջ
	 */
	public void initStack() {
		this.top = this.base = 1;
		this.stackSize = MaxSize;
		this.topData = new Character[MaxSize];
	}

	/*
	 * ����������ʱ ����
	 */
	public void expend() {

		Character[] larger = new Character[stackSize + Increment];
		for (int i = 0; i < top - 1; i++) {
			larger[i] = topData[i];
		}
		topData = larger;
		stackSize = stackSize + Increment;
	}

	/*
	 * ��ջ����
	 */
	public void push(char data) {
		// ���ջ������׷�ӿռ�
		if (this.top - this.base >= stackSize) {
			this.top = this.base + stackSize;
			expend();
		}
		this.topData[top - 1] = data;
		this.top++;
	}

	/*
	 * ��ջ����
	 */
	public Character pop() {
		if (this.top == this.base) {
			return null;
		}
		top--;
		char r = this.topData[top - 1];
		topData[top - 1] = null;
		return r;
	}

	/*
	 * ���һ��ջ
	 */

	public void clearStack() {
		this.top = this.base;
	}

	/*
	 * ����һ��ջ
	 */
	public void destoryStack() {
		int i, len;
		len = this.topData.length;
		for (i = 0; i < len; i++) {
			topData[i] = null;
		}
		this.base = this.top = 0;
		this.stackSize = 0;
	}

	/*
	 * ���㵱ǰջ������
	 */
	public int stackLen() {
		return this.top - this.base;
	}

	/*
	 * ������תʮ���Ƶķ���
	 */
	public int TzhaunT(String chars) {
		int sum = 0;
		Stack stack = new Stack();
		stack.initStack();
		// String chars = "11001001";
		for (int i = 0; i < chars.length(); i++) {
			stack.push(chars.charAt(i));
		}
		// System.out.println(stack.stackLen());
		// System.out.println(stack.top);
		int j = stack.top;
		for (int i = 0; i < j - 1; i++) {
			sum += Math.scalb(Integer.valueOf(stack.pop() - 48), i);
		}
		// System.out.println(sum);
		return sum;

	}

	/*
	 * ������ת�˽��Ƶķ���
	 */
	public void TzhuanE() {
		int pos = 3;
		Stack stack2 = new Stack();
		stack2.initStack();
		Stack stack8 = new Stack();
		stack8.initStack();
		StringBuilder sb = new StringBuilder();
		String chars = "10110110";
		// �������η��������ջ
		for (int i = 0; i < chars.length(); i++) {
			System.out.println(chars.charAt(i));
			stack2.push(chars.charAt(i));
		}
		while (stack2.stackLen() > 0) {
			while (stack2.stackLen() > 0 && pos > 0) {
				sb.insert(0, stack2.pop());
				pos--;
			}
			int res = TzhaunT(sb.toString());
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
			System.out.println(res + "++++++");
			stack8.push((char) (res + 48));
			pos = 3;
		}
		int len = stack8.stackLen();
		for (int k = 0; k < len; k++) {
			System.out.print(stack8.pop());
		}

	}

	/*
	 * ������תʮ�����Ʒ���
	 */
	public void TzhuanS() {
		char[] ints = { 'A', 'B', 'C', 'D', 'E', 'F' };
		int pos = 4;
		Stack stack2 = new Stack();
		stack2.initStack();
		Stack stack16 = new Stack();
		stack16.initStack();
		StringBuilder sb = new StringBuilder();
		String chars = "101101110";
		// �������η��������ջ
		for (int i = 0; i < chars.length(); i++) {
			System.out.println(chars.charAt(i));
			stack2.push(chars.charAt(i));
		}
		while (stack2.stackLen() > 0) {
			while (stack2.stackLen() > 0 && pos > 0) {
				sb.insert(0, stack2.pop());
				pos--;
			}
			int res = TzhaunT(sb.toString());
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
			System.out.println(res + "++++++");
			if (res > 9) {
				stack16.push(ints[res - 10]);
			} else {
				stack16.push((char) (res + 48));
			}
			pos = 4;
		}
		int len = stack16.stackLen();
		for (int k = 0; k < len; k++) {
			System.out.print(stack16.pop());
		}

	}

	/*
	 * �沨�����ʽ�ı�ʾ����
	 */
	public void InversePolishExpression() {
		Stack stack = new Stack();
		stack.initStack();
		// �������ʽ
		String Expression = "12-45+*";
		for (int i = 0; i < Expression.length(); i++) {
			char y = Expression.charAt(i);
			// ��Ϊ������ѹջ
			// ��Ϊ������ȡ��
			if (y <= '9' && y >= '1') {
				stack.push(y);
			} else {
				char symbol = y;
				int i1 = stack.pop() - 48;
				int i2 = stack.pop() - 48;
				stack.push((char) (panduan(symbol, i1, i2) + 48));
			}

		}
		System.out.println(stack.pop());
	}

	public int panduan(char symbol, int i1, int i2) {
		int result = 0;
		switch (symbol) {
		case '+':
			result = i1 + i2;
			break;
		case '-':
			result = i1 - i2;
			break;
		case '*':
			result = i1 * i2;
			break;
		case '/':
			result = i1 / i2;
			break;
		}
		return result;
	}

	/*
	 * ��׺���ʽתΪ��׺���ʽ
	 */
	public LinkedList<String> ZzhaunH(LinkedList<String> strs) {
//		StringBuilder stringBuilder = new StringBuilder();
		LinkedList<String>  results = new LinkedList<>();
		Stack stack = new Stack();
		stack.initStack();
		// ѭ��������׺���ʽ
		for (int i = 0; i < strs.size(); i++) {
			String sym = strs.get(i);
			// ��Ϊ������
			if (sym.equals(")")) {
				// �����ݵ���ջ
				char e = stack.pop();
				// ������������ݲ���������
				while (e != '(') {
//					stringBuilder.append(e);
					results.add(String.valueOf(e));
					e = stack.pop();
				}
			} else if (sym.equals("+") || sym.equals("-")) {
				if (stack.stackLen() == 0) {
					stack.push(sym.charAt(0));
				} else {
					char p;
					do {
						// ����ջ��Ԫ��
						p = stack.pop();
						if ('(' == p) {
							stack.push(p);
						} else {
//							stringBuilder.append(p);
							results.add(String.valueOf(p));
						}
					} while (stack.stackLen() > 0 && p != '(');
					stack.push(sym.charAt(0));
				}
			} else if (sym.equals("*") || sym.equals("/") || sym.equals("(")) {
				stack.push(sym.charAt(0));
			} else {
//				stringBuilder.append(sym);
				results.add(sym);
			}
		}
		System.out.println(stack.stackLen() + "����");
		int len = stack.stackLen();
		for (int i = 0; i < len; i++) {
			char a = stack.pop();
			System.out.println(a);
//			stringBuilder.append(a);
			results.add(String.valueOf(a));
		}
//		return stringBuilder.toString();
		return results;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.initStack();
		LinkedList<String> strs = new LinkedList<>();
		strs.add("1");
		strs.add("*");
		strs.add("2");
		strs.add("+");
		strs.add("(");
		strs.add("3");
		strs.add("*");
		strs.add("4");
		strs.add("+");
		strs.add("2");
		strs.add(")");
		strs.add("+");
		strs.add("2");
		System.out.println(strs.toString());
		System.out.println(stack.ZzhaunH(strs));

	}
	// public static void main(String[] args) {
	// System.out.println(Math.scalb(3, 2));
	// System.out.println('1' - 48);
	// System.out.println((char) (1 + 48));
	// Stack stack = new Stack();
	// stack.TzhuanS();
	// stack.InversePolishExpression();
	// stack.TzhaunT("11001001");
	// stack.initStack();
	//
	// stack.push('a');
	// stack.push('b');
	// stack.push('c');
	// stack.push('d');
	//
	// System.out.println(stack.stackLen()+"---");
	// System.out.println(stack.pop());
	// System.out.println(stack.pop());
	// System.out.println(stack.stackLen()+"---");
	// stack.push('e');
	// System.out.println(stack.stackLen()+"---");
	// System.out.println(stack.pop());
	// System.out.println(stack.pop());
	// System.out.println(stack.stackLen()+"---");
	//
	// stack.destoryStack();
	// System.out.println(stack.stackLen()+"---");
	// }

}
