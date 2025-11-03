package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Book;

public class BookTest {
	
	@Test
	public void testConstructor() {
		
		String title = "Admirável Mundo Novo";
		String author = "Aldous Huxley";
		long isbn = 9788525056009L;
		int releaseYear = 2014;
		int numPages = 312;
		String genre = "Ficção científica";
			
		Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);
		
		assertEquals(1, newBook.getId());
		assertEquals(title, newBook.getTitle());
		assertEquals(author, newBook.getAuthor());
		assertEquals(isbn, newBook.getIsbn());
		assertEquals(releaseYear, newBook.getReleaseYear());
		assertEquals(numPages, newBook.getNumPages());
		assertEquals(genre, newBook.getGenre());
		assertEquals(1, Book.getNumBooksCreated());
		
	}

}
