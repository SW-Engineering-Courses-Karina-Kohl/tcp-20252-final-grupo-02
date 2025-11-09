package com;

import java.util.ArrayList;

public class Main {

	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<BookClub> bookClubs = new ArrayList<BookClub>();
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();
	private ArrayList<Poll> polls = new ArrayList<Poll>();
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<Book> getBooks() {
		
		return books;
		
	}
	
	public void createBook(Book newBook) {
		
		books.add(newBook);
		
	}
	
	public void deleteBook(Book book) {
		
		books.remove(book);
		
	}
	
	public ArrayList<BookClub> getBookClubs() {
		
		return bookClubs;
		
	}
	
	public void createBookClub(BookClub newBookClub) {
		
		bookClubs.add(newBookClub);
		
	}
	
	public void deleteBookClub(BookClub bookClub) {
		
		bookClubs.remove(bookClub);
		
	}
	
	public ArrayList<Meeting> getMeetings() {
		
		return meetings;
		
	}
	
	public void createMeeting(Meeting newMeeting) {
		
		meetings.add(newMeeting);
		
	}
	
	public void deleteMeeting(Meeting meeting) {
		
		meetings.remove(meeting);
		
	}

	public ArrayList<Poll> getPolls() {
		
		return polls;
		
	}
	
	public void createPoll(Poll newPoll) {
		
		polls.add(newPoll);
		
	}
	
	public void deletePoll(Poll poll) {
		
		polls.remove(poll);
		
	}
	
	public ArrayList<User> getUsers() {
		
		return users;
		
	}
	
	public void createUser(User newUser) {
		
		users.add(newUser);
		
	}
	
	public void deleteUser(User user) {
		
		users.remove(user);
		
	}
	
	public static void main(String[] args) {

		// ...

	}

}
