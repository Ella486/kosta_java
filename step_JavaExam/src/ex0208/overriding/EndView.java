package ex0208.overriding;
/**
	사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스
*/

class EndView {//EndView 클래스에 있는 메소드는 다 static이 붙어있어서 메소드 호출시 --> 클래스이름.메소드이름(); 

	/**
		전달된 배열을 출력(전체 검색 결과)
	*/

	public static void printAll(Electronics[] elecArr){

		System.out.println("*******상품 LIST ("+ ElectronicsService.count +") 개 ********");
												//전역변수 앞에 static이 붙어있으면 외부에서 객체생성없이 --> 클래스이름.변수이름 으로 호출가능

		//출력해주세요
		for (int i=0; i<ElectronicsService.count ; i++ ){
							//parameter(인수) 값이 elecArr[] 로 받기 때문에 System.out.print에서 쓰는 것 가능
				System.out.print(elecArr[i].getModelNo() + " | ");
				System.out.print(elecArr[i].getModelName() + " | ");
				System.out.print(elecArr[i].getModelPrice() + " | ");
				System.out.print(elecArr[i].getModelDetail() + " \n ");
				
				
		}


	}
	
	/**
		모델번호에 해당하는 전자제품 출력
	*/

	public static void printSearchByModelNo(Electronics electronics){
		System.out.println("--------"+electronics.getModelNo() +"에 해당하는 정보--------------");
	   //정보 출력해주세요
	   System.out.print( electronics.getModelNo() +" | ");
	   System.out.print( electronics.getModelName() +" | ");
	   System.out.print( electronics.getModelPrice() +" | ");
	   System.out.print( electronics.getModelDetail() +"\n");
	   //System.out.println(electronics);//toString 메소드

	}


	/**
	성공여부에 관련된 메세지 출력
	*/

	public static void printMessage(String message){
		System.out.println(message+"\n");

	}


}
