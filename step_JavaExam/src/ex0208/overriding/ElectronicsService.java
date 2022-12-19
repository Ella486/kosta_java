package ex0208.overriding;
/** 
	전자제품에 관련된 기능을 담당할 클래스
*/

class ElectronicsService {
	public static int count = 0; //배열 방에 저장된 제품의 개수를 체크!
	String [][] data = new String [][]{//최초의 초기치 데이터를 준비
		{"200","선풍기","35000","삼성 선풍기"},
		{"500","전자렌지","55000","잘 데워져요.."},
		{"300","에어컨","5500000","무풍 에어컨 너무 시원해"},
		{"100","냉장고","800000","LG 냉장고"},
		{"400","드라이기","9000","LG 드라이기"}
	}; 

	private static ElectronicsService instance = new ElectronicsService(); //정적필드  //singleton :단 하나의 객체만 생성

	Electronics elecArr [] ;//공간 생성

	
	/**
    외부에서 객체 생성안됨.
	*/
	private ElectronicsService(){//생성자 (대문자로이름)
		//데이터 초기화(전자제품 초기치 데이터)하자.
		elecArr = new Electronics[10];
			
		for (int i=0 ; i< data.length ; i++ ){
		
			elecArr[i] = // Electronics 배열방의 주소값
				new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]),data[i][3]);//데이터 초기화
			
			ElectronicsService.count++;
		}

		/*System.out.println("------------------------");
		for (int i=0 ; i< ElectronicsService.count ; i++){
			System.out.println( elecArr[i] + "|" + elecArr[i].getModelNo() + "|"+ elecArr[i].getModelName());

		}
		System.out.println("------------------------"); */  //배열방에 5개의 전자제품이 들어왔는지 확인

	}
	/**
		현재 객체를 리턴
	*/
	public static ElectronicsService getInstance(){//정적메소드


		return instance; // instance는  new ElectronicsService() 을 의미함.
	}
	
	/**
		전자제품 등록
		return : true이면 등록성공, false이면 등록실패
	*/
	public boolean insert (Electronics electronics){
		if(elecArr.length == ElectronicsService.count){
		return false;
		}
		elecArr[ElectronicsService.count++] = electronics;

		return true;
	}

	/**
		등록된 전체 전자제품 검색
	*/

	public Electronics [] selectAll(){ //객체 타입: Electronics []

		return elecArr;

	}

	/**
		모델번호에 해당하는 전자제품 검색
	*/

	public Electronics searchByModelNo(int modelNo){
		for (int i=0 ;i< ElectronicsService.count ; i++){
				Electronics electronics = elecArr[i];
				if (electronics.getModelNo() == modelNo){ //같으면 찾았다 있다.//이건 대소문자 구분해서 코드를 써줘야함
					return electronics;
				}
				
			}
		return null;
		
	}
	/**
		모델번호에 해당하는 전자제품 수정하기
	*/
	public boolean update(Electronics electronics){
			//인수로 전달된 모델번호에 해당하는 전자제품이 있는지 검색한다.
			Electronics dbElec = this.searchByModelNo(electronics.getModelNo());

			if(dbElec != null){//찾았다, 존재한다.
				//전달된 값으로 저장된 값은 변경한다
				
				dbElec.setModelDetail(electronics.getModelDetail());
				return true;
			}

			return false;
	}

	/**
     상품 지우기
     */
    public boolean deleteByModelNo(int modelNo) {
		
       
        for (int i = 0; i < count; i++) {
            Electronics electronics = elecArr[i];
            if (electronics.getModelNo() == modelNo) { //삭제하려는 상품을 찾아서 같으면 
                int j = i;
                for (; j < count - 1; j++) { // 앞으로 한칸씩
                    elecArr[j] = elecArr[j + 1];
                }

                elecArr[j] = null;
                count--; //삭제가 되면 저장된 객체의 수를 감소한다.
                return true;
            }
        }
        return false;
    }

	/**
     항목을 오름차순 정렬
    */
    public Electronics[] selectAllSortBy(String by) { //모델번호, 이름, 가격

		switch (by) {
            case "모델번호":
            case "이름":
            case "가격":
                sortByAscending( by); //this. 생략 같은 클래스 내에 있는 메소드 호출이라서
                break;
            default:
                return null;
        }
        return elecArr;
    }


    /**
	    String 객체 안에 있는  int re = .compareTo(String s)  메소드
		  : 두개의 문자열을 비교한다. : 어떤 문자가 순서로 앞에 오는지 리턴해주는 메소드 

		      리턴값 :   0    : 두문자열이 같다.
			            양수 :  호출하는 객체가 인자보다 순서 앞에 있을때 : 
						음수 :  인수가 객체보다 순서 앞에 있을때 

	*/

    public void sortByAscending( String by) {

        // 선택정렬
        for (int i = 0; i < ElectronicsService.count; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ElectronicsService.count; j++) {

                if (by.equals("모델번호")) {
                    int selected = elecArr[j].getModelNo();
                    if (selected < elecArr[minIndex].getModelNo()) {
                        minIndex = j;
                    }
                } else if (by.equals("이름")) {
                    String selected = elecArr[j].getModelName();
                    if (elecArr[minIndex].getModelName().compareTo(selected) > 0) { //양수니 
                        minIndex = j;
                    }
                } else {
                    int selected = elecArr[j].getModelPrice();
                    if (selected < elecArr[minIndex].getModelPrice()) {
                        minIndex = j;
                    }
                }

            }

            swapElectronics(i, minIndex);
        }
    }


    public void swapElectronics(int i, int j) {

        Electronics tmp = elecArr[i];
        elecArr[i] = elecArr[j];
        elecArr[j] = tmp;
    }

}// 클래스 끝
