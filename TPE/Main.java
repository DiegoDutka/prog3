package TPE;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String path = "C:/Users/diego/Downloads/datasets/dataset1.csv";
		Library libre = new Library(path);
		 ArrayList<Book> allBooks= libre.getAllBooks();
		 System.out.println(allBooks);
		
	
		

	}

}
