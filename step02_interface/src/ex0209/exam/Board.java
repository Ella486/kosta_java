package ex0209.exam;

public class Board {
	private int no;
    private String writer;
    private String subject;
    private String content;
    
    public Board () {}
    public Board (int no, String writer, String subject, String content) {
    	this.no = no;
    	this.writer = writer;
    	this.subject = subject;
    	this.content = content;
    }
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=");
		builder.append(no);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

    
}
