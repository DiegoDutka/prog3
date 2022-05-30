package TPE;

import java.util.ArrayList;

public class GenreNode {
	String genre;
	//int value;
	ArrayList<Book> booksByGenre;
	
	public String getGenre() {
		return genre;
	}
	public void add(Book book){
		String[] gBooks = book.getGenres();
		for (String genre : gBooks) {
			if(this.genre==genre){
				booksByGenre.add(book);
			}
		}
	}
	


}
