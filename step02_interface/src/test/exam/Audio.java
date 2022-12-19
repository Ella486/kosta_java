package test.exam;

public class Audio extends Elec implements ElecFunction {
	private int volumn;
	
	public Audio() {
		
	}
	
	public Audio(int volumn) {
		//super();
		this.volumn = volumn;
		
	}
	
	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		//this.setCode(code);
		//this.setCost(cost);
		this.volumn = volumn;
		
	}
	
	
	@Override
	public void start() {
		//현재 객체의 클래스 이름을 가져오기
		String className = super.getClass().getSimpleName();
		
		System.out.println(super.getCode()+"의 "+ className + "를 "+volumn+"으로 듣는다");

	}

	@Override
	public void stop() {
		

	}

	@Override
	public void display() {
		

	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("[volumn =");
		builder.append(volumn);
		builder.append("]");
		
		return builder.toString();
	}

}
