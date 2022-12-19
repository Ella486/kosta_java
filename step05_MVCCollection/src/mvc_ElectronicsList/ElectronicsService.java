package mvc_ElectronicsList;

import java.util.ArrayList;
import java.util.List;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

class ElectronicsService {
    String [][] data = new String [][]{
		{"100","선풍기","35000","삼성 선풍기"},
		{"200","전자렌지","55000","잘 데워져요.."},
		{"300","에어컨","5500000","무풍 에어컨 너무 시원해"},
		{"400","냉장고","800000","LG 냉장고"},
		{"500","드라이기","9000","LG 드라이기"}
	}; // 최초의 초기치 데이터를 준비!! electronics에 저장 

	
    private static ElectronicsService instance = new ElectronicsService(); // 16번째줄로감 

    //public static int count; // 배열방에 저장된 전자제품의 개수를 체크!!

    //Electronics elecArr []; // 공간생성
    
    List<Electronics> list = new ArrayList<Electronics>();

    /** 
     * 외부에서 객체 생성안됨. 
     */
    private ElectronicsService() {
        // 데이터 초기화(전자제품 초기치 데이터) 하자.
        //elecArr = new Electronics[10]; 
    	
        for(int i=0; i<data.length; i++) {
        	list.add(new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]), data[i][3])); // 데이터 초기화 
           
        	//ElectronicsService.count++;
        }
      
    }

    /**
     * 현재 객체를 리턴해준다.
     * @return
     */
    public static ElectronicsService getInstance() {

        return instance;
    }

    /**
     * 전자제품 등록
     * return : true이면 등록성공, false이면 등록실패 
     * @param electronics
     * @return
     */
    public boolean insert(Electronics electronics) {

        // 배열의 길이가 벗어났는지만 체크하고 
    	//System.out.println("size"+list.size()+" / count"+ ElectronicsService.count);
        if(list.size() == 10) {//최대 10개까지만 저장하자!! 라는 시나리오가 있다는 가정하에...
        	//System.out.println("저장할 공간이 없습니다.");
            return false;
        }else {
	        list.add(electronics);
	       // ElectronicsService.count++;
	        return true;
        }
        
    }

    /**
     * 등록된 전체 전자제품 검색 
     * @return
     */
    public List<Electronics> selectAll() {
        return list;
    }

    /**
     * 모델번호에 해당하는 전자제품 검색 
     * @param modelNo
     * @return
     */
    public Electronics searchByModelNo(int modelNo) {
        /*for(int i=0; i < list.size() ; i++) {
        	Electronics elec = list.get(i);
            if(elec.getModelNo() == modelNo ){
                return elec;
            }
        }*/
    	
        //개선된 for로 변경
        for(Electronics elec : list) {
        	if(elec.getModelNo() == modelNo ){
                return elec;
            }
        }

        return null ;
    }


    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * (설명만 수정한다)
     * @param electronics
     * @return
     */
    public boolean update(Electronics electronics) {
		//인수로 전달된 모델번호에 해당하는 전자제품이 있는지 검색한다.
        Electronics dbElectronics = this.searchByModelNo(electronics.getModelNo());

        if(dbElectronics != null) { //찾았다!
            dbElectronics.setModelDetail( electronics.getModelDetail()  );
            return true;
        }

        return false;
    }


    
} // 클래스 끝 