package ex0207.overriding;

class ObjectExam{ //object 상속(모든 메소드를 자유롭게 사용할 수 있다.)
	String str;
	
	public ObjectExam(){ 
		
		
	}
	public ObjectExam(String str){ //객체가 생성될 때 전달되는 문자열
		this.str = str;
	}

	@Override  //annoation
	public String toString() {
		//return "장희정최고!";
		//return this.str; //this.생략 가능
		return this.str + "|" + super.toString();// 여기서 super는 생략하면 안됨 생략시 무한 loop 돌음
	}
	
	
}

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			
			String s03=new String("월요일");
			
			ObjectExam oe1=new ObjectExam("숙제는 열심히");
			ObjectExam oe2=new ObjectExam("안녕");
			
			
			/**
			 * println(Object obj) 또는 print(Object obj) 메소드는
			 *  인수로 전달된 obj.toString() 무조건 호출하고 그 결과를 출력해준다.
			 *  
			 *  Object에 정의되어 있는 toString()메소드는 class이름@hashcode 형태로 문자열로 만들어서 리턴해준다
			 */
			
			System.out.println(c);//a
			System.out.println(s01.toString());//"장희정" // 주소값이 안나오는 이유는 재정의되어서
			System.out.println(s02.toString());//"Java"
			System.out.println(s03.toString());//"월요일"
			
			System.out.println(oe1.toString());//주소값 - Object에 정의되어 있는 toString() 호출
			System.out.println(oe2.toString());//주소값

			System.out.println("=======");
			
			
			
			
	}
}
