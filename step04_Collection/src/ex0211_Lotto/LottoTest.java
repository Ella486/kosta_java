package ex0211_Lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTest {
	List<Integer> lottoList = new ArrayList<Integer>();
	//int lotto [] = new int [6];//0
    //int cnt=0;//배열방에 중복없이 숫자가 들어간 개수.
    /**
     * 로또 번호 한개 생성하여 기존 로또번호와 비교하여 같으면 다시 생성.
     * */
    public void createLottoNo(){		
		while(lottoList.size() < 6){//1
			 int lottoNo = (int)(Math.random()*45)+1;//5
//			 if(  this.isCompareNo(lottoNo) ){
//				 lotto[cnt] = lottoNo;
//				 cnt++;
//			 }
			 
			 if(this.isCompareNo(lottoNo)) {//true일때만 추가
				 lottoList.add(lottoNo);
				 //cnt++;
			 }
		}

        //System.out.println("중복없이 추가완료 : " + Arrays.toString(lotto));
        System.out.println("중복없이 추가완료 : " + lottoList.toString());

    } 
    /**
     * 로또번호 비교하는 부분
	    return : true : 중복아님, false이면 중복 * */
    public boolean isCompareNo(int lottoNo ){
    	for(int i=0; i < lottoList.size() ; i++){
//    		if(lotto[i] == lottoNo ){
//    		  return false;// 함수(메소드)를 빠져나가라.
//    		}
    		if(lottoList.get(i)==lottoNo) {
    			return false;
    		}
    	}
    	return true;   	
    }
    
    
    /**
     * 완성된 6개 번호 정렬하기
     * */
     public void lottoSort(){
			//버블정렬방식 : 인접해 있는 데이터를 비교해서 큰값을 오른쪽 배치
		//int temp=0;//임시공간변수
		//int len = lotto.length-1;
		//int len = lottoList.size();
		Collections.sort(lottoList);//리스트 오름차순 정렬
//		for(int i = len ; i > 0 ; i--){// 
//			for(int j=0; j< i; j++){//
//				if(lotto[j] > lotto[j+1]){ 
//					temp = lotto[j];
//					lotto[j] = lotto[j+1];
//					lotto[j+1] = temp;
//				}
//				}
//			}
//		}
     }
     

     /**
      * 출력하는 메소드
      * */
     public void printLotto(){
     	//출력
//		for(int i=0; i< lotto.length ; i++){
//     		System.out.print(lotto[i]+"\t");
//     	}
    	 System.out.println("출력 : ");
 		for(int i=0; i< lottoList.size() ; i++){
    	 	//lottoList.sort(null);
     		System.out.print(lottoList.get(i)+"\t");
     	}
     }
	
	public static void main(String[] args) {
		LottoTest lotto = new LottoTest();
		lotto.createLottoNo();
		System.out.println("--정렬하자 ----");

		lotto.lottoSort();
		lotto.printLotto();

	}
	

}
