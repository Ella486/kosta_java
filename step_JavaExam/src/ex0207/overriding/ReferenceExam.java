package ex0207.overriding;

class ObjectExam{ //object ���(��� �޼ҵ带 �����Ӱ� ����� �� �ִ�.)
	String str;
	
	public ObjectExam(){ 
		
		
	}
	public ObjectExam(String str){ //��ü�� ������ �� ���޵Ǵ� ���ڿ�
		this.str = str;
	}

	@Override  //annoation
	public String toString() {
		//return "�������ְ�!";
		//return this.str; //this.���� ����
		return this.str + "|" + super.toString();// ���⼭ super�� �����ϸ� �ȵ� ������ ���� loop ����
	}
	
	
}

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="������"; 
			String s02="Java";
			
			String s03=new String("������");
			
			ObjectExam oe1=new ObjectExam("������ ������");
			ObjectExam oe2=new ObjectExam("�ȳ�");
			
			
			/**
			 * println(Object obj) �Ǵ� print(Object obj) �޼ҵ��
			 *  �μ��� ���޵� obj.toString() ������ ȣ���ϰ� �� ����� ������ش�.
			 *  
			 *  Object�� ���ǵǾ� �ִ� toString()�޼ҵ�� class�̸�@hashcode ���·� ���ڿ��� ���� �������ش�
			 */
			
			System.out.println(c);//a
			System.out.println(s01.toString());//"������" // �ּҰ��� �ȳ����� ������ �����ǵǾ
			System.out.println(s02.toString());//"Java"
			System.out.println(s03.toString());//"������"
			
			System.out.println(oe1.toString());//�ּҰ� - Object�� ���ǵǾ� �ִ� toString() ȣ��
			System.out.println(oe2.toString());//�ּҰ�

			System.out.println("=======");
			
			
			
			
	}
}
