package Stack.sequentialStack;

import java.util.LinkedList;

public class jisuanqiTest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		Stack2 stack2 = new Stack2();
		
		stack.initStack();
		stack2.initStack();
		
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
		stack2.InversePolishExpression2(stack.ZzhaunH(strs));
	}
}
