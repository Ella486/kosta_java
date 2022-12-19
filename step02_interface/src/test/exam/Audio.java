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
		//���� ��ü�� Ŭ���� �̸��� ��������
		String className = super.getClass().getSimpleName();
		
		System.out.println(super.getCode()+"�� "+ className + "�� "+volumn+"���� ��´�");

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
