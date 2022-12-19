package kosta.eaxm.model.dto;

public class FreeBoard extends Board {
	private String etc;
	
	public FreeBoard() {
		
	}

	public FreeBoard(int no, String subject, String writer, String content, String date, String etc) {
		super(no, subject, writer, content, date);
		this.etc = etc;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FreeBoard [etc=");
		builder.append(etc);
		builder.append("]");
		return builder.toString();
	}
	
	
}
