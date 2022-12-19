package mvc_ElectronicsList;

import java.util.List;

/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

class ElectronicsController {
    private ElectronicsService service = ElectronicsService.getInstance(); // null 

    /**
     * 전체검색
     */
    public void selectAll() {
		// Electronics[] elecArr = service.selectAll();
    	List<Electronics> list = service.selectAll();

        EndView.printAll(list);
    }
 

	 /**
     * 전자제품 등록 
     */
   
    public void insert(Electronics electronics) {
        // 등록전에 중복여부를 체크하고 중복이 아니면 등록한다.
        Electronics savedElec = service.searchByModelNo(electronics.getModelNo());
        if(savedElec==null) {
            if(service.insert(electronics)) {
                EndView.printMessage("등록되었습니다.");
            }
            else {//저장실패(공간을 없을을 의미할 수도 있지.
            
                EndView.printMessage("등록되지않았습니다.");
            }
        }
        else {
            EndView.printMessage(electronics.getModelNo() + "는 중복이므로 등록할 수 없습니다.");
        }

    }

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
		Electronics electronics = service.searchByModelNo(modelNo);
        if(electronics==null){
            EndView.printMessage(modelNo+"는 없는 모델번호로 검색할수 없습니다.");
		}else{
           EndView.printSearchByModelNo(electronics);
		}
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
        boolean result = service.update(electronics);
        if(result) {
            EndView.printMessage(electronics.getModelNo() + "에 해당하는 상품 정보가 수정되었습니다.");
        }
        else {
            EndView.printMessage("수정되지 않았습니다.");
        }

    }

    
}
