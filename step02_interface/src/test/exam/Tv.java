package test.exam;

public class Tv extends Elec implements ElecFunction {
	
	private int chnnel;
	
	public Tv() {
		
	}

	
	public Tv(int chnnel) {
		
		
	}


	public Tv(String code, int cost, int chnnel) {
		super(code, cost);
		//this.setCode(code);
		//this.setCost(cost);
		this.chnnel = chnnel;
	}

	@Override
	public void start() {
		
		String className = super.getClass().getSimpleName();
		
		System.out.println(super.getCode()+"의 제품" + className + "를 "+chnnel+"을 본다");

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
		
		builder.append("[chnnel =");
		builder.append(chnnel);
		builder.append("]");
		
		return builder.toString();
	}

}
