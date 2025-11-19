package com;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private long isbn;
	private int releaseYear;
	private int numPages;
	private String genre;
	private String publisher;
	
	private static int numBooksCreated = 0;
	
	public Book(String title, String author, long isbn, int releaseYear, int numPages, String genre, String publisher) {
		
		this.id = ++numBooksCreated;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.releaseYear = releaseYear;
		this.numPages = numPages;
		this.genre = genre;
		this.publisher = publisher;
		
	}
	
	public int getId() {
		
		return this.id;
		
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
	
	public long getIsbn() {
		
		return this.isbn;
		
	}
	
	public void setIsbn(long newIsbn) {
		
		this.isbn = newIsbn;
		
	}
	
	public int getReleaseYear() {
		
		return this.releaseYear;
		
	}
	
	public void setReleaseYear(int newReleaseYear) {
		
		this.releaseYear = newReleaseYear;
		
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
	
	public String getPublisher() {
		
		return this.publisher;
		
	}
	
	public void setPublisher(String newPublisher) {
		
		this.publisher = newPublisher;
		
	}
	
	public static int getNumBooksCreated() {
		
		return numBooksCreated;
		
	}
	
	/*
	
	public Book findBook(String title) {
		
	}
	
	*/
	
}
