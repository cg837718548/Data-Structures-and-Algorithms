package LinearTable.sequential;

public class seqTest {

	public static void main(String[] args) {
		Sequential sequential = new Sequential();
		//���Ա��ʼ��
		sequential.initList();
		
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		System.out.println("���Ա��������"+sequential.getMaxSize());
		System.out.println("---------------------");
		
		sequential.insertElem(1, 1);
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		System.out.println("---------------------");
		
		sequential.insertElem(2, 2);
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		System.out.println("---------------------");
		
		sequential.insertElem(3, 3);
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		System.out.println("---------------------");
		
		sequential.insertElem(4, 2);
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		
		for(int i=1;i<=sequential.getLength();i++){
			System.out.println(sequential.getElem(i));
		}
		System.out.println("---------------------");
		
//		sequential.getElem(4);
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		for(int i=1;i<=sequential.getLength();i++){
			System.out.println(sequential.getElem(i));
		}
		System.out.println("---------------------");
		
		
		System.out.println(sequential.locateElem(6));
		System.out.println(sequential.getElem(7));
		System.out.println("++++++++++++++");
		
		sequential.deleteElem(1);
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		for(int i=1;i<=sequential.getLength();i++){
			System.out.println(sequential.getElem(i));
		}
		System.out.println("---------------------");
		
		sequential.clearSeq();
		System.out.println("���Ա�ĳ��ȣ�"+sequential.Length());
		System.out.println("���Ա��Ƿ�Ϊ�ձ�"+sequential.isEmpty());
		System.out.println("---------------------");
		
	}
	
	
}
