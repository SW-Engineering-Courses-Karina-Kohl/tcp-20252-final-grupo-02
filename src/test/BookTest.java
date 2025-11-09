package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Book;
import com.Main;

public class BookTest {
	
	@Test
	public void testConstructor() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		long isbn = 9788525056009L;
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";
		String publisher = "Biblioteca Azul";
			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre, publisher);	
		
		assertEquals(Book.getNumBooksCreated(), newBook.getId());
		assertEquals(title, newBook.getTitle());
		assertEquals(author, newBook.getAuthor());
		assertEquals(isbn, newBook.getIsbn());
		assertEquals(releaseYear, newBook.getReleaseYear());
		assertEquals(numPages, newBook.getNumPages());
		assertEquals(genre, newBook.getGenre());
		assertEquals(publisher, newBook.getPublisher());
		
	}
	
	@Test
	public void testCreateBook() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		long isbn = 9788525056009L;
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";
		String publisher = "Biblioteca Azul";
			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre, publisher);	
		
		Main main = new Main();
		
		main.createBook(newBook);
		
		assertEquals(1, main.getBooks().size());
		
	}
	
	@Test
	public void testDeleteBook() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		long isbn = 9788525056009L;
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";
		String publisher = "Biblioteca Azul";
			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre, publisher);	
		
		Main main = new Main();
		
		main.createBook(newBook);
		main.deleteBook(newBook);
		
		assertEquals(0, main.getBooks().size());
		
	}

}
