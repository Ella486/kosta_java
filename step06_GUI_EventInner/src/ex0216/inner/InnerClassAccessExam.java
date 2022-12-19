package ex0216.inner;
/**
 *  Inner클래스는 선언위치와 선언 방법 에 따라 3가지 형태가 존재한다.
     1) 인스턴스 맴버클래스
           class A{
                class B{ }
           }
     2) 정적(static) 맴버클래스 
           class A{
               static class B{ }
            }

     3) 로컬(메소드 내부에서 선언된) 클래스
             class A{
                   public void aa(){
                          class B{  }
                   }
             }
 * */

class Test{//Outer 클래스 역할
	int a =50;
	static int b=100;
	
	public void aa() {}
	public static void bb() {}
	
	///1)인스턴스 맴버클래스/////////////////////////////////
	/**
	 * : 클래스 앞에 access modifier 4가지 모두 가능함 
	 * : non-static 선언가능하지만, static 선언 안됨!! -JDK version 16부터는 가능
	 * : non-static, static 모든 접근 = 호출 가능!
	 * */
	class InstanceInner{
		int a=10;
		//static int c=50; //static 선언불가
		public void test() {
			System.out.println(a);//10
			System.out.println(this.a);//10
			System.out.println(Test.this.a);//50
			
			System.out.println(b); //100    //static 접근가능
			
			aa();
			bb();
		}
		
		/*public static void test2() { //static 선언불가
			
		}*/
	}//InstanceInner END
/////////////////////////////////////////////////
	/**
	 * 정적(static) 맴버클래스 
	 * : 클래스 앞에 access modifier 4가지 모두 가능함
	 * : non-static , static 둘다 선언 가능
	 * : Outer 클래스의 non-static 접근 불가, static만 접근 가능
	 * : static inner 클래스를 사용할 때 Outer클래스의 생성없이 바로 접근 가능
	 * */
	public static class StaticInner{
		int a =10;
		static int c=4;
		
		public void test1() {
			System.out.println(a);//10
			System.out.println(this.a);//10
			//System.out.println(Test.this.a); //non-static 접근 불가
			
			System.out.println(b); //100
			//System.out.println(this.b); //StaticInner 안에 b가 없음
			//System.out.println(Test.this.b);
			
			System.out.println(Test.b); //100   //static은 클래스 이름. 으로 접근하기 때문
			
			//aa(); non-static 접근 불가
			bb();
			
		}
		public static void test02() {}
		
	}//StaticInner End
	
	/**
	 * 로컬(메소드 내부에서 선언된) 클래스
	 * : 접근제한자, static 은 클래스 앞에 올 수 없다.
	 * */
	public void localInnerTest() {
		System.out.println("--------------localInnerTest()메소드 입니다.-------------------");
		
		class LocalInner{
			int a=7;
			//static int c=4;
			
			public void test() {
				System.out.println("LocalInner 안에 test()메소드 입니다.");
			}
			
		}//LocalInner END
		
		LocalInner local = new LocalInner();
		local.test();
		
	}//메소드 끝
	
	
	
	
}//TestEnd




////////////////////////////////////////////////////
public class InnerClassAccessExam {

	public static void main(String[] args) {
		System.out.println("*******1)인스턴스 맴버클래스**********");
		Test t = new Test();
		Test.InstanceInner testInstance = t.new InstanceInner(); //inner 클래스 생성방법
		testInstance.test();
		
		System.out.println("*******2) 정적(static) 맴버클래스 **********");
		Test.StaticInner tis = new Test.StaticInner();
		tis.test1();
		
		System.out.println("******* 3) 로컬(메소드 내부에서 선언된) 클래스**********");
		t.localInnerTest(); //메소드 호출 //위쪽에 이미 Test t = new Test(); 했음.
		
	}

}
