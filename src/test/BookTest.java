package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.AppSystem;
import com.model.Book;

public class BookTest {
	
	@Test
	public void testConstructor() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		String isbn = "9788-2505-0090";
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";

			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);	
		
		assertEquals(Book.getNumBooksCreated(), newBook.getId());
		assertEquals(title, newBook.getTitle());
		assertEquals(author, newBook.getAuthor());
		assertEquals(isbn, newBook.getIsbn());
		assertEquals(releaseYear, newBook.getReleaseYear());
		assertEquals(numPages, newBook.getNumPages());
		assertEquals(genre, newBook.getGenre());
		
	}
	
	@Test
	public void testCreateBook() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		String isbn = "2885-2505-6009";
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";

			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);	
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createBook(newBook);
		
		assertEquals(1, appSystem.getBooks().size());
		
	}
	
	@Test
	public void testDeleteBook() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		String isbn = "2005-2505-6000";
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";
			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);	
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createBook(newBook);
		appSystem.deleteBook(newBook);
		
		assertEquals(0, appSystem.getBooks().size());
		
	}

}
