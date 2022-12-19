package mvc_ElectronicsList;

import java.util.List;

/**
 * 사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스 
 */

class EndView {

    /**
     * 전달된 배열을 출력(전체 검색 결과)
     * @param electronics
     */
    public static void printAll(List<Electronics> list){
		System.out.println("****** 전자제품 총 ("+list.size()+")개 *****************");
        for(Electronics elec : list) {
           System.out.println(elec);
        }

		System.out.println();
    }

    // 모델번호에 해당하는 전제제품 출력하기
    public static void printSearchByModelNo(Electronics electronics) {
        System.out.println(electronics +"\n");
    }

    /**
     * 성공 여부에 관련된 메세지 출력 
     * @param message
     */
    public static void printMessage(String message) {
         System.out.println(message+"\n");
    }

    
}
