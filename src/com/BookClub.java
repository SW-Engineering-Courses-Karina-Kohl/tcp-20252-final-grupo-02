package com;

import java.util.ArrayList;

public class BookClub {
	
	private int id;
	private Creator creator;
	private String name;
	private ArrayList<User> participants;
	private ArrayList<Poll> polls;
	private ArrayList<Meeting> meetings;
	
	private static int numBookClubsCreated = 0;
	
	private static ArrayList<BookClub> bookClubs;
	
	public BookClub(Creator creator, String name) {
		
		this.id = ++numBookClubsCreated;
		this.creator = creator;
		this.name = name;
		this.participants = new ArrayList<User>();
		this.polls = new ArrayList<Poll>();
		this.meetings = new ArrayList<Meeting>();
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public Creator getCreator() {
		
		return this.creator;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public ArrayList<User> getParticipants() {
		
		return this.participants;
		
	}
	
	public ArrayList<Poll> getPolls() {
		
		return this.polls;
		
	}
	
	public ArrayList<Meeting> getMeetings() {
		
		return this.meetings;
		
	}
	
	public static int getNumBookClubsCreated() {
		
		return numBookClubsCreated;
		
	}
	
	public static ArrayList<BookClub> getBookClubs() {
		
		return bookClubs;
		
	}
	
	public static void addBookClub(BookClub newBookClub) {
		
		bookClubs.add(newBookClub);
		
	}
	
	public static void removeBookClub(BookClub selectedBookClub) {
		
		bookClubs.remove(selectedBookClub);
		
	}

}
