package Control;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private long isbn;
	private int releaseYear;
	private int numPages;
	private String genre;
	private static int numBooksCreated = 0;
	
	public Book(String title, String author, long isbn, int releaseYear, int numPages, String genre) {
		
		this.id = ++numBooksCreated;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.releaseYear = releaseYear;
		this.numPages = numPages;
		this.genre = genre;
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public String getTitle() {
		
		return this.title;
		
	}
	
	public String getAuthor() {
		
		return this.author;
		
	}
	
	public long getIsbn() {
		
		return this.isbn;
		
	}
	
	public int getReleaseYear() {
		
		return this.releaseYear;
		
	}
	
	public int getNumPages() {
		
		return this.numPages;
		
	}
	
	public String getGenre() {
		
		return this.genre;
		
	}
	
	public static int getNumBooksRegistered() {
		
		return numBooksCreated;
		
	}
	
}
