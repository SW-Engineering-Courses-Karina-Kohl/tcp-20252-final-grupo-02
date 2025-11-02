package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Book;

public class BookTest {
	
	@Test
	public void testBuilderBook() {
		
		String expectedTitle = "Admirável Mundo Novo";
		String expectedAuthor = "Aldous Huxley";
		long expectedIsbn = 9788525056009L;
		int expectedReleaseYear = 2014;
		int expectedNumPages = 312;
		String expectedGenre = "Ficção científica";
			
		Book newBook = new Book(expectedTitle, expectedAuthor, expectedIsbn, expectedReleaseYear, expectedNumPages, expectedGenre);
		
		assertEquals(1, newBook.getId());
		assertEquals(expectedTitle, newBook.getTitle());
		assertEquals(expectedAuthor, newBook.getAuthor());
		assertEquals(expectedIsbn, newBook.getIsbn());
		assertEquals(expectedReleaseYear, newBook.getReleaseYear());
		assertEquals(expectedNumPages, newBook.getNumPages());
		assertEquals(expectedGenre, newBook.getGenre());
		assertEquals(1, Book.getNumBooksCreated());
		
	}

}
