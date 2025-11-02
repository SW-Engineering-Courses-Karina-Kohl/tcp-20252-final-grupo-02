package com;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<BookClub> joinedBookClubs;
	
	private static int numUsersCreated = 0;
	
	private static ArrayList<User> users;
	
	// private static final int MAX_BOOKCLUBS_PER_USER = 20;
	
	public User(String name, String surname, String email, String password) {
		
		this.id = ++numUsersCreated;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.joinedBookClubs = new ArrayList<BookClub>();
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getSurname() {
		
		return this.surname;
		
	}
	
	public String getEmail() {
		
		return this.email;
		
	}
	
	public String getPassword() {
		
		return this.password;
		
	}
	
	public ArrayList<BookClub> getJoinedBookClubs() {
		
		return this.joinedBookClubs;
		
	}
	
	public static int getNumUsersCreated() {
		
		return numUsersCreated;
		
	}
	
	public static ArrayList<User> getUsers() {
		
		return users;
		
	}
	
	public static void addUser(User newUser) {
		
		users.add(newUser);
		
	}
	
	public static void removeUser(User selectedUser) {
		
		users.remove(selectedUser);
		
	}
	
	/*
	
	public User findUser(String email) {
		
	}
	
	*/

}
