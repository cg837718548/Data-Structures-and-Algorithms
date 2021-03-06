package figure.neighborhoodTable.nodirection;

import java.util.LinkedList;
import java.util.List;

/**
 * 无方向邻接表测试类
 * 
 * @author 83771
 *
 */
public class TestMain {

	public static void main(String[] args) {
		TableYuansu yuansu1 = new TableYuansu("1111");
		TableYuansu yuansu2 = new TableYuansu("1112");
		TableYuansu yuansu3 = new TableYuansu("1113");
		TableYuansu yuansu4 = new TableYuansu("1114");
		TableYuansu yuansu5 = new TableYuansu("1115");
		List<TableYuansu> lists = new LinkedList<>();
		lists.add(yuansu1);
		lists.add(yuansu2);
		lists.add(yuansu3);
		lists.add(yuansu4);
		lists.add(yuansu5);
		Table table = new Table();
		 table.initTable(lists);
		 
		 table.setConnet(yuansu1, yuansu5);
		 table.setConnet(yuansu2, yuansu4);
		 table.setConnet(yuansu3, yuansu2);
		 
		 table.outputAll();
		 
	}
}
