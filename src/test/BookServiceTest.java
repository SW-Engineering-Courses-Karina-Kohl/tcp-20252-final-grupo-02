package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.model.Book;
import com.service.BookService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BookServiceTest {

    private static final String TEST_PATH = "src/data/files/Books.csv";
    private static final Book book1 = new Book("Dom Casmurro", "Machado de Assis", "9788580700688", 2020, 328, "Realismo");
    private static final Book book2 = new Book("O Pequeno Príncipe", "Machado de Assis", "978-0152465032", 1959, 96, "Infanto-Juvenil");
    // Limpa o arquivo antes de cada teste
    private void resetFile() throws IOException {
        File f = new File(TEST_PATH);
        if (f.exists()) f.delete();
        f.createNewFile();
    }
    
    private boolean equalsBook(Book book1, Book book2) {
    	
    	return 
    			book1.getTitle().equals(book2.getTitle()) &&
    			book1.getAuthor().equals(book2.getAuthor()) &&
    			book1.getIsbn().equals(book2.getIsbn()) &&
    			book1.getReleaseYear() == book2.getReleaseYear() &&
    			book1.getNumPages() == book2.getNumPages() &&
    			book1.getGenre().equals(book2.getGenre());
    	
    }
    
    @Test
    public void testConstructor() throws IOException{
    	
    	resetFile();
    	
    	ArrayList<Book> books = new ArrayList<>();
        
        books.add(book1);
        books.add(book2);
        
        BookService bookService1 = new BookService();
        
        bookService1.registerBook("Dom Casmurro", "Machado de Assis", "9788580700688", 2020, 328, "Realismo");
        bookService1.registerBook("O Pequeno Príncipe", "Machado de Assis", "978-0152465032", 1959, 96, "Infanto-Juvenil");
        
    	bookService1.saveAllBooks();
    	
    	BookService bookService2 = new BookService();
    	
    	assertEquals(books.size(), bookService2.getBooks().size());
    	
    	for(int i = 0; i < books.size(); i++) {
    		
    		assertTrue(equalsBook( books.get(i), bookService2.getBooks().get(i) ) );
    		
    	}
        
        
    }
    

    @Test
    public void testSaveAndLoad() throws IOException{
    	resetFile();
    	
    	ArrayList<Book> books = new ArrayList<>();
        
        books.add(book1);
        books.add(book2);
        
        BookService bookService1 = new BookService();
        
        bookService1.registerBook("Dom Casmurro", "Machado de Assis", "9788580700688", 2020, 328, "Realismo");
        bookService1.registerBook("O Pequeno Príncipe", "Machado de Assis", "978-0152465032", 1959, 96, "Infanto-Juvenil");
        
        BookService bookService2 = new BookService();
        
    	bookService1.saveAllBooks();
    	
    	ArrayList<Book> loadedBooks = bookService2.loadBooks();
    	
    	assertEquals(books.size(), bookService2.getBooks().size());
    	
    	for(int i = 0; i < books.size(); i++) {
    		
    		assertTrue(equalsBook( books.get(i), bookService2.getBooks().get(i) ) );
    		assertTrue(equalsBook( books.get(i), loadedBooks.get(i) ) );

    	}
        
    }
    
    @Test
    public void testDeleteBooks() throws IOException{
    	resetFile();
    	
    	ArrayList<Book> books = new ArrayList<>();
        
        books.add(book1);
        books.add(book2);
        
        BookService bookService1 = new BookService();
        
        bookService1.registerBook("Dom Casmurro", "Machado de Assis", "9788580700688", 2020, 328, "Realismo");
        bookService1.registerBook("O Pequeno Príncipe", "Machado de Assis", "978-0152465032", 1959, 96, "Infanto-Juvenil");
        
        books.remove(1);
        
        Book bookToDelete = bookService1.getBooks().get(1);
        
        bookService1.deleteBook(bookToDelete);
    	
    	assertEquals(books.size(), bookService1.getBooks().size());
    	
    	for(int i = 0; i < books.size(); i++) {
    		
    		assertTrue(equalsBook(books.get(i), bookService1.getBooks().get(i)));

    	}
        
    }
    
    @Test
    public void findBookByIsbn() throws IOException{
    	resetFile();
    	
    	ArrayList<Book> books = new ArrayList<>();
        
        books.add(book1);
        books.add(book2);
        
        BookService bookService1 = new BookService();
        
        bookService1.registerBook("Dom Casmurro", "Machado de Assis", "9788580700688", 2020, 328, "Realismo");
        bookService1.registerBook("O Pequeno Príncipe", "Machado de Assis", "978-0152465032", 1959, 96, "Infanto-Juvenil");
    	
    	for(int i = 0; i < books.size(); i++) {
    		
    		assertTrue(equalsBook(books.get(i), bookService1.findBookByIsbn(books.get(i).getIsbn())));

    	}
        
    }
    
    

}

