package praktikum4;

public class Textbook extends Book {
	private String bidangStudi;
	public Textbook(String title, String author, String bidangStudi) {
		super(title, author);
		this.bidangStudi = bidangStudi;
	}
	public String getBidangStudi() {
		return bidangStudi;
	}
	
}
