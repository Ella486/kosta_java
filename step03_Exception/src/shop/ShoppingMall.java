package shop;

public class ShoppingMall {
	
	public void enter(int age) throws AgeCheckException {
		if(age>18) {
			System.out.println("입장 하신걸 환영합니다");
		}else {
			AgeCheckException ae = new AgeCheckException("애들은 가라");
			throw ae;
		}
	}

}
