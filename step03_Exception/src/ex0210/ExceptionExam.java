package ex0210;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("*************메인시작**************");
		try {
		String data = args[0]; //ArrayIndexOutOfBoundsException
		System.out.println("data =" + data);
		
		int no = Integer.parseInt(data);
		System.out.println("숫자로 변화:" + no);
		
		int result = 100/no;
		System.out.println("나눈결과:" + result);
		
		}catch(ArrayIndexOutOfBoundsException e) {// e는 변수 : 예외에 관련된 정보를 갖고 있는 레퍼런스변수
			//예외가 발생했을 때 해야 할 일작성!
			System.out.println("실행할 때 값을 전달해주세요~~");
			System.out.println("e =" + e);//e.toString()호출 - 예외클래스이름: 예외메세지
			
		}catch(NumberFormatException  | NullPointerException e) { //예외처리를 두개 동시에 하고 싶을때 사용함 but, 변수는 하나만 사용
			System.out.println("숫자만 입력해주세요....");
			System.out.println("예외메세지 : " + e.getMessage());
		}catch(Exception e) { //다형성 이용!
			System.out.println("예외가 발생했어요~~");
			
			//오류의 정보가 가장 detail하게 나오고 오류정보를 추적할 때 사용한다.(개발할 때 많이 사용하지만 배포할 때는 삭제필수,보안필수)
			e.printStackTrace(); // 발생한 예외의 정보를 stack영역에 쌓아놓았다가 한번에 출력한다.
			
		}finally {
			System.out.println("예외발생 여부와 상관없이 난 무조건 일해요~~");
			System.out.println("*************메인끝**************");
		}
		
		
		
	}

}
