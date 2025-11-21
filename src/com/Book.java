package com;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private String isbn;
	private int releaseYear;
	private int numPages;
	private String genre;

	
	private static int numBooksCreated = 0;
	
	public Book(String title, String author, String isbn, int releaseYear, int numPages, String genre) {
		this.id = ++numBooksCreated;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.releaseYear = releaseYear;
		this.numPages = numPages;
		this.genre = genre;
	}

		public Book(int id, String title, String author, String isbn, int releaseYear, int numPages, String genre) {
		
			this.id = id;
			this.title = title;
			this.author = author;
			this.isbn = isbn;
			this.releaseYear = releaseYear;
			this.numPages = numPages;
			this.genre = genre;

			if( id > numBooksCreated) 
				numBooksCreated = id;
		
	}
	



	public int getId() {
		
		return this.id;
		
	}

	public void setId(int newId) {
		
		this.id = newId;
		
	}
	
	public String getTitle() {
		
		return this.title;
		
	}
	
	public void setTitle(String newTitle) {
		
		this.title = newTitle;
		
	}

	public String getAuthor() {
		
		return this.author;
		
	}

	public void setAuthor(String newAuthor) {
		
		this.author = newAuthor;
		
	}
	

	public String getIsbn() {
		return this.isbn;
	}



	public void setIsbn(String newIsbn) {
		
		this.isbn = newIsbn;
		
	}
	

	
	public int getReleaseYear() {
		
		return this.releaseYear;
		
	}

	public int setReleaseYear(int newReleaseYear) {
		
		return this.releaseYear = newReleaseYear;
		
	}
	


	
	public int getNumPages() {
		
		return this.numPages;
		
	}

	public void setNumPages(int newNumPages) {
		
		this.numPages = newNumPages;
		
	}
	

	
	public String getGenre() {
		
		return this.genre;
		
	}

	public void setGenre(String newGenre) {
		
		this.genre = newGenre;
		
	}

	
	
	public static int getNumBooksCreated() {
		
		return numBooksCreated;
	}

	// Converte o objeto para uma String legivel	
@Override
	public String toString() {
		return String.format("Book{id=%d, title=%s, author=%s, isbn=%s, releaseYear=%d, numpages=%d, genre=%s}", id, title, author, isbn, releaseYear, numPages, genre);
	}
	

	public String toCsvLine() {
    	return id + "," + title + "," + author + "," + isbn + "," + releaseYear + "," + numPages + "," + genre;
	}

}
