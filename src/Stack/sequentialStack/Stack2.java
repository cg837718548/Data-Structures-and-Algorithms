package Stack.sequentialStack;

import java.util.LinkedList;
import java.util.List;

/**
 * 定义一个栈
 * 
 * @author 83771
 *
 */
public class Stack2 {
	private static final int MaxSize = 3;
	private static final int Increment = 3;

	// 栈顶的值
	private Integer[] topData;
	// 栈底指针
	private int base;
	// 栈顶指针
	private int top;
	// 栈的容量
	private int stackSize;


	public Integer[] getTopData() {
		return topData;
	}

	public void setTopData(Integer[] topData) {
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
	 * 初始化一个栈
	 */
	public void initStack() {
		this.top = this.base = 1;
		this.stackSize = MaxSize;
		this.topData = new Integer[MaxSize];
	}

	/*
	 * 当容量不够时 增容
	 */
	public void expend() {

		Integer[] larger = new Integer[stackSize + Increment];
		for (int i = 0; i < top - 1; i++) {
			larger[i] = topData[i];
		}
		topData = larger;
		stackSize = stackSize + Increment;
	}

	/*
	 * 入栈操作
	 */
	public void push(int data) {
		// 如果栈满，则追加空间
		if (this.top - this.base >= stackSize) {
			this.top = this.base + stackSize;
			expend();
		}
		this.topData[top - 1] = data;
		this.top++;
	}

	/*
	 * 出栈操作
	 */
	public Integer pop() {
		if (this.top == this.base) {
			return null;
		}
		top--;
		int r = this.topData[top - 1];
		topData[top - 1] = null;
		return r;
	}

	/*
	 * 清空一个栈
	 */

	public void clearStack() {
		this.top = this.base;
	}

	/*
	 * 销毁一个栈
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
	 * 计算当前栈的容量
	 */
	public int stackLen() {
		return this.top - this.base;
	}

	/*
	 * 逆波兰表达式的表示方法
	 */
	public void InversePolishExpression() {
		Stack2 stack = new Stack2();
		stack.initStack();
		// 声明表达式
		String Expression = "123-4*+";
		for (int i = 0; i < Expression.length(); i++) {
			char y = Expression.charAt(i);
			// 若为数字则压栈
			// 若为符号则取出
			if (y <= '9' && y >= '1') {
				stack.push(y-48);
			} else {
				char symbol = y;
				int i1 = stack.pop() ;
				int i2 = stack.pop() ;
				stack.push(panduan(symbol, i2, i1));
			}

		}
		if(stack.stackLen()>1){
			System.err.println("此逆波兰表达式不正确");
			return;
		}
		System.out.println(stack.pop());
	}
	
	/*
	 * 逆波兰表达式的表示方法(升级版)
	 */
	public void InversePolishExpression2(List< String> strs) {
		Stack2 stack = new Stack2();
		stack.initStack();
		// 声明表达式
//		String Expression = "123-4*+";
//		List< String> strs = new LinkedList<>();
		for (int i = 0; i < strs.size(); i++) {
			String y = strs.get(i);
			// 若为数字则压栈
			// 若为符号则取出
			if (y.equals("+")||y.equals("-")||y.equals("*")||y.equals("/")) {
				String symbol = y;
				int i1 = stack.pop() ;
				int i2 = stack.pop() ;
				stack.push(panduan(symbol.charAt(0), i2, i1));
			} else {
				stack.push(Integer.parseInt(y));
			}

		}
		if(stack.stackLen()>1){
			System.err.println("此逆波兰表达式不正确");
			return;
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
	
	public static void main(String[] args) {
		Stack2 stack2 = new Stack2();
		stack2.initStack();
		LinkedList<String> strs = new LinkedList<>();
		strs.add("1");
		strs.add("2");
		strs.add("3");
		strs.add("-");
		strs.add("4");
		strs.add("*");
		strs.add("+");
		strs.add("10");
		strs.add("5");
		strs.add("/");
		strs.add("+");
		stack2.InversePolishExpression2(strs);
		stack2.InversePolishExpression();
	}
//	public static void main(String[] args) {
		// System.out.println(Math.scalb(3, 2));
//		System.out.println('1' - 48);
//		System.out.println((char) (1 + 48));
//		System.out.println(Integer.parseInt("12"));
//		Stack2 stack = new Stack2();
//		stack.TzhuanS();
//		stack.InversePolishExpression();
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
//	}

}
