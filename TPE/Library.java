package TPE;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Book> allBooks;
	private ArrayList<GenreNode> genreNodes;

	public Library(String path) {
		this.allBooks = getBooks(path);
	}

	private ArrayList<Book> getBooks(String path){
		CSV_Reader reader = new CSV_Reader();
		ArrayList<Book> allBooks = new ArrayList<Book>();
		allBooks = reader.reader(path);
		return allBooks;
	}
	
	public ArrayList<Book> getAllBooks() {
		return new ArrayList<Book>(allBooks);
	}
	public void createGenreNode (ArrayList<Book> allBooks){
		for (Book book : allBooks) {
			for (GenreNode node : genreNodes) {
				node.add(book);
				
			}
		}
		
	}
	
}
