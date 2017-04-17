package LinearTable.CircularList;

public class LatinSquare extends CircleList {

	public void latin(){
		initList();
		Node target ;
		Node temp = getFirst();
		Node temp2 = getFirst();
		while(temp2.getNext()!=temp){
			for(target = getFirst();target.getNext()!=temp2;target = target.getNext()){
				System.out.print(target.getData()+"   ");
			}
			System.out.print(target.getData());
			System.out.println();
			setFirst(temp2.getNext());
			temp2 = temp2.getNext();
		}
		for(target = getFirst();target.getNext()!=temp2;target = target.getNext()){
			System.out.print(target.getData()+"   ");
		}
		System.out.print(target.getData());
	}
	public static void main(String[] args) {
		LatinSquare square = new LatinSquare();
		square.latin();
	}
}
